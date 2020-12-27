package main;

import data.Table;
import manage.CategoriManage;
import manage.ReceiptManage;
import manage.SalesManage;
import manage.TableManage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TableManage tm = new TableManage();
		CategoriManage cm = new CategoriManage();
		SalesManage sm = new SalesManage();
		ReceiptManage rm = new ReceiptManage();
		
		tm.Register();
		tm.Register();
		tm.Register();
		tm.Register();
		tm.Register();
		
		tm.dis();
		
		cm.Register("�ַ�");
		cm.Register("�Ļ�");
		cm.Register("����");
		
		cm.dis();
		
		cm.GoodsRegister("�ַ�", "�ƻ���", 6000);
		cm.GoodsRegister("�ַ�", "���", 8000);
		cm.GoodsRegister("�ַ�", "ȣ����", 5000);
		
		cm.dis("�ַ�");
		
		sm.order(tm.getTable(1), cm.getGoods(cm.getCategori(0), 0));
		sm.order(tm.getTable(1), cm.getGoods(cm.getCategori(0), 1));
		sm.order(tm.getTable(1), cm.getGoods(cm.getCategori(0), 1));
		sm.order(tm.getTable(1), cm.getGoods(cm.getCategori(0), 2));
		sm.order(tm.getTable(1), cm.getGoods(cm.getCategori(0), 0));
		System.out.println("����");
		tm.dis(1);
		
		sm.cancell(tm.getTable(1), cm.getGoods(cm.getCategori(0), 0));
		tm.dis(1);
		rm.Register(sm.calculate(tm.getTable(1), false));
		
		System.out.println(rm.receiptWrite(0));
		System.out.println(sm.salesCheck());
		
		sm.takeBack(rm.getReceipt(0));
		System.out.println(sm.salesCheck());
		System.out.println(rm.receiptWrite(0));
		//tm.dis(1);
		
		
		
		

	}

}
