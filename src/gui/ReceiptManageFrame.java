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
	////�ܺ� �г� ����//////
	JPanel topPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JPanel lPanel = new JPanel();
	JPanel rPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	////���� �г� ������Ʈ ����////
	JLabel title = new JLabel("������ ����");
	////�����г� ������Ʈ ����////
	JLabel lTitle = new JLabel("������List");
	String[] lHeader = {"�ð�","��ǰ����"};
	String[][] lContent = {
			{"18:15","����,����"},
			{"18:20","������̾߳�,����"}
			};
	JTable lTable = new JTable(lContent,lHeader);
	JScrollPane lScrollPane = new JScrollPane(lTable);
	////�������г� ������Ʈ ����////
	String[] rHeader = {"����","����","�ݾ�"};
	String[][] rContent = {
			{"������̾߳�","1","15000"},
			{"����","4","16000"}
			};
	JTable rTable = new JTable(rContent,rHeader);
	JScrollPane rScrollPane = new JScrollPane(rTable);
	JButton rePrintBtn = new JButton("�����");
	JButton refundBtn = new JButton("��ǰ");
	////////�ܺ� ������Ʈ///////
	JButton backBtn = new JButton("�ڷΰ���");
	public ReceiptManageFrame() {
		init();
	}
	
	public void initComponent()
	{
		/////////�ܺ� ������ ���̾ƿ� ����////////
		FlowLayout frameLayout = new FlowLayout(FlowLayout.CENTER);
		frameLayout.setVgap(50);
		setLayout(frameLayout);
		setBackground(Color.blue);
		////////���� �г� ������Ʈ ����/////////
		topPanel.setPreferredSize(new Dimension(600,100));
		title.setPreferredSize(new Dimension(600,100));//Ÿ��Ʋ���̺� ����
		title.setFont(new Font("couture-bld", Font.PLAIN, 100));
		title.setOpaque(true); 
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBackground(lightBlue);
		topPanel.add(title);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		///////��� �г� ������Ʈ ����/////////
		mainPanel.setPreferredSize(new Dimension(700,400));
		mainPanel.setBackground(heavyBlue);
		/////��� �����г� ����//////
		lPanel.setPreferredSize(new Dimension(345,390));
		lPanel.setBackground(lightBlue);
		lPanel.add(lTitle);
		lScrollPane.setPreferredSize(new Dimension(345,380));
		lPanel.add(lScrollPane);
		////��� �����г� ����//////
		rPanel.setPreferredSize(new Dimension(345,390));
		rPanel.setBackground(heavyBlue);
		rPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		rScrollPane.setPreferredSize(new Dimension(345,350));
		rPanel.add(rScrollPane);
		rPanel.add(rePrintBtn);
		rPanel.add(refundBtn);
		////main�гο� r,l�г� �߰�///
		mainPanel.add(lPanel);
		mainPanel.add(rPanel);
		//////�Ʒ� �г� ���� ////////////////
		FlowLayout bLayout = new FlowLayout(FlowLayout.RIGHT);
		bottomPanel.setPreferredSize(new Dimension(1000,150));
		bottomPanel.setLayout(bLayout);
		backBtn.setFont(new Font("couture-bld", Font.PLAIN, 30));
		backBtn.setPreferredSize(new Dimension(200,80));//�ڷΰ��� ��ư ��
		bottomPanel.add(backBtn);
		//////////top,main,bottom �г� �߰�///////////
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
