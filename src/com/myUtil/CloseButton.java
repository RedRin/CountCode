package com.myUtil;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.myUtil.MinButton.MouseHoverAdapter;

public class CloseButton extends MyButton{
	public static final Color NORMALCOLOR = CColor.TITLEPANEL_COLOR;
	public static final Color HOVERCOLOR = new Color(0xe8,0xdc,0xb9);
	public static final Color PRESSCOLOR = new Color(0xed, 0xd2, 0x64);
	
	protected Image offScreenImg = null;
	
	private Color frontColor = NORMALCOLOR;
	private Image closeImg = null;
	private BufferedImage bi= null;

	public CloseButton(String text, CountCodeClient ccc) {
		super(text, ccc);
		this.addMouseListener(new MouseHoverAdapter()); 
		
		try {
			//以后都用BUfferedImage读图片，就不会被优化麻烦死了
			bi = ImageIO.read(CloseButton.class.getClassLoader().getResource("Imgs/close21.png"));
			closeImg = bi.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH);
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
		
		g.drawImage(closeImg, 6, 0,ccc.FRAME_HEIGHT/8,ccc.FRAME_HEIGHT/8, null);
				
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
		}
		
		public void mouseExited(MouseEvent e) {
			frontColor = NORMALCOLOR;
		}
		
		public void mousePressed(MouseEvent e) {
			frontColor = PRESSCOLOR;
		}
		
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		}
	}
	
}
