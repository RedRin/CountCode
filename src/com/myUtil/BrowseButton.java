package com.myUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


public class BrowseButton extends MyButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Color NORMALCOLOR = new Color(0x4a, 0x4a, 0x4a);
	public static final Color HOVERCOLOR = new Color(0xa3,0xa3,0xa3);
	public static final Color PRESSCOLOR = new Color(0xed, 0xd2, 0x64);
	
	protected Image offScreenImg = null;
	
	private Color frontColor = NORMALCOLOR;
	private Image browserImg = null;
	private Image browserNormalImg = null;
	private Image browserHoverImg = null;
	private BufferedImage bi= null;
	
	//private FileDialog fileDialog = null;    //用这个不能选择文件夹
	private JFileChooser fileChooser = null;

	public BrowseButton(String text, CountCodeClient ccc) {
		super(text, ccc);
		this.addMouseListener(new MouseHoverAdapter()); 
		
		try {
			//以后都用BUfferedImage读图片，就不会被优化麻烦死了
			bi = ImageIO.read(CloseButton.class.getClassLoader().getResource("Imgs/browserWhite.png"));
			browserNormalImg = bi.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH);
			bi = ImageIO.read(CloseButton.class.getClassLoader().getResourceAsStream("Imgs/browserBlack.png"));
			browserHoverImg = bi.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH);
			browserImg = browserNormalImg;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		Color c= g.getColor();
		Font font = g.getFont();	
			
		//前色
		g.setColor(frontColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.drawImage(browserImg, 6, 2,CountCodeClient.FRAME_HEIGHT/9,CountCodeClient.FRAME_HEIGHT/9, null);
				
		g.setFont(font);
		g.setColor(c);
	}
	
	public void update(Graphics g) {
		if(offScreenImg == null) {
			offScreenImg = this.createImage(this.getWidth(),this.getHeight());
		}
		
		Graphics gOffScreen = offScreenImg.getGraphics();
		paint(gOffScreen);
		
		g.drawImage(offScreenImg, 0, 0, null);

		
	}
	
	class MouseHoverAdapter extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			frontColor = HOVERCOLOR;
			browserImg = browserHoverImg;
		}
		
		public void mouseExited(MouseEvent e) {
			frontColor = NORMALCOLOR;
			browserImg = browserNormalImg;
		}
		
		public void mousePressed(MouseEvent e) {
			frontColor = PRESSCOLOR;
		}
		
		public void mouseClicked(MouseEvent e) {
			fileChooser = new JFileChooser(".");
			fileChooser.setMultiSelectionEnabled(true);
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fileChooser.showDialog(ccc, "选择代码文件");
			
			
			//ccc.files = fileChooser.getSelectedFiles();
			File[] files = fileChooser.getSelectedFiles();  //java对待引用局部变量，也是用的引用计数
			if(files.length != 0 && files != null) {
				ccc.files = files;
				ccc.footPanel.pathlbl.setText(ccc.files[0].getPath());	
			} 
			
		}
	}
}
