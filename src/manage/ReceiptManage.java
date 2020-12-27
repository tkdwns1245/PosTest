package manage;

import java.util.ArrayList;
import java.util.Date;

import data.Receipt;

public class ReceiptManage extends Manage{

	ArrayList<Receipt> receipt = new ArrayList<Receipt>();	//영수증 리스트
	
	//영수증 출력 (문자열 반환)
	public String receiptWrite(int index) {
		String str = "===================================\n";
		str += receipt.get(index).getReceiptNo();
		if(receipt.get(index).isChkTakeBack())	str += ". 환불영수증\n";
		else									str += ". 영수증\n";
		str += receipt.get(index).getTable().toString();
		if(receipt.get(index).isType())			str += "\t| 카드결제\n";
		else									str += "\t| 현금결제\n";
		str += receipt.get(index).getSalesTime();
		str += "\n===================================\n";
		return str;
	}
	//영수증 반환(index)
	public Receipt getReceipt(int index) {
		return receipt.get(index);
	}
	
	//영수증 등록(영수증)
	@Override
	public void Register(Object obj) {
		// TODO Auto-generated method stub
//		Receipt rec = (Receipt)obj;
//		rec.setSalesTime(new Date());
//		receipt.add(rec);
		receipt.add((Receipt)obj);
		receipt.get(receipt.size() - 1).setReceiptNo(receipt.size());
		receipt.get(receipt.size() - 1).setSalesTime(new Date());
	}

	@Override
	public void Delete(Object obj) {
		// TODO Auto-generated method stub
		
	}


}
