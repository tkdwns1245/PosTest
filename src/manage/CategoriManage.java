package manage;

import java.util.ArrayList;

import data.Categori;
import data.Goods;

public class CategoriManage extends Manage{
	
	protected ArrayList<Categori> categoriList = new ArrayList<Categori>();

	//카테고리 추가(Object obj)	객체타입으로
	@Override
	void Register(Object obj) {
		categoriList.add((Categori)obj);
	}
	//카테고리 추가(String name)	이름으로
	public void Register(String name) {
		categoriList.add(new Categori(name));
	}
	//카테고리 삭제(Object obj)	객체타입으로
	@Override
	void Delete(Object obj) {
		categoriList.remove((Categori)obj);
	}
	//카테고리 삭제(String name)	이름으로
	public void Delete(String name) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i).toString() == name)	categoriList.remove(i);
		}
	}
	//상품 추가(카테고리 객체, 상품객체)
	public void GoodsRegister(Categori categori, Goods goods) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i) == categori)	categoriList.get(i).addGoods(goods);	//나중에 오류체크 필***********
		}
	}
	//상품 추가(카테고리 객체, 상품명, 상품 가격)
		public void GoodsRegister(Categori categori, String name, int price) {
			for(int i = 0; i < categoriList.size(); i++) {
				if(categoriList.get(i) == categori)	categoriList.get(i).addGoods(name, price);	//나중에 오류체크 필***********
			}
		}
	//상품 추가(카테고리 객체, 상품명, 상품 가격)
	public void GoodsRegister(String nameC, String nameG, int price) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i).toString() == nameC)	categoriList.get(i).addGoods(nameG, price);	//나중에 오류체크 필***********
		}
	}
	
	//상품 삭제(카테고리 객체, 상품명)
	public void GoodsDelete(Categori categori, String name) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i) == categori)	categoriList.get(i).delGoods(name);
		}
	}
	//상품 삭제(카테고리명, 상품명)
	public void GoodsDelete(String cName, String gName) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i).getName() == cName)	categoriList.get(i).delGoods(gName);
		}
	}
	//카테고리호출(index)
	public Categori getCategori(int index) {
		return categoriList.get(index);
	}
	
	//상품호출(index)
	public Goods getGoods(Categori cat, int index) {
		return cat.getGoods(index);
	}
	//상품호출(index)
//	public Goods getGoods(String cat, int index) {
//		return 
//	}
	
	
	
	public void dis() {
		for(int i = 0; i < categoriList.size(); i++) {
			System.out.println(categoriList.get(i));
		}
	}
	public void dis(String name) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i).getName() == name) {
				for(int j = 0; j < categoriList.get(i).getGoodsList().size(); j++) {
					System.out.println(categoriList.get(i).getGoods(j));
				}
			}
		}
	}
	
}
