package com.myUtil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowRowPanel extends JPanel{
	private String text = null;
	private ShowLabel lblText = null;
	private JPanel spacePanel = new JPanel();
	
	public ShowRowPanel(String text) {
		super();
		this.setLayout(new GridBagLayout());
		 lblText = new ShowLabel(text);
		
		spacePanel.setBackground(CColor.SHOWROWCOLOR);
		this.add(spacePanel, new GBC(0,0).setFill(GBC.BOTH).setWeight(0.1, 1));
		
		//lblText.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
		this.add(lblText, new GBC(1,0).setFill(GBC.BOTH).setWeight(0.6, 1));
	}
	
	public void setNum(int num) {
		lblText.setNum(num);
	}
}

class ShowLabel extends JLabel {
	private String pretext = null;
	private int num = 0;


	public ShowLabel(String text) {
		super();
		this.pretext = text;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		Font font = g.getFont();
		
		g.setFont(new Font("Cambria",Font.BOLD,15));
		g.drawString(pretext + num, 0, 30);
		
		
		g.setFont(font);
		g.setColor(c);
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
