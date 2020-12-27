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

class AddGoodsFrame extends JFrame implements ActionListener{		////��ǰ �߰� ��ư�� ������ �� �˾��Ǵ� ������///
	GoodsManageFrame tmpGmf;
	CategoriManage tmpCM;
	String[][] tmpContent;
	int index;
	/////////�г�/////////////
	JPanel topPanel = new JPanel();
	/////////������Ʈ////////////
	JLabel l1 = new JLabel("��ǰ��: ");
	JLabel l2 = new JLabel("���� : ");
	JTextField gNameTF = new JTextField(7);
	JTextField gPriceTF = new JTextField(7);
	JButton inputBtn = new JButton("Ȯ��");
	JButton cancelBtn = new JButton("���");
	
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
			Categori category = tmpCM.getCategori(index);	//���õ� ī�װ� ����
			String gName = gNameTF.getText();					//categoryManager�� ��ǰ �߰�
			int gPrice = Integer.parseInt(gPriceTF.getText());
			tmpCM.GoodsRegister(category.getName(), gName, gPrice);
			for(int i = 0; i <category.getGoodsLength(); i++)//��ǰ ����Ʈ ������Ʈ�� ��ǰ���� �߰�
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
	static final int MAXNUMGOODS = 20;	//��� ������ �ִ� ��ǰ����
	int listIndex = 0;	//���õ� ����Ʈ �ε�������
	int tableIndex = 0; //���õ� ���̺� �ε��� ����
	///////////////////////////////////////////
	Color heavyBlue = new Color(0,89,171);
	Color lightBlue = new Color(142,180,227);
	///////////////�Ŵ��� ��ü ////////////////////
	CategoriManage cm;
	//////////////�ܺ� �г�//////////////////////////
	JPanel outPanel = new JPanel();
	JPanel lPanel = new JPanel();
	JPanel rPanel = new JPanel();
	JPanel outBottomPanel = new JPanel();
	///////////////���� �г� ������Ʈ////////////////////
	JPanel lTopPanel = new JPanel();
	JPanel lMidPanel = new JPanel();
	JPanel lBottomPanel = new JPanel();
	
	JLabel categoryLabel = new JLabel();
	String[] header2 = {"����","����"};
	String[][] content2 = new String[MAXNUMGOODS][2];
	JTable lContentTable = new JTable(content2,header2);
	JScrollPane lscrollPane = new JScrollPane(lContentTable);
	JButton addGoodsBtn = new JButton("�߰�");
	JButton lDelBtn = new JButton("����");
	AddGoodsFrame agf;
	///////////////������ �г� ������Ʈ////////////////////
	JPanel rTopPanel = new JPanel();
	JPanel rTopInPanel = new JPanel();
	JPanel rBottomPanel = new JPanel();

	JTextField tf = new JTextField(20);
	JButton categoriAddBtn = new JButton("�߰�");
	JButton rDelBtn = new JButton("����");
	JList list = new JList();
	DefaultListModel model = new DefaultListModel();
	JScrollPane listScrollPane = new JScrollPane(list);
	
	
	//////////////��Ÿ ������Ʈ//////////////////////////
	JButton backBtn = new JButton("�ڷΰ���");
	JLabel title = new JLabel("��ǰ ����");
	Font titleFont = new Font("couture-bld", Font.PLAIN, 100);
	Font backBtnFont = new Font("couture-bld", Font.PLAIN, 30);
	////////////���̾ƿ�/////////////////////////////
	GridLayout outPanelLayout = new GridLayout(1,2);
	FlowLayout FrameLayout = new FlowLayout();
	GridBagLayout lPanelLayout = new GridBagLayout();
	
	
	public GoodsManageFrame(CategoriManage cm) {
		this.cm = cm;
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
		
		/////////���� TopPanel����/////////
		lTopPanel.setPreferredSize(new Dimension(300,50));
		lTopPanel.setBackground(heavyBlue);
		categoryLabel.setFont(new Font("couture-bld", Font.PLAIN, 30));
		lTopPanel.add(categoryLabel);
		////////���� MidPanel ����///////////
		lMidPanel.setPreferredSize(new Dimension(460,300));
		lMidPanel.setBackground(lightBlue);
		lMidPanel.add(lscrollPane);
		lContentTable.addMouseListener(this);
		///////���� BottomPanel ����/////////
		lBottomPanel.setPreferredSize(new Dimension(450,50));
		lBottomPanel.setBackground(heavyBlue);
		addGoodsBtn.addActionListener(this);
		lBottomPanel.add(addGoodsBtn);
		lDelBtn.addActionListener(this);
		lBottomPanel.add(lDelBtn);
		
		lPanel.add(lTopPanel);
		lPanel.add(lMidPanel);
		lPanel.add(lBottomPanel);
		////////������ �г� ����////////////////////
		rPanel.setBackground(lightBlue);
		rPanel.setBorder(new LineBorder(Color.white,10));
		//////������ �� �г� ����//////
		rTopPanel.setPreferredSize(new Dimension(400,100));
		rTopPanel.setLayout(new BorderLayout());
		rTopPanel.setBackground(lightBlue);
		rTopInPanel.setBackground(heavyBlue);
		rTopInPanel.add(tf);
		rTopInPanel.add(categoriAddBtn);
		rTopPanel.add(rTopInPanel,BorderLayout.SOUTH);
		/////������ �Ʒ� �г� ����/////
		rBottomPanel.setPreferredSize(new Dimension(400,300));
		rBottomPanel.setBackground(heavyBlue);
		listScrollPane.setPreferredSize(new Dimension(350,200));
		list.addListSelectionListener(this);
		rBottomPanel.add(listScrollPane);
		rDelBtn.addActionListener(this);
		rBottomPanel.add(rDelBtn);
		/////������ �гο� ���Ʒ� �г� �߰�///
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
	public void initEvent() {///////�̺�Ʈ ����//////////
		// TODO Auto-generated method stub
		backBtn.addActionListener(this);
		categoriAddBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {///////////��ư �̺�Ʈ ����
		JButton b = (JButton)e.getSource();
		if(b.equals(backBtn))
		{
			this.dispose();
		}else if(b.equals(categoriAddBtn))///ī�װ� �߰���ư�� ��������
		{
			String str = tf.getText();
			cm.Register(str);//CategoryManager�� ī�װ����
			model.addElement(str);//listModel�� ī�װ����
			list.setModel(model); //����Ʈ�� �𵨵��
		}else if(b.equals(addGoodsBtn))////��ǰ �߰� ��ư�� ��������
		{
			agf = new AddGoodsFrame(cm,listIndex,content2,this);
			agf.setVisible(true);
		}
		else if(b.equals(lDelBtn))///���� �г� ���� ��ư�� ��������
		{
			Goods goods = cm.getCategori(listIndex).getGoods(tableIndex);	//���õ� ��ǰ ��ü �޾ƿ�
			cm.getCategori(listIndex).delGoods(goods);//���õ� ��ǰ ����
			GoodsListUpdate();	//��ǰ ����Ʈ ����
			this.repaint();
		}else if(b.equals(rDelBtn))
		{
			Categori category = cm.getCategori(listIndex);
			String categoryName = category.getName();
			cm.Delete(categoryName);
			model.removeElement(category.getName());//listModel�� ī�װ�����
			list.setModel(model);
			GoodsListInit();	//��ǰ ����Ʈ �ʱ�ȭ
			this.repaint();
		}
	}
	
	public void valueChanged(ListSelectionEvent e)/////////����Ʈ �̺�Ʈ ����
	{
		for(int i = 0; i< model.getSize(); i++)
		{
			if(list.getSelectedIndex() == i)
			{
				listIndex = i;
				String categoryName = cm.getCategori(listIndex).getName();
				GoodsListUpdate();	//��ǰ ����Ʈ ����
				categoryLabel.setText(categoryName);
				this.repaint();
			}
		}
	}
	public void mouseClicked(MouseEvent e){ // ���콺Ŭ���̺�Ʈ�߻���
	     if(e.getButton() == 1){ // ��Ŭ����
	    	 tableIndex = lContentTable.getSelectedRow(); // ���õǾ��� row���ϱ�
	     }   
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void GoodsListUpdate() {//////��ǰ ���� �޼���
		Categori category = cm.getCategori(listIndex);	//���õ� ī�װ���
		GoodsListInit();		//���õ� ī�װ� ��ǰ ����Ʈ �ʱ�ȭ
		for(int k = 0; k <category.getGoodsLength(); k++)//���õ� ī�װ� ��ǰ ����Ʈ ����
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
		for(int l = 0; l < content2.length; l++)		//��ǰ ����Ʈ �ʱ�ȭ�޼���
			for(int m = 0; m< content2[l].length; m++)
			{
				content2[l][m] = "";
			}
	}

	
}
