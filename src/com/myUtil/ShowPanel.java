package com.myUtil;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ShowPanel extends MyPanel{
	
	public ShowRowPanel showRowNormal = new ShowRowPanel("Normal Lines : ");
	public ShowRowPanel showRowSpace = new ShowRowPanel("Space Lines : ");
	public ShowRowPanel showRowComment = new ShowRowPanel("Comment Lines : ");
	
	
	public ShowPanel(CountCodeClient ccc) {
		super(ccc);
		
		this.setBackground(CColor.SHOW_COLOR);
		this.setLayout(new GridLayout(3,1, 0, 1));
		
		showRowNormal.setBackground(CColor.SHOWROWCOLOR);
		showRowSpace.setBackground(CColor.SHOWROWCOLOR);
		showRowComment.setBackground(CColor.SHOWROWCOLOR);
		
		this.add(showRowNormal);
		this.add(showRowSpace);
		this.add(showRowComment);
	}
	
	
}
