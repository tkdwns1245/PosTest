package manage;

import data.Goods;
import data.Receipt;
import data.StrongBox;
import data.Table;

public class SalesManage extends Manage{
	private StrongBox sb = new StrongBox();	//금고
	
	private Receipt receipt; //임시저장용 주문서
	
	//테이블에 상품추가
	public void order(Table t, Goods g) {
		t.addGoodsCount(g);
	}
	//테이블에 상품제거
	public void cancell(Table t, Goods g) {
		t.delGoodsCount(g);
	}
	
	//결제	(결제 테이블, 결제수단(현금f, 카드t));
	public Receipt calculate(Table t, boolean means) {
		if(means)	sb.setCard(sb.getCard() + t.getTotalPrice());
		else		sb.setCash(sb.getCash() + t.getTotalPrice());
		//Receipt receipt = new Receipt(t);

		this.receipt = new Receipt(t);
		this.receipt.setType(means);
		t.init();
		
		return receipt;
	}
	//환불	(영수증을 수정)
	public void takeBack(Receipt rec) {
		if(!rec.isChkTakeBack()) {
			if(rec.isType())	sb.setCard(sb.getCard() - rec.getTable().getTotalPrice());
			else				sb.setCash(sb.getCash() - rec.getTable().getTotalPrice());
		}
		rec.setChkTakeBack(true);
	}
	//매출확인
	public String salesCheck() {
		return sb.toString();
	}
	
	//환불	(영수증을 수정후 리턴)
//	public Receipt takeBack(Receipt rec) {
//		if(!rec.isChkTakeBack()) {
//			if(rec.isType())	sb.setCard(sb.getCard() - rec.getTable().getTotalPrice());
//			else				sb.setCash(sb.getCash() - rec.getTable().getTotalPrice());
//		}
//		rec.setChkTakeBack(true);
//		return rec;
//	}
	
	public StrongBox getSb() {
		return sb;
	}
	public void setSb(StrongBox sb) {
		this.sb = sb;
	}
	@Override
	void Register(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void Delete(Object obj) {
		// TODO Auto-generated method stub
		
	}
}
