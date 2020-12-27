package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class TableFrame extends MyFrameTemplate implements ActionListener{
	Color heavyBlue = new Color(0,89,171);
	Color lightBlue = new Color(142,180,227);
	
	//////////////�ܺ� �г�//////////////////////////
	JPanel outPanel = new JPanel();
	JPanel lPanel = new JPanel();
	JPanel rPanel = new JPanel();
	JPanel outBottomPanel = new JPanel();
	///////////////���� �г� ������Ʈ////////////////////
	JPanel lTopPanel = new JPanel();
	JPanel lMidPanel = new JPanel();
	JPanel lBottomPanel = new JPanel();
	
	JLabel totalL = new JLabel("�� �ݾ� : ");
	JTextField totalTF = new JTextField(10);
	String[] header = {"��ǰ��","����","����","�ݾ�"};
	String[][] content = {
		{"�ݶ�","1000","2","2000"},
		{"���̴�","1000","1","1000"},
		{"������̾߳�","15000","1","15000"},
		{"����","4000","4","16000"}
		};
	JTable lContentTable = new JTable(content,header);
	JScrollPane scrollPane = new JScrollPane(lContentTable);
	
	JButton delBtn = new JButton("����");
	JButton calcBtn = new JButton("���");
	///////////////������ �г� ������Ʈ////////////////////
	JPanel rTopPanel = new JPanel();
	JPanel rBottomPanel = new JPanel();
	ArrayList<JButton> categoryBtn = new ArrayList<JButton>();
	
	String[] header2 = {"����","����"};
	String[][] content2 = {
			{"�ݶ�","1000"},
			{"���̴�","1000"},
			{"ȯŸ","1000"},
			{"�������꽺","3000"}
	};
	JTable rContentTable = new JTable(content2,header2);
	JScrollPane scrollPane2 = new JScrollPane(rContentTable);
	JButton addBtn = new JButton("�߰�");
	
	//////////////��Ÿ ������Ʈ//////////////////////////
	JButton backBtn = new JButton("�ڷΰ���");
	JLabel title = new JLabel("1�� ���̺�");
	Font titleFont = new Font("couture-bld", Font.PLAIN, 100);
	Font backBtnFont = new Font("couture-bld", Font.PLAIN, 30);
	////////////���̾ƿ�/////////////////////////////
	GridLayout outPanelLayout = new GridLayout(1,2);
	FlowLayout FrameLayout = new FlowLayout();
	GridBagLayout lPanelLayout = new GridBagLayout();
	
	
	public TableFrame() {
		//ī�װ� ��ư ����
		categoryBtn.add(new JButton("��ǰ�丮"));
		categoryBtn.add(new JButton("��Ʈ�丮"));
		categoryBtn.add(new JButton("����"));
		categoryBtn.add(new JButton("�ַ�"));
		categoryBtn.add(new JButton("ABtn"));
		categoryBtn.add(new JButton("BBtn"));
		init();
	}
	public void initComponent()
	{
		this.setBackground(heavyBlue);//�����Ӽ���
		FrameLayout.setVgap(20);
		this.setLayout(FrameLayout);
		
		outPanel.setPreferredSize(new Dimension(1000,500));//�гμ���
		outPanel.setBackground(Color.white);
		outPanel.setLayout(outPanelLayout);
		//////////���� �г� ����//////////
		lPanel.setBackground(lightBlue);
		lPanel.setBorder(new LineBorder(Color.white,10));
		lPanel.setLayout(new FlowLayout());
		lTopPanel.setPreferredSize(new Dimension(460,350));
		lTopPanel.setBackground(heavyBlue);
		lTopPanel.add(scrollPane);
		
		lMidPanel.setPreferredSize(new Dimension(300,50));
		lMidPanel.setBackground(heavyBlue);
		totalL.setFont(new Font("couture-bld", Font.PLAIN, 20));
		totalL.setForeground(Color.WHITE);
		totalTF.setEnabled(false);
		lMidPanel.add(totalL);
		lMidPanel.add(totalTF);
		
		lBottomPanel.setPreferredSize(new Dimension(480,50));
		lBottomPanel.setBackground(lightBlue);
		FlowLayout lBottomLayout = new FlowLayout();
		lBottomLayout.setHgap(100);
		lBottomPanel.setLayout(lBottomLayout);
		delBtn.setPreferredSize(new Dimension(90,40));
		calcBtn.setPreferredSize(new Dimension(90,40));
		lBottomPanel.add(delBtn);
		lBottomPanel.add(calcBtn);
		
		lPanel.add(lTopPanel);
		lPanel.add(lMidPanel);
		lPanel.add(lBottomPanel);
		////////������ �г� ����////////////////////
		rPanel.setBackground(lightBlue);
		rPanel.setBorder(new LineBorder(Color.white,10));
		
		rTopPanel.setPreferredSize(new Dimension(460,100));
		rTopPanel.setBackground(lightBlue);
		rTopPanel.setLayout(new GridLayout(0,5,5,5));
		for(JButton b: categoryBtn)
		{
			rTopPanel.add(b);
		}
		
		rBottomPanel.setPreferredSize(new Dimension(460,350));
		scrollPane2.setPreferredSize(new Dimension(360,300));
		addBtn.setPreferredSize(new Dimension(80,40));
		rBottomPanel.add(addBtn);
		rBottomPanel.add(scrollPane2);
		rBottomPanel.setBackground(heavyBlue);
		
		rPanel.add(rTopPanel);
		rPanel.add(rBottomPanel);
		////////////////////////////////////////
		outPanel.add(lPanel);
		outPanel.add(rPanel);
		outBottomPanel.setPreferredSize(new Dimension(1100,100));//�Ʒ��� �г� ����
		outBottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		outBottomPanel.add(backBtn);
		
		title.setPreferredSize(new Dimension(600,100));//Ÿ��Ʋ���̺� ����
		title.setOpaque(true); 
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(titleFont);
		title.setBackground(heavyBlue);
		
		backBtn.setPreferredSize(new Dimension(200,80));//�ڷΰ��� ��ư ����
		backBtn.setFont(backBtnFont);
		
		this.add(title);//�����ӿ� ������Ʈ �߰�
		this.add(outPanel);
		this.add(outBottomPanel);
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
		TableFrame rmf = new TableFrame();
		rmf.init();
	}

}
