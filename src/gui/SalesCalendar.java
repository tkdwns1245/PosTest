package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import manage.AccountsManage;
import manage.CategoriManage;

public class SalesCalendar extends MyFrameTemplate implements ActionListener{
	
	AccountsManage am;
	
	AccFrame af;
	
	Color heavyBlue = new Color(0,89,171);
	Color lightBlue = new Color(142,180,227);
	
	JPanel topPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	///////////topPanel 컴포넌트////////////
	JLabel title = new JLabel("Sales Calendar");
	Font titleFont = new Font("couture-bld", Font.PLAIN, 100);
	///////////midPanel 컴포넌트 ////////////
	JLabel month = new JLabel("4월달\n매출현황");
	JPanel midRPanel = new JPanel();
	JButton[] salesLabel = new JButton[31];
	//////////bottomPanel 컴포넌트//////////
	JLabel totalL = new JLabel("이번달 총매출");
	JLabel pNumL = new JLabel("이번달 총 방문자수");
	JTextField totalTF = new JTextField(10);	//뭐임? 뭐임? 이거 뭐임????대체 뭐임???
	JTextField pNumTF = new JTextField(10);		//뭐임? 뭐임? 이거 뭐임????대체 뭐임???	아아아 납득
	JButton accBtn = new JButton("정산");
	JButton backBtn = new JButton("뒤로가기");
	Font backBtnFont = new Font("couture-bld", Font.PLAIN, 30);
	Font accBtnFont = new Font("couture-bld", Font.PLAIN, 30);
	
	SalesCalendar()
	{
		init();
	}
	public SalesCalendar(AccountsManage am) {
		this.am = am;
		init();
	}
	public void init() {
		initComponent();
		initEvent();
	}
	public void initComponent() {
		/////////////외부 프레임 설정/////////////
		FlowLayout frameLayout = new FlowLayout();
		frameLayout.setVgap(30);
		setLayout(frameLayout);
		///////////topPanel 설정///////////////
		title.setPreferredSize(new Dimension(800,100));//타이틀레이블 설정
		title.setOpaque(true); 
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(titleFont);
		title.setBackground(heavyBlue);
		topPanel.add(title);
		///////////midPanel 설정///////////////
		midPanel.setPreferredSize(new Dimension(1000,400));
		midRPanel.setPreferredSize(new Dimension(800,380));
		midPanel.add(month);
		midRPanel.setLayout(new GridLayout(0,6,10,10));
//		int index = 1;
//		for(JButton l : salesLabel)
//		{
//			l =  new JButton(index + "일 " + "총매출 : " + am.getDaySales(index-1));
//			l.setBackground(lightBlue);
//			l.setOpaque(true);
//			midRPanel.add(l);
//			index++;
//		}
		for(int i = 0; i < salesLabel.length; i++)
		{
			salesLabel[i] =  new JButton((i+1) + "일 " + "매출확인" + am.getDaySales(i));
			salesLabel[i].setBackground(lightBlue);
			salesLabel[i].setOpaque(true);
			midRPanel.add(salesLabel[i]);
		}
		midPanel.add(midRPanel);
		//////////////bottomPanel 설정//////////
		JPanel bLPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800,100));
		FlowLayout fl2 = new FlowLayout(FlowLayout.LEFT);
		bottomPanel.setLayout(fl2);
		fl2.setHgap(200);
		
		bLPanel.setPreferredSize(new Dimension(300,60));
		bLPanel.setBackground(lightBlue);
		totalTF.enable(false);					//이거 어예쓰누
		pNumTF.enable(false);					//이거 어예쓰누
		bLPanel.add(totalL);
		bLPanel.add(totalTF);
		bLPanel.add(pNumL);
		bLPanel.add(pNumTF);
		bottomPanel.setBackground(heavyBlue);
		bottomPanel.add(bLPanel);
		accBtn.setFont(new Font("couture-bld",Font.PLAIN,10));
		backBtn.setFont(new Font("couture-bld",Font.PLAIN,10));
		bottomPanel.add(accBtn);
		bottomPanel.add(backBtn);
		///////////프레임에 패널 추가//////////////////
		add(topPanel);
		add(midPanel);
		add(bottomPanel);
	}
	public void initEvent()
	{
		for(int i = 0; i < salesLabel.length; i++) {
			salesLabel[i].addActionListener(this);
		}
		accBtn.addActionListener(this);
		backBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		
		for(int i = 0; i < salesLabel.length; i++) {
			if(b.equals(salesLabel[i])) {
				am.acounts(i);
				this.repaint();
			}
		}
		if(b.equals(accBtn))
		{
			af = new AccFrame(am);
			af.setVisible(true);
			af.repaint();
			this.repaint();
		}
		if(b.equals(backBtn))
		{
			this.dispose();
			MainFrame mf = new MainFrame();
			mf.init();
		}		
	}
//	public static void main(String[] args) {
//		//SalesCalendar sc = new SalesCalendar();
//		//sc.init();
//		//sc.setVisible(true);
//	}
}
