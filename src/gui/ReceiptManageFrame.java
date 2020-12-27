package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class ReceiptManageFrame extends MyFrameTemplate implements ActionListener{
	Color heavyBlue = new Color(0,89,171);
	Color lightBlue = new Color(142,180,227);
	////외부 패널 선언//////
	JPanel topPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JPanel lPanel = new JPanel();
	JPanel rPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	////위쪽 패널 컴포넌트 선언////
	JLabel title = new JLabel("영수증 관리");
	////왼쪽패널 컴포넌트 선언////
	JLabel lTitle = new JLabel("영수증List");
	String[] lHeader = {"시간","물품정보"};
	String[][] lContent = {
			{"18:15","소주,맥주"},
			{"18:20","오꼬노미야끼,맥주"}
			};
	JTable lTable = new JTable(lContent,lHeader);
	JScrollPane lScrollPane = new JScrollPane(lTable);
	////오른쪽패널 컴포넌트 선언////
	String[] rHeader = {"물픔","개수","금액"};
	String[][] rContent = {
			{"오꼬노미야끼","1","15000"},
			{"맥주","4","16000"}
			};
	JTable rTable = new JTable(rContent,rHeader);
	JScrollPane rScrollPane = new JScrollPane(rTable);
	JButton rePrintBtn = new JButton("재출력");
	JButton refundBtn = new JButton("반품");
	////////외부 컴포넌트///////
	JButton backBtn = new JButton("뒤로가기");
	public ReceiptManageFrame() {
		init();
	}
	
	public void initComponent()
	{
		/////////외부 프레임 레이아웃 설정////////
		FlowLayout frameLayout = new FlowLayout(FlowLayout.CENTER);
		frameLayout.setVgap(50);
		setLayout(frameLayout);
		setBackground(Color.blue);
		////////위쪽 패널 컴포넌트 설정/////////
		topPanel.setPreferredSize(new Dimension(600,100));
		title.setPreferredSize(new Dimension(600,100));//타이틀레이블 설정
		title.setFont(new Font("couture-bld", Font.PLAIN, 100));
		title.setOpaque(true); 
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBackground(lightBlue);
		topPanel.add(title);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		///////가운데 패널 컴포넌트 설정/////////
		mainPanel.setPreferredSize(new Dimension(700,400));
		mainPanel.setBackground(heavyBlue);
		/////가운데 좌측패널 설정//////
		lPanel.setPreferredSize(new Dimension(345,390));
		lPanel.setBackground(lightBlue);
		lPanel.add(lTitle);
		lScrollPane.setPreferredSize(new Dimension(345,380));
		lPanel.add(lScrollPane);
		////가운데 우측패널 설정//////
		rPanel.setPreferredSize(new Dimension(345,390));
		rPanel.setBackground(heavyBlue);
		rPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		rScrollPane.setPreferredSize(new Dimension(345,350));
		rPanel.add(rScrollPane);
		rPanel.add(rePrintBtn);
		rPanel.add(refundBtn);
		////main패널에 r,l패널 추가///
		mainPanel.add(lPanel);
		mainPanel.add(rPanel);
		//////아래 패널 설정 ////////////////
		FlowLayout bLayout = new FlowLayout(FlowLayout.RIGHT);
		bottomPanel.setPreferredSize(new Dimension(1000,150));
		bottomPanel.setLayout(bLayout);
		backBtn.setFont(new Font("couture-bld", Font.PLAIN, 30));
		backBtn.setPreferredSize(new Dimension(200,80));//뒤로가기 버튼 설
		bottomPanel.add(backBtn);
		//////////top,main,bottom 패널 추가///////////
		this.add(topPanel);
		this.add(mainPanel);
		this.add(bottomPanel);
		
	}
	public void initEvent()
	{
		backBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.equals(backBtn))
		{
			this.dispose();
			MainFrame mf = new MainFrame();
			mf.init();
		}
	}
	public static void main(String[] args) {
		ReceiptManageFrame rmf = new ReceiptManageFrame();
		rmf.setVisible(true);
		//rmf.init();
	}
}
