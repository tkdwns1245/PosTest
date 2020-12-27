package gui;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;

import manage.AccountsManage;
import manage.AcountsManage;
import manage.CategoriManage;
import manage.SalesManage;
import manage.TableManage;

public class MainFrame extends MyFrameTemplate implements ActionListener{
	///////////////각 매니저 변수 선언//////////////
	CategoriManage cm = new CategoriManage();
	TableManage tm = new TableManage();
	SalesManage sm = new SalesManage();
	AccountsManage am = new AccountsManage(sm.getSb());
	
	
	///////////////각프레임 객체 변수 선언///////////////
	GoodsManageFrame gmf = new GoodsManageFrame(cm);
	TableManageFrame tmf = new TableManageFrame();
	TableFrame tf = new TableFrame();
	SalesCalendar sc = new SalesCalendar(am);
	///////////////////////GUI 변수////////////////////////////
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
	Color heabyBlue = new Color(0,89,171);
	Color lightBlue = new Color(142,180,227);
	
	JLabel title = new JLabel("Main 화면");
	
	ArrayList<JButton> tBtn = new ArrayList<JButton>();
	JButton salesBtn = new JButton("매출확인");
	JButton goodsMgBtn = new JButton("상품관리");
	JButton recptBtn = new JButton("영수증관리");
	JButton tableMgBtn = new JButton("테이블관리");

	BorderLayout mPanelLayout = new BorderLayout();	
	FlowLayout topPanelLayout = new FlowLayout(FlowLayout.CENTER);
	GridLayout midPanelLayout = new GridLayout(3,5,10,10);
	FlowLayout bPanelLayout = new FlowLayout();
	
	public MainFrame()
	{
		int numOfTable = 16;					//테이블 수를 입력받아서 테이블 버튼을 초기화
		for(int i = 0; i <numOfTable; i++)
		{
			String tmpStr = "Table" + (i+1);
			JButton tmpBtn = new JButton(tmpStr);
			tBtn.add(tmpBtn);
		
		}
		setVisible(true);
	}
	public void initComponent()
	{
		mPanelLayout.setVgap(80);
		bPanelLayout.setHgap(80);
		topPanel.setLayout(topPanelLayout);
		midPanel.setLayout(midPanelLayout);
		bottomPanel.setLayout(bPanelLayout);
		mainPanel.setLayout(mPanelLayout);
		
		Font titleFont = new Font("couture", Font.PLAIN, 100);
		title.setPreferredSize(new Dimension(1000,100));
		title.setOpaque(true); 
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(titleFont);
		title.setBackground(lightBlue);
		topPanel.add(title);	//topPanel에 레이블 설정
		
		for(JButton b : tBtn)	//midPanel에 버튼 추가
		{
			midPanel.add(b);
		}
		salesBtn.setPreferredSize(new Dimension(200,60));//bottomPanel에 버튼 설정 및 추가
		goodsMgBtn.setPreferredSize(new Dimension(200,60));
		recptBtn.setPreferredSize(new Dimension(200,60));
		tableMgBtn.setPreferredSize(new Dimension(200,60));
		
		bottomPanel.add(salesBtn);
		bottomPanel.add(goodsMgBtn);
		bottomPanel.add(recptBtn);
		bottomPanel.add(tableMgBtn);

		
		mainPanel.setSize(1100,700);	//mainPanel 설정
		mainPanel.setBorder(new EmptyBorder(50,20,20,20));
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(midPanel,BorderLayout.CENTER);			//maimPanel에 topPanel과bottom패널 붙임
		mainPanel.add(bottomPanel,BorderLayout.SOUTH);
		
		this.add(mainPanel);
	}
	public void initEvent()
	{
		salesBtn.addActionListener(this);
		goodsMgBtn.addActionListener(this);
		recptBtn.addActionListener(this);
		tableMgBtn.addActionListener(this);
		
		for(JButton b: tBtn)
		{
			b.addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn.equals(salesBtn))
		{
			//this.dispose();
			//SalesCalendar sc = new SalesCalendar();
			sc.setVisible(true);
			//sc.init();
		}
		else if(btn.equals(goodsMgBtn))
		{
			gmf.setVisible(true);
		}
		else if(btn.equals(recptBtn))
		{
			this.dispose();
			ReceiptManageFrame rmf = new ReceiptManageFrame();
			rmf.init();
		}
		else if(btn.equals(tableMgBtn))
		{
			tmf.setVisible(true);
		}
		for(JButton b : tBtn)
		{
			if(btn.equals(b))
			{
				tf.setVisible(true);
			}
		}
	}
}
