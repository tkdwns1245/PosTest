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
import javax.swing.JTextField;

public class LoginFrame extends MyFrameTemplate implements ActionListener{
	Color heavyBlue = new Color(0,89,171);
	Color lightBlue = new Color(142,180,227);
	
	JPanel topPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JPanel mTopPanel = new JPanel();
	JPanel mMidPanel = new JPanel();
	
	JLabel title = new JLabel("홍콩POSMachine");
	JLabel idL = new JLabel("아이디 : ");
	JLabel passwordL = new JLabel("패스워드 : ");
	JTextField idTF = new JTextField(25);
	JTextField passwordTF = new JTextField(25);
	
	JButton loginBtn = new JButton("로그인");
	
	public LoginFrame()
	{
	}
	public void initComponent()
	{
		/////////프레임 설정///////////////
		FlowLayout FrameLayout = new FlowLayout(FlowLayout.CENTER);
		FrameLayout.setVgap(30);
		setLayout(FrameLayout);
		/////////////top패널 설정///////////
		topPanel.setPreferredSize(new Dimension(700,150));
		topPanel.setBackground(heavyBlue);
		title.setPreferredSize(new Dimension(700,150));
		title.setFont(new Font("couture-bld", Font.PLAIN, 80));
		title.setForeground(Color.white);
		topPanel.add(title);
		//////////main패널 설정////////////
		mainPanel.setPreferredSize(new Dimension(500,400));
		mainPanel.setBackground(lightBlue);
		FlowLayout mainLayout = new FlowLayout(FlowLayout.CENTER);
		mainLayout.setVgap(30);
		mainPanel.setLayout(mainLayout);
		//////mTop패널 설정//////
		mTopPanel.setPreferredSize(new Dimension(500,50));
		mTopPanel.setBackground(lightBlue);
		/////mMid 패널 설정/////
		mMidPanel.setPreferredSize(new Dimension(300,200));
		mMidPanel.setBackground(lightBlue);
		FlowLayout mMidLayout = new FlowLayout();
		mMidLayout.setVgap(20);
		mMidPanel.setLayout(mMidLayout);
		idTF.setPreferredSize(new Dimension(120,30));
		passwordTF.setPreferredSize(new Dimension(120,30));
		loginBtn.setPreferredSize(new Dimension(250,50));
		mMidPanel.add(idTF);
		mMidPanel.add(passwordTF);
		mMidPanel.add(loginBtn);
		/////main패널에 top,mid 패널 추가///
		mainPanel.add(mTopPanel);
		mainPanel.add(mMidPanel);
		////////프레임에 main,top패널 추가///////
		add(topPanel);
		add(mainPanel);
	}
	public void initEvent()
	{
		loginBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		MainFrame mf = new MainFrame();
		mf.init();
	}
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame();
		lf.init();
		lf.setVisible(true);
	}

}