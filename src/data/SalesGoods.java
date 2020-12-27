package data;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class SalesGoods implements Cloneable{

	//protected ArrayList<Goods> goodsList = new ArrayList<Goods>();
	protected Hashtable<String, Integer> goodsPriceList = new Hashtable<String, Integer>();	//��ǰ��, ��ǰ����
	protected Hashtable<String, Integer> goodsCountList = new Hashtable<String, Integer>();	//��ǰ��, ��ǰ����
	
	protected int totalPrice;

	public Hashtable<String, Integer> getGoodsPriceList() {
		return goodsPriceList;
	}

	public void setGoodsPriceList(Hashtable<String, Integer> goodsPriceList) {
		this.goodsPriceList = goodsPriceList;
	}

	public Hashtable<String, Integer> getGoodsCountList() {
		return goodsCountList;
	}

	public void setGoodsCountList(Hashtable<String, Integer> goodsCountList) {
		this.goodsCountList = goodsCountList;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getGoodsPrice(String name) {
		return goodsPriceList.get(name);
	}
	
	//�����ݾ� ����
	public int getTotalPrice() {
		totalPrice = 0;
		Iterator num = goodsCountList.values().iterator();
		Iterator price = goodsPriceList.values().iterator();
		for(int i = 0; i < goodsPriceList.size(); i++) {
			totalPrice += (int)num.next() * (int)price.next();
		}
		return totalPrice;
	}
	//�ֹ��� �ʱ�ȭ
	public void init() {
		goodsCountList.clear();
		goodsPriceList.clear();
		totalPrice = 0;
	}
	
	//�ֹ���
	@Override
	public String toString() {
		String str = "-----------------------------------" + "\n" + 
				"��ǰ��" + "\t\t" + "�ܰ�" + "\t" + "����" + "\t" + "�ݾ�" + "\n";
		Enumeration name = goodsCountList.keys();
		Iterator num = goodsCountList.values().iterator();
		Iterator price = goodsPriceList.values().iterator();
		
		int n1 = 0;
		int n2 = 0;
		
		while(name.hasMoreElements()) {
			String it = (String) name.nextElement();
			if(it.length() > 3)	str += it + "\t";
			else							str += it + "\t\t";
			n1 = (int) price.next();
			n2 = (int) num.next();
			str += n1 + "\t";
			str += n2 + "\t";
			str += (n1 * n2) + "\n";
		}
		str += "�հ� : " + getTotalPrice() + "��";
		return str;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
