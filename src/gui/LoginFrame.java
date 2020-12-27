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
	
	JLabel title = new JLabel("ȫ��POSMachine");
	JLabel idL = new JLabel("���̵� : ");
	JLabel passwordL = new JLabel("�н����� : ");
	JTextField idTF = new JTextField(25);
	JTextField passwordTF = new JTextField(25);
	
	JButton loginBtn = new JButton("�α���");
	
	public LoginFrame()
	{
	}
	public void initComponent()
	{
		/////////������ ����///////////////
		FlowLayout FrameLayout = new FlowLayout(FlowLayout.CENTER);
		FrameLayout.setVgap(30);
		setLayout(FrameLayout);
		/////////////top�г� ����///////////
		topPanel.setPreferredSize(new Dimension(700,150));
		topPanel.setBackground(heavyBlue);
		title.setPreferredSize(new Dimension(700,150));
		title.setFont(new Font("couture-bld", Font.PLAIN, 80));
		title.setForeground(Color.white);
		topPanel.add(title);
		//////////main�г� ����////////////
		mainPanel.setPreferredSize(new Dimension(500,400));
		mainPanel.setBackground(lightBlue);
		FlowLayout mainLayout = new FlowLayout(FlowLayout.CENTER);
		mainLayout.setVgap(30);
		mainPanel.setLayout(mainLayout);
		//////mTop�г� ����//////
		mTopPanel.setPreferredSize(new Dimension(500,50));
		mTopPanel.setBackground(lightBlue);
		/////mMid �г� ����/////
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
		/////main�гο� top,mid �г� �߰�///
		mainPanel.add(mTopPanel);
		mainPanel.add(mMidPanel);
		////////�����ӿ� main,top�г� �߰�///////
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