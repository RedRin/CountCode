package com.myUtil;

import javax.swing.JButton;

public class MyButton extends JButton{
	protected CountCodeClient ccc = null;
	
	public MyButton(String text, CountCodeClient ccc) {
		super(text);
		this.ccc = ccc;
	}
}
