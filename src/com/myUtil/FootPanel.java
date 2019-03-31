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
	
	public JLabel pathlbl = new JLabel("请选择文件");
	public BrowseButton browseButton = null;
	
	public FootPanel(CountCodeClient ccc) {
		super(ccc);
		this.setBackground(CColor.FOOTPANEL_COLOR);
		
		this.setLayout(new BorderLayout(6,0));
		
		//添加浏览按钮
		browseButton = new BrowseButton("",ccc);
		this.add(browseButton, BorderLayout.WEST);
		
		//添加路径标签

		pathlbl.setFont(new Font("微软雅黑", Font.BOLD, 15));
		this.add(pathlbl);
	}
	
	public void adjust() {
		//browseButton.setPreferredSize(new Dimension(FOOTPANEL_DIM.width/9, FOOTPANEL_DIM.height));
	}
	
}
