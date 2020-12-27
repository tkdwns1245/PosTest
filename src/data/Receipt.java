package data;

import java.util.Date;
import java.util.Hashtable;

public class Receipt{

//	protected Hashtable<String, Integer> goodsPriceList = new Hashtable<String, Integer>();	//��ǰ��, ��ǰ����
//	protected Hashtable<String, Integer> goodsCountList = new Hashtable<String, Integer>();	//��ǰ��, ��ǰ����
//	
//	protected int totalPrice;

	protected Table table = new Table();			//�߻����̺� ����
	
	private Date salesTime;			//�ǸŽð�
	private int receiptNo;			//������ ��ȣ
	private boolean chkTakeBack;	//ȯ�ҿ���	false��ȯ�� true ȯ��
	private boolean type;			//����/ī�� false/true
	
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
