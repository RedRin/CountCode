package com.myUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.myUtil.CloseButton.MouseHoverAdapter;

public class CalcButton extends MyButton{
	
	protected Image offScreenImg = null;
	
	private Color frontColor = CColor.CLACFRONTCOLOR;
	private Color bgColor = CColor.CLACBGCOLOR;

	public CalcButton(String text, CountCodeClient ccc) {
		super(text, ccc);
		this.addMouseListener(new MouseHoverAdapter()); 
			
	}
	
	@Override
	public void paint(Graphics g) {
		Color c= g.getColor();
		Font font = g.getFont();	
		
		g.setColor(bgColor);
		g.fillRect(0, 0, 200, 300);
		//ǰɫ
		g.setColor(frontColor);
		g.setFont(new Font("BroadWay",Font.BOLD, 150));
		g.drawString("C", 13, 125);
		
				
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
			frontColor = CColor.CLACBGCOLOR;
			bgColor = CColor.CLACFRONTCOLOR;
		}
		
		public void mouseExited(MouseEvent e) {
			frontColor = CColor.CLACFRONTCOLOR;
			bgColor = CColor.CLACBGCOLOR;
		}
		
		public void mousePressed(MouseEvent e) {
			
		}
		
		public void mouseClicked(MouseEvent e) {
			if(ccc.files != null && ccc.files.length != 0) {
				CountSource cs = new CountSource();
				cs.count(ccc.files);
				ccc.contentPanel.showPanel.showRowNormal.setNum(cs.getNormalLines());
				ccc.contentPanel.showPanel.showRowSpace.setNum(cs.getWhitespace());
				ccc.contentPanel.showPanel.showRowComment.setNum(cs.getCommentLines());
				
				ccc.contentPanel.repaint();
				
				
			}
		}
	}
}
