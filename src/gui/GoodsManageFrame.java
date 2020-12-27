package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.Categori;
import data.Goods;
import manage.CategoriManage;

class AddGoodsFrame extends JFrame implements ActionListener{		////상품 추가 버튼을 눌렀을 때 팝업되는 프레임///
	GoodsManageFrame tmpGmf;
	CategoriManage tmpCM;
	String[][] tmpContent;
	int index;
	/////////패널/////////////
	JPanel topPanel = new JPanel();
	/////////컴포넌트////////////
	JLabel l1 = new JLabel("상품명: ");
	JLabel l2 = new JLabel("가격 : ");
	JTextField gNameTF = new JTextField(7);
	JTextField gPriceTF = new JTextField(7);
	JButton inputBtn = new JButton("확인");
	JButton cancelBtn = new JButton("취소");
	
	public AddGoodsFrame(CategoriManage cm ,int index,String[][] content,GoodsManageFrame gmf){
		this.tmpGmf = gmf;
		this.tmpCM = cm;
		this.index = index;
		this.tmpContent = content;
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = screen.width / 2-getWidth() /2;
		int y =  screen.height / 2 - getHeight()/2;
		this.setSize(300,150);
		this.setResizable(false);
		this.setLocation(x,y);
		
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
		fl.setVgap(20);
		setLayout(fl);
		inputBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		add(l1);
		add(gNameTF);
		add(l2);
		add(gPriceTF);
		add(inputBtn);
		add(cancelBtn);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if (b.equals(inputBtn))
		{
			Categori category = tmpCM.getCategori(index);	//선택된 카테고리 변수
			String gName = gNameTF.getText();					//categoryManager에 상품 추가
			int gPrice = Integer.parseInt(gPriceTF.getText());
			tmpCM.GoodsRegister(category.getName(), gName, gPrice);
			for(int i = 0; i <category.getGoodsLength(); i++)//상품 리스트 컴포넌트에 상품값들 추가
			{
				for(int j = 0; j <2; j++)
				{
					if(j==0)
						tmpContent[i][j] = category.getGoods(i).getName();
					else if(j==1)
						tmpContent[i][j] = Integer.toString(category.getGoods(i).getPrice());
				}
			}
			tmpGmf.repaint();
			this.setVisible(false);
		} else if(b.equals(cancelBtn))
		{
			tmpGmf.repaint();
			this.setVisible(false);
		}
	}
}
public class GoodsManageFrame extends MyFrameTemplate implements ActionListener,
														ListSelectionListener,MouseListener{
	static final int MAXNUMGOODS = 20;	//출력 가능한 최대 물품개수
	int listIndex = 0;	//선택된 리스트 인덱스변수
	int tableIndex = 0; //선택된 테이블 인덱스 변수
	///////////////////////////////////////////
	Color heavyBlue = new Color(0,89,171);
	Color lightBlue = new Color(142,180,227);
	///////////////매니저 객체 ////////////////////
	CategoriManage cm;
	//////////////외부 패널//////////////////////////
	JPanel outPanel = new JPanel();
	JPanel lPanel = new JPanel();
	JPanel rPanel = new JPanel();
	JPanel outBottomPanel = new JPanel();
	///////////////왼쪽 패널 컴포넌트////////////////////
	JPanel lTopPanel = new JPanel();
	JPanel lMidPanel = new JPanel();
	JPanel lBottomPanel = new JPanel();
	
	JLabel categoryLabel = new JLabel();
	String[] header2 = {"종류","가격"};
	String[][] content2 = new String[MAXNUMGOODS][2];
	JTable lContentTable = new JTable(content2,header2);
	JScrollPane lscrollPane = new JScrollPane(lContentTable);
	JButton addGoodsBtn = new JButton("추가");
	JButton lDelBtn = new JButton("삭제");
	AddGoodsFrame agf;
	///////////////오른쪽 패널 컴포넌트////////////////////
	JPanel rTopPanel = new JPanel();
	JPanel rTopInPanel = new JPanel();
	JPanel rBottomPanel = new JPanel();

	JTextField tf = new JTextField(20);
	JButton categoriAddBtn = new JButton("추가");
	JButton rDelBtn = new JButton("삭제");
	JList list = new JList();
	DefaultListModel model = new DefaultListModel();
	JScrollPane listScrollPane = new JScrollPane(list);
	
	
	//////////////기타 컴포넌트//////////////////////////
	JButton backBtn = new JButton("뒤로가기");
	JLabel title = new JLabel("상품 관리");
	Font titleFont = new Font("couture-bld", Font.PLAIN, 100);
	Font backBtnFont = new Font("couture-bld", Font.PLAIN, 30);
	////////////레이아웃/////////////////////////////
	GridLayout outPanelLayout = new GridLayout(1,2);
	FlowLayout FrameLayout = new FlowLayout();
	GridBagLayout lPanelLayout = new GridBagLayout();
	
	
	public GoodsManageFrame(CategoriManage cm) {
		this.cm = cm;
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
		
		/////////왼쪽 TopPanel설정/////////
		lTopPanel.setPreferredSize(new Dimension(300,50));
		lTopPanel.setBackground(heavyBlue);
		categoryLabel.setFont(new Font("couture-bld", Font.PLAIN, 30));
		lTopPanel.add(categoryLabel);
		////////왼쪽 MidPanel 설정///////////
		lMidPanel.setPreferredSize(new Dimension(460,300));
		lMidPanel.setBackground(lightBlue);
		lMidPanel.add(lscrollPane);
		lContentTable.addMouseListener(this);
		///////왼쪽 BottomPanel 설정/////////
		lBottomPanel.setPreferredSize(new Dimension(450,50));
		lBottomPanel.setBackground(heavyBlue);
		addGoodsBtn.addActionListener(this);
		lBottomPanel.add(addGoodsBtn);
		lDelBtn.addActionListener(this);
		lBottomPanel.add(lDelBtn);
		
		lPanel.add(lTopPanel);
		lPanel.add(lMidPanel);
		lPanel.add(lBottomPanel);
		////////오른쪽 패널 설정////////////////////
		rPanel.setBackground(lightBlue);
		rPanel.setBorder(new LineBorder(Color.white,10));
		//////오른쪽 위 패널 설정//////
		rTopPanel.setPreferredSize(new Dimension(400,100));
		rTopPanel.setLayout(new BorderLayout());
		rTopPanel.setBackground(lightBlue);
		rTopInPanel.setBackground(heavyBlue);
		rTopInPanel.add(tf);
		rTopInPanel.add(categoriAddBtn);
		rTopPanel.add(rTopInPanel,BorderLayout.SOUTH);
		/////오른쪽 아래 패널 설정/////
		rBottomPanel.setPreferredSize(new Dimension(400,300));
		rBottomPanel.setBackground(heavyBlue);
		listScrollPane.setPreferredSize(new Dimension(350,200));
		list.addListSelectionListener(this);
		rBottomPanel.add(listScrollPane);
		rDelBtn.addActionListener(this);
		rBottomPanel.add(rDelBtn);
		/////오른쪽 패널에 위아래 패널 추가///
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
	public void initEvent() {///////이벤트 설정//////////
		// TODO Auto-generated method stub
		backBtn.addActionListener(this);
		categoriAddBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {///////////버튼 이벤트 설정
		JButton b = (JButton)e.getSource();
		if(b.equals(backBtn))
		{
			this.dispose();
		}else if(b.equals(categoriAddBtn))///카테고리 추가버튼을 눌렀을떄
		{
			String str = tf.getText();
			cm.Register(str);//CategoryManager에 카테고리등록
			model.addElement(str);//listModel에 카테고리등록
			list.setModel(model); //리스트에 모델등록
		}else if(b.equals(addGoodsBtn))////상품 추가 버튼을 눌렀을때
		{
			agf = new AddGoodsFrame(cm,listIndex,content2,this);
			agf.setVisible(true);
		}
		else if(b.equals(lDelBtn))///왼쪽 패널 삭제 버튼을 눌렀을때
		{
			Goods goods = cm.getCategori(listIndex).getGoods(tableIndex);	//선택된 상품 객체 받아옴
			cm.getCategori(listIndex).delGoods(goods);//선택된 상품 삭제
			GoodsListUpdate();	//상품 리스트 갱신
			this.repaint();
		}else if(b.equals(rDelBtn))
		{
			Categori category = cm.getCategori(listIndex);
			String categoryName = category.getName();
			cm.Delete(categoryName);
			model.removeElement(category.getName());//listModel에 카테고리삭제
			list.setModel(model);
			GoodsListInit();	//상품 리스트 초기화
			this.repaint();
		}
	}
	
	public void valueChanged(ListSelectionEvent e)/////////리스트 이벤트 설정
	{
		for(int i = 0; i< model.getSize(); i++)
		{
			if(list.getSelectedIndex() == i)
			{
				listIndex = i;
				String categoryName = cm.getCategori(listIndex).getName();
				GoodsListUpdate();	//상품 리스트 갱신
				categoryLabel.setText(categoryName);
				this.repaint();
			}
		}
	}
	public void mouseClicked(MouseEvent e){ // 마우스클릭이벤트발생시
	     if(e.getButton() == 1){ // 좌클릭시
	    	 tableIndex = lContentTable.getSelectedRow(); // 선택되어진 row구하기
	     }   
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void GoodsListUpdate() {//////상품 갱신 메서드
		Categori category = cm.getCategori(listIndex);	//선택된 카테고리값
		GoodsListInit();		//선택된 카테고리 물품 리스트 초기화
		for(int k = 0; k <category.getGoodsLength(); k++)//선택된 카테고리 물품 리스트 갱신
		{
			for(int j = 0; j <2; j++)
			{
				if(j==0)
					content2[k][j] = category.getGoods(k).getName();
				else if(j==1)
					content2[k][j] = Integer.toString(category.getGoods(k).getPrice());
			}
		}
	}
	public void GoodsListInit() {
		for(int l = 0; l < content2.length; l++)		//물품 리스트 초기화메서드
			for(int m = 0; m< content2[l].length; m++)
			{
				content2[l][m] = "";
			}
	}

	
}
