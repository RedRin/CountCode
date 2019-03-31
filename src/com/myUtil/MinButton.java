package com.myUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MinButton extends MyButton{
	public static final Color NORMALCOLOR = CColor.TITLEPANEL_COLOR;
	public static final Color HOVERCOLOR = new Color(0xe8,0xdc,0xb9);
	public static final Color PRESSCOLOR = new Color(0xed, 0xd2, 0x64);
	
	protected Image offScreenImg = null;
	
	private Color frontColor = NORMALCOLOR;
	
	public MinButton(String text, CountCodeClient ccc) {
		super(text, ccc);
		this.addMouseListener(new MouseHoverAdapter());
	}
	
	@Override
	public void paint(Graphics g) {
		Color c= g.getColor();
		Font font = g.getFont();	
		
		//ǰɫ
		g.setColor(frontColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.black);
		g.fillRect(12, 13, 14, 4);
				
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
			ccc.setExtendedState(JFrame.ICONIFIED);
		}
	}
}
