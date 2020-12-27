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
	
	//////////////외부 패널//////////////////////////
	JPanel outPanel = new JPanel();
	JPanel lPanel = new JPanel();
	JPanel rPanel = new JPanel();
	JPanel outBottomPanel = new JPanel();
	///////////////왼쪽 패널 컴포넌트////////////////////
	JPanel lTopPanel = new JPanel();
	JPanel lMidPanel = new JPanel();
	JPanel lBottomPanel = new JPanel();
	
	JLabel totalL = new JLabel("총 금액 : ");
	JTextField totalTF = new JTextField(10);
	String[] header = {"물품명","가격","개수","금액"};
	String[][] content = {
		{"콜라","1000","2","2000"},
		{"사이다","1000","1","1000"},
		{"오꼬노미야끼","15000","1","15000"},
		{"소주","4000","4","16000"}
		};
	JTable lContentTable = new JTable(content,header);
	JScrollPane scrollPane = new JScrollPane(lContentTable);
	
	JButton delBtn = new JButton("삭제");
	JButton calcBtn = new JButton("계산");
	///////////////오른쪽 패널 컴포넌트////////////////////
	JPanel rTopPanel = new JPanel();
	JPanel rBottomPanel = new JPanel();
	ArrayList<JButton> categoryBtn = new ArrayList<JButton>();
	
	String[] header2 = {"종류","가격"};
	String[][] content2 = {
			{"콜라","1000"},
			{"사이다","1000"},
			{"환타","1000"},
			{"오렌지쥬스","3000"}
	};
	JTable rContentTable = new JTable(content2,header2);
	JScrollPane scrollPane2 = new JScrollPane(rContentTable);
	JButton addBtn = new JButton("추가");
	
	//////////////기타 컴포넌트//////////////////////////
	JButton backBtn = new JButton("뒤로가기");
	JLabel title = new JLabel("1번 테이블");
	Font titleFont = new Font("couture-bld", Font.PLAIN, 100);
	Font backBtnFont = new Font("couture-bld", Font.PLAIN, 30);
	////////////레이아웃/////////////////////////////
	GridLayout outPanelLayout = new GridLayout(1,2);
	FlowLayout FrameLayout = new FlowLayout();
	GridBagLayout lPanelLayout = new GridBagLayout();
	
	
	public TableFrame() {
		//카테고리 버튼 설정
		categoryBtn.add(new JButton("일품요리"));
		categoryBtn.add(new JButton("세트요리"));
		categoryBtn.add(new JButton("음료"));
		categoryBtn.add(new JButton("주류"));
		categoryBtn.add(new JButton("ABtn"));
		categoryBtn.add(new JButton("BBtn"));
		init();
	}
	public void initComponent()
	{
		this.setBackground(heavyBlue);//프레임설정
		FrameLayout.setVgap(20);
		this.setLayout(FrameLayout);
		
		outPanel.setPreferredSize(new Dimension(1000,500));//패널설정
		outPanel.setBackground(Color.white);
		outPanel.setLayout(outPanelLayout);
		//////////왼쪽 패널 설정//////////
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
		////////오른쪽 패널 설정////////////////////
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
		outBottomPanel.setPreferredSize(new Dimension(1100,100));//아래쪽 패널 설정
		outBottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		outBottomPanel.add(backBtn);
		
		title.setPreferredSize(new Dimension(600,100));//타이틀레이블 설정
		title.setOpaque(true); 
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(titleFont);
		title.setBackground(heavyBlue);
		
		backBtn.setPreferredSize(new Dimension(200,80));//뒤로가기 버튼 설정
		backBtn.setFont(backBtnFont);
		
		this.add(title);//프레임에 컴포넌트 추가
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
