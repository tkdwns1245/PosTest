package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class test extends MyFrameTemplate{
	////�ܺ� �г� ����//////
	JPanel mainPanel = new JPanel();
	////���� �г� ������Ʈ ����////
	JLabel title = new JLabel("������ ����");
	////�����г� ������Ʈ ����////
	String[] header = {"��ǰ��","����","����","�ݾ�"};
	String[][] content = {
		{"�ݶ�","1000","2","2000"},
		{"���̴�","1000","1","1000"},
		{"������̾߳�","15000","1","15000"},
		{"����","4000","4","16000"}
		};
	JTable lContentTable = new JTable(content,header);
	JScrollPane scrollPane = new JScrollPane(lContentTable);
	
	////�������г� ������Ʈ ����////
	public test() {
		
	}
	public void initComponent()
	{
		/////////�ܺ� ������ ���̾ƿ� ����////////
		mainPanel.setBackground(Color.green);
		mainPanel.add(scrollPane);
		this.add(mainPanel);
		
		
	}
	public void initEvent()
	{}
	public static void main(String[] args) {
		test rmf = new test();
		rmf.init();
	}
}
