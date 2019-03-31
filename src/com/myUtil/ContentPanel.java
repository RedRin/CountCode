package com.myUtil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;


public class ContentPanel extends MyPanel{
	public static final Dimension CONTENTPANEL_DIM = new Dimension(CountCodeClient.FRAME_WIDTH, CountCodeClient.FRAME_HEIGHT - TitlePanel.TITLEPANEL_DIM.height - FootPanel.FOOTPANEL_DIM.height);
	
	public CalcButton calcButton = null;
	public ShowPanel showPanel = null;
	
	
	public ContentPanel(CountCodeClient ccc) {
		super(ccc);
		this.setBackground(CColor.CONTENTPANEL_COLOR);
		
		//²¼¾Ö
		this.setLayout(new GridBagLayout());
		
		calcButton = new CalcButton("", ccc);
		this.add(calcButton, new GBC(0,0).setFill(GBC.BOTH).setWeight(0.3,1));
		showPanel = new ShowPanel(ccc);
		this.add(showPanel, new GBC(1,0).setFill(GBC.BOTH).setWeight(0.7,1));
	}
	
	public void adjust() {
		calcButton.setPreferredSize(new Dimension(CONTENTPANEL_DIM.width / 4,CONTENTPANEL_DIM.height));
	}
}
