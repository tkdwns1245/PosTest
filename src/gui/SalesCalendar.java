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
	///////////topPanel ������Ʈ////////////
	JLabel title = new JLabel("Sales Calendar");
	Font titleFont = new Font("couture-bld", Font.PLAIN, 100);
	///////////midPanel ������Ʈ ////////////
	JLabel month = new JLabel("4����\n������Ȳ");
	JPanel midRPanel = new JPanel();
	JButton[] salesLabel = new JButton[31];
	//////////bottomPanel ������Ʈ//////////
	JLabel totalL = new JLabel("�̹��� �Ѹ���");
	JLabel pNumL = new JLabel("�̹��� �� �湮�ڼ�");
	JTextField totalTF = new JTextField(10);	//����? ����? �̰� ����????��ü ����???
	JTextField pNumTF = new JTextField(10);		//����? ����? �̰� ����????��ü ����???	�ƾƾ� ����
	JButton accBtn = new JButton("����");
	JButton backBtn = new JButton("�ڷΰ���");
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
		/////////////�ܺ� ������ ����/////////////
		FlowLayout frameLayout = new FlowLayout();
		frameLayout.setVgap(30);
		setLayout(frameLayout);
		///////////topPanel ����///////////////
		title.setPreferredSize(new Dimension(800,100));//Ÿ��Ʋ���̺� ����
		title.setOpaque(true); 
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(titleFont);
		title.setBackground(heavyBlue);
		topPanel.add(title);
		///////////midPanel ����///////////////
		midPanel.setPreferredSize(new Dimension(1000,400));
		midRPanel.setPreferredSize(new Dimension(800,380));
		midPanel.add(month);
		midRPanel.setLayout(new GridLayout(0,6,10,10));
//		int index = 1;
//		for(JButton l : salesLabel)
//		{
//			l =  new JButton(index + "�� " + "�Ѹ��� : " + am.getDaySales(index-1));
//			l.setBackground(lightBlue);
//			l.setOpaque(true);
//			midRPanel.add(l);
//			index++;
//		}
		for(int i = 0; i < salesLabel.length; i++)
		{
			salesLabel[i] =  new JButton((i+1) + "�� " + "����Ȯ��" + am.getDaySales(i));
			salesLabel[i].setBackground(lightBlue);
			salesLabel[i].setOpaque(true);
			midRPanel.add(salesLabel[i]);
		}
		midPanel.add(midRPanel);
		//////////////bottomPanel ����//////////
		JPanel bLPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800,100));
		FlowLayout fl2 = new FlowLayout(FlowLayout.LEFT);
		bottomPanel.setLayout(fl2);
		fl2.setHgap(200);
		
		bLPanel.setPreferredSize(new Dimension(300,60));
		bLPanel.setBackground(lightBlue);
		totalTF.enable(false);					//�̰� �����
		pNumTF.enable(false);					//�̰� �����
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
		///////////�����ӿ� �г� �߰�//////////////////
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
