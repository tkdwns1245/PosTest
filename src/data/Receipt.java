package data;

import java.util.Date;
import java.util.Hashtable;

public class Receipt{

//	protected Hashtable<String, Integer> goodsPriceList = new Hashtable<String, Integer>();	//상품명, 상품가격
//	protected Hashtable<String, Integer> goodsCountList = new Hashtable<String, Integer>();	//상품명, 상품개수
//	
//	protected int totalPrice;

	protected Table table = new Table();			//발생테이블 정보
	
	private Date salesTime;			//판매시간
	private int receiptNo;			//영수증 번호
	private boolean chkTakeBack;	//환불여부	false미환불 true 환불
	private boolean type;			//현금/카드 false/true
	
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public boolean isChkTakeBack() {
		return chkTakeBack;
	}
	public void setChkTakeBack(boolean chkTakeBack) {
		this.chkTakeBack = chkTakeBack;
	}
	public Date getSalesTime() {
		return salesTime;
	}
	public void setSalesTime(Date salesTime) {
		this.salesTime = salesTime;
	}

	public int getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public Receipt(){
		
	}
	public Receipt(Table table){
		this.table.goodsCountList.putAll(table.getGoodsCountList());
		this.table.goodsPriceList.putAll(table.getGoodsPriceList());
		this.table.totalPrice = table.getTotalPrice();
	}
	
}
