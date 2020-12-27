package data;

public class Table extends SalesGoods{

	protected int tableNum;	//테이블 번호

	//테이블에 상품추가
	public void addGoodsCount(Goods g) {
		if(goodsCountList.containsKey(g.getName()))	goodsCountList.put(g.getName(), goodsCountList.get(g.getName())+1);
		else {
			goodsCountList.put(g.getName(), 1);
			goodsPriceList.put(g.getName(), g.getPrice());
		}
	}
	//테이블에 상품제거
	public void delGoodsCount(Goods g) {
		if(goodsCountList.containsKey(g.getName())) {
			if(goodsCountList.get(g.getName()) == 0) {
				goodsCountList.remove(g.getName());
				goodsPriceList.remove(g.getName());
			}
			else	goodsCountList.put(g.getName(), goodsCountList.get(g.getName())-1);
		}
	}
	
	//index번째 테이블 값 호출
//	public Table getGoodsList(int index) {
//		return tableList.get(index);
//	}

	
	public Table() {
		
	}
	public Table(int tableNum) {
		this.tableNum = tableNum;
	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	public String toString(int num) {
		return "Table [tableNum=" + num + "]";
	}
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		// TODO Auto-generated method stub
//		return super.clone();
//	}

}
