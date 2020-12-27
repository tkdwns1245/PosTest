package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class test extends MyFrameTemplate{
	////외부 패널 선언//////
	JPanel mainPanel = new JPanel();
	////위쪽 패널 컴포넌트 선언////
	JLabel title = new JLabel("영수증 관리");
	////왼쪽패널 컴포넌트 선언////
	String[] header = {"물품명","가격","개수","금액"};
	String[][] content = {
		{"콜라","1000","2","2000"},
		{"사이다","1000","1","1000"},
		{"오꼬노미야끼","15000","1","15000"},
		{"소주","4000","4","16000"}
		};
	JTable lContentTable = new JTable(content,header);
	JScrollPane scrollPane = new JScrollPane(lContentTable);
	
	////오른쪽패널 컴포넌트 선언////
	public test() {
		
	}
	public void initComponent()
	{
		/////////외부 프레임 레이아웃 설정////////
		mainPanel.setBackground(Color.green);
		mainPanel.add(scrollPane);
		this.add(mainPanel);
		
		
	}
	public void initEvent()
	{}
	public static void main(String[] args) {
		test rmf = new test();
		rmf.init();
	}
}
