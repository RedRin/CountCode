package com.myUtil;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	protected CountCodeClient ccc = null;
	public MyPanel(CountCodeClient ccc) {
		super();
		this.ccc = ccc;
	}
}
