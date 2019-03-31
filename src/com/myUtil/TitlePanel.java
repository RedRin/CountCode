package com.myUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

public class TitlePanel extends MyPanel{
	public static final Dimension TITLEPANEL_DIM = new Dimension(CountCodeClient.FRAME_WIDTH, CountCodeClient.FRAME_HEIGHT/8);
	
	private ButtonBox rightTopBox = null;
	private MinButton minButton= null;
	private CloseButton closeButton = null;
	


	public TitlePanel(CountCodeClient ccc) {
		super(ccc);
		this.setBackground(CColor.TITLEPANEL_COLOR);
		
		this.setLayout(null);
		//������Ͻǵİ�ť��
		rightTopBox = new ButtonBox(ccc);
		rightTopBox.setSize(ccc.FRAME_WIDTH/5, ccc.FRAME_HEIGHT);
		rightTopBox.setLayout(new GridLayout(1,2, 3,0));
		rightTopBox.setBackground(CColor.TITLEPANEL_COLOR);
		this.add(rightTopBox);
		
		//���밴ť
		minButton = new MinButton("���", ccc);
		rightTopBox.add(minButton);
		
		closeButton = new CloseButton("�ر�",ccc);
		rightTopBox.add(closeButton);
		
	}
	
	public void adjust() {
		rightTopBox.setPreferredSize(new Dimension(getWidth()/10,getHeight()));
		
		Point rightTopPoint = new Point(getWidth() - rightTopBox.getWidth() - 3,0);
		rightTopBox.setLocation(rightTopPoint);		
		closeButton.repaint();
	}
	
	
}
