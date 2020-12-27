package data;

import java.util.ArrayList;

public class Categori {
	private String name;
	protected ArrayList<Goods> goodsList = new ArrayList<Goods>();
	
	public void setGoods(int index, Goods g) {
		goodsList.add(index, g);
	}
	public Goods getGoods(int index) {
		return goodsList.get(index);
	}
	
	public void addGoods(Goods goods) {
		goodsList.add(goods);
	}
	public void addGoods(String name, int price) {
		goodsList.add(new Goods(name, price));
	}
	
	public void delGoods(Goods goods) {
		goodsList.remove(goods);
	}
	public void delGoods(String name) {
		for(int i = 0; i < goodsList.size(); i++) {
			if(goodsList.get(i).getName() == name)	goodsList.remove(i);
		}
	}
	
	public int getGoodsLength() {
		return goodsList.size(); 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(ArrayList<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
	public Categori(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}

}
