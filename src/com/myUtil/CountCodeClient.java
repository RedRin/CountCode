package com.myUtil;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * �в�����
 * @author Remilia
 *
 */

public class CountCodeClient extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 400;
	public static final int FRAME_HEIGHT = 200;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Point pressPoint = new Point();
	public ImageIcon icon = null;
	
	public TitlePanel titlePanel = new TitlePanel(this);
	public ContentPanel contentPanel = new ContentPanel(this);
	public FootPanel footPanel = new FootPanel(this);
	
	public File[] files = null;
	
	public static void main(String args[]) {
		new CountCodeClient().launchFrame(); 
	}
	
	public void launchFrame() {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true);
		
		//ͼ������
		icon = new ImageIcon(CountCodeClient.class.getClassLoader().getResource("Imgs/icon.png"));
		//Image icon = toolkit.getImage(CountCodeClient.class.getClassLoader().getResource("Imgs/icon.png"));
		this.setIconImage(icon.getImage());
		
		//��������Ļ�м�
		int tempX = (toolkit.getScreenSize().width - FRAME_WIDTH)/2;
		int tempY = (toolkit.getScreenSize().height - FRAME_HEIGHT)/2;
		this.setLocation(tempX, tempY);
		
		componentAdd();
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setCursor(new Cursor(Cursor.MOVE_CURSOR));
				pressPoint.x = e.getX();
				pressPoint.y = e.getY();
			}
			
			public void mouseReleased(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				//ʵ���϶������
				Point p = new Point(getLocation().x + e.getX() - pressPoint.x, getLocation().y + e.getY() - pressPoint.y);
				setLocation(p);
			}
		});
		
		this.setVisible(true);  //���˳�����Ҫ

		componentAdjust();
		
	}
	
	
	
	public void componentAdd() {
		//�����������Ͻǰ�ť����
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setPreferredSize(TitlePanel.TITLEPANEL_DIM);  //borderLayout�иı�������СҪ�����	setPreferredSize
		
		this.add(contentPanel, BorderLayout.CENTER);
		
		this.add(footPanel, BorderLayout.SOUTH);
		footPanel.setPreferredSize(FootPanel.FOOTPANEL_DIM);
	}
	
	/**
	 * Ϊ�˽��setVisible(true) �����getWidth()�ȵ�����
	 */
	public void componentAdjust() {
		titlePanel.adjust();
		
		footPanel.adjust();
		
		contentPanel.adjust();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}
}
