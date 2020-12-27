package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class MyFrameTemplate extends JFrame{
	public MyFrameTemplate() {
		this.setSize(1200,800);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = screen.width / 2-getWidth() /2;
		int y =  screen.height / 2 - getHeight()/2;
		this.setTitle("ssz¿«PosMachine");
		this.setResizable(false);
		this.setLocation(x,y);
	}
	public void init() {
		initComponent();
		initEvent();
	}
	public void initComponent() {
		
	}
	public void initEvent() {
		
	}
	
}