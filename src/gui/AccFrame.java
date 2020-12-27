package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import manage.AccountsManage;

public class AccFrame extends JFrame implements ActionListener{

	AccountsManage am;

	Color heavyBlue = new Color(0,89,171);
	Color lightBlue = new Color(142,180,227);
	
	JPanel topPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JPanel mTopPanel = new JPanel();
	JPanel mMidPanel = new JPanel();
	
	JLabel title = new JLabel("매출");
	JLabel cash = new JLabel("현금");
	JLabel card = new JLabel("카드");

	JLabel cashSales;
	JLabel cardSales;
	JLabel readyMoney;
	
	Font titleFont = new Font("couture-bld", Font.PLAIN, 60);
	Font methFont = new Font("couture-bld", Font.PLAIN, 40);
	Font moneyFont = new Font("couture-bld", Font.PLAIN, 40);
	
	
	private GridLayout gl = new GridLayout(2, 2);
	private GridLayout agl = new GridLayout(2, 1);
	private GridLayout downGl = new GridLayout(1, 2);
	private JPanel pn = new JPanel();
	private JPanel apn = new JPanel();
	private JPanel downPn = new JPanel();
	
	
	
	JButton accBtn = new JButton("정산");
	JButton cnBtn = new JButton("취소");
	
	
	public void init() {
		initComponent();
		initEvent();
	}
	public void initComponent() {
		pn.setLayout(gl);
		apn.setLayout(agl);
		pn.add(cash);
		pn.add(card);
		
		//String str = Integer.toString(am.getSb().getCash() - am.getSb().getReadyMoney());
		String str = Integer.toString(am.getSb().getCash());
		
		cashSales = new JLabel(str);
		str = Integer.toString(am.getSb().getCard());
		cardSales = new JLabel(str);
		str = "시재 : ";
		readyMoney = new JLabel(str + am.getSb().getReadyMoney());
		
		pn.add(cashSales);
		pn.add(cardSales);
		
		apn.add(pn);
		apn.add(readyMoney);
		
		downPn.setLayout(downGl);
		downPn.add(accBtn);
		downPn.add(cnBtn);
		
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(titleFont);
		cash.setHorizontalAlignment(SwingConstants.CENTER);
		cash.setFont(methFont);
		card.setHorizontalAlignment(SwingConstants.CENTER);
		card.setFont(methFont);
		cashSales.setHorizontalAlignment(SwingConstants.CENTER);
		cashSales.setFont(methFont);
		cardSales.setHorizontalAlignment(SwingConstants.CENTER);
		cardSales.setFont(methFont);
		readyMoney.setHorizontalAlignment(SwingConstants.CENTER);
		readyMoney.setFont(methFont);
		
		this.add(title, BorderLayout.NORTH);
		this.add(apn, BorderLayout.CENTER);
		this.add(downPn, BorderLayout.SOUTH);
	}
	public void initEvent() {
		accBtn.addActionListener(this);
		cnBtn.addActionListener(this);
	}
	public AccFrame() {
		this.setSize(600,300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = screen.width / 2-getWidth() /2;
		int y =  screen.height / 2 - getHeight()/2;
		this.setTitle("정산하꾸얌!!!");
		this.setResizable(false);
		this.setLocation(x,y);
	}
	public AccFrame(AccountsManage am) {
		this();
		this.am = am;
		init();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton)e.getSource();
		if(b.equals(accBtn))
		{
			GregorianCalendar gc = new GregorianCalendar ( );
			//int day = gc.get (Calendar.DATE);
			System.out.println(gc.get (Calendar.DATE));
			am.acounts(gc.get(Calendar.DATE));
			this.repaint();
			this.dispose();
		}
		if(b.equals(cnBtn))
		{
			this.dispose();
		}
	}

}
