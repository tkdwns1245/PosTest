package data;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class SalesGoods implements Cloneable{

	//protected ArrayList<Goods> goodsList = new ArrayList<Goods>();
	protected Hashtable<String, Integer> goodsPriceList = new Hashtable<String, Integer>();	//상품명, 상품가격
	protected Hashtable<String, Integer> goodsCountList = new Hashtable<String, Integer>();	//상품명, 상품개수
	
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
	
	//결제금액 리턴
	public int getTotalPrice() {
		totalPrice = 0;
		Iterator num = goodsCountList.values().iterator();
		Iterator price = goodsPriceList.values().iterator();
		for(int i = 0; i < goodsPriceList.size(); i++) {
			totalPrice += (int)num.next() * (int)price.next();
		}
		return totalPrice;
	}
	//주문서 초기화
	public void init() {
		goodsCountList.clear();
		goodsPriceList.clear();
		totalPrice = 0;
	}
	
	//주문서
	@Override
	public String toString() {
		String str = "-----------------------------------" + "\n" + 
				"물품명" + "\t\t" + "단가" + "\t" + "수량" + "\t" + "금액" + "\n";
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
		str += "합계 : " + getTotalPrice() + "원";
		return str;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
