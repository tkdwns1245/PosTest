package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TableManageFrame extends MyFrameTemplate implements ActionListener{
	Color heavyBlue = new Color(0,89,171);
	Color lightBlue = new Color(142,180,227);
	
	JLabel title = new JLabel("테이블 관리");
	
	JPanel topPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
	JButton tableAddBtn = new JButton("테이블 추가");
	JButton tableDelBtn = new JButton("테이블 삭제");
	JButton tableMovBtn = new JButton("테이블 이동");
	JButton backBtn = new JButton("뒤로가기");
	
	ArrayList<JButton> tableInfoList = new ArrayList<JButton>();
	
	public TableManageFrame() {
		for(int i = 0; i <12; i++)
		{
			tableInfoList.add(new JButton((i+1) + "번 테이블"));
			tableInfoList.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			tableInfoList.get(i).setBackground(heavyBlue);
			tableInfoList.get(i).setFont(new Font("couture-bld", Font.PLAIN, 20));
			tableInfoList.get(i).setForeground(Color.white);
		}
		init();
	}
	public void initComponent()
	{
		FlowLayout FrameLayout = new FlowLayout();
		FrameLayout.setVgap(20);
		this.setLayout(FrameLayout);
		///////////top Panel 설정//////////
		topPanel.setPreferredSize(new Dimension(1000,130));
		title.setPreferredSize(new Dimension(600,100));//타이틀레이블 설정
		title.setOpaque(true); 
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBackground(lightBlue);
		Font titleFont = new Font("couture-bld", Font.PLAIN, 80);
		title.setFont(titleFont);
		topPanel.add(title);
		///////////mid Panel 설정/////////
		midPanel.setPreferredSize(new Dimension(1000,500));
		midPanel.setLayout(new GridLayout(0,5,10,10));
		for(JButton l : tableInfoList)
		{
			midPanel.add(l);
		}
		/////////////bottom Panel 설정///////
		bottomPanel.setPreferredSize(new Dimension(1000,100));
		FlowLayout bfl = new FlowLayout(FlowLayout.CENTER);
		bfl.setHgap(100);
		bottomPanel.setLayout(bfl);
		tableAddBtn.setPreferredSize(new Dimension(150,50));
		bottomPanel.add(tableAddBtn);
		tableDelBtn.setPreferredSize(new Dimension(150,50));
		bottomPanel.add(tableDelBtn);
		tableMovBtn.setPreferredSize(new Dimension(150,50));
		bottomPanel.add(tableMovBtn);
		backBtn.setPreferredSize(new Dimension(150,50));
		bottomPanel.add(backBtn);
		
		///////////Frame 에 Panel 추가///////////////
		this.add(topPanel);
		this.add(midPanel);
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
}
