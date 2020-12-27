package manage;

import java.util.ArrayList;

import data.Categori;
import data.Goods;

public class CategoriManage extends Manage{
	
	protected ArrayList<Categori> categoriList = new ArrayList<Categori>();

	//ī�װ� �߰�(Object obj)	��üŸ������
	@Override
	void Register(Object obj) {
		categoriList.add((Categori)obj);
	}
	//ī�װ� �߰�(String name)	�̸�����
	public void Register(String name) {
		categoriList.add(new Categori(name));
	}
	//ī�װ� ����(Object obj)	��üŸ������
	@Override
	void Delete(Object obj) {
		categoriList.remove((Categori)obj);
	}
	//ī�װ� ����(String name)	�̸�����
	public void Delete(String name) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i).toString() == name)	categoriList.remove(i);
		}
	}
	//��ǰ �߰�(ī�װ� ��ü, ��ǰ��ü)
	public void GoodsRegister(Categori categori, Goods goods) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i) == categori)	categoriList.get(i).addGoods(goods);	//���߿� ����üũ ��***********
		}
	}
	//��ǰ �߰�(ī�װ� ��ü, ��ǰ��, ��ǰ ����)
		public void GoodsRegister(Categori categori, String name, int price) {
			for(int i = 0; i < categoriList.size(); i++) {
				if(categoriList.get(i) == categori)	categoriList.get(i).addGoods(name, price);	//���߿� ����üũ ��***********
			}
		}
	//��ǰ �߰�(ī�װ� ��ü, ��ǰ��, ��ǰ ����)
	public void GoodsRegister(String nameC, String nameG, int price) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i).toString() == nameC)	categoriList.get(i).addGoods(nameG, price);	//���߿� ����üũ ��***********
		}
	}
	
	//��ǰ ����(ī�װ� ��ü, ��ǰ��)
	public void GoodsDelete(Categori categori, String name) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i) == categori)	categoriList.get(i).delGoods(name);
		}
	}
	//��ǰ ����(ī�װ���, ��ǰ��)
	public void GoodsDelete(String cName, String gName) {
		for(int i = 0; i < categoriList.size(); i++) {
			if(categoriList.get(i).getName() == cName)	categoriList.get(i).delGoods(gName);
		}
	}
	//ī�װ�ȣ��(index)
	public Categori getCategori(int index) {
		return categoriList.get(index);
	}
	
	//��ǰȣ��(index)
	public Goods getGoods(Categori cat, int index) {
		return cat.getGoods(index);
	}
	//��ǰȣ��(index)
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
