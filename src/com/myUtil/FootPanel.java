package com.myUtil;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;


public class FootPanel extends MyPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Dimension FOOTPANEL_DIM = new Dimension(CountCodeClient.FRAME_WIDTH, CountCodeClient.FRAME_HEIGHT/8);
	
	public JLabel pathlbl = new JLabel("��ѡ���ļ�");
	public BrowseButton browseButton = null;
	
	public FootPanel(CountCodeClient ccc) {
		super(ccc);
		this.setBackground(CColor.FOOTPANEL_COLOR);
		
		this.setLayout(new BorderLayout(6,0));
		
		//��������ť
		browseButton = new BrowseButton("",ccc);
		this.add(browseButton, BorderLayout.WEST);
		
		//���·����ǩ

		pathlbl.setFont(new Font("΢���ź�", Font.BOLD, 15));
		this.add(pathlbl);
	}
	
	public void adjust() {
		//browseButton.setPreferredSize(new Dimension(FOOTPANEL_DIM.width/9, FOOTPANEL_DIM.height));
	}
	
}
