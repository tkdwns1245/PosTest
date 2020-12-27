package manage;

import java.util.ArrayList;
import java.util.Date;

import data.Receipt;

public class ReceiptManage extends Manage{

	ArrayList<Receipt> receipt = new ArrayList<Receipt>();	//������ ����Ʈ
	
	//������ ��� (���ڿ� ��ȯ)
	public String receiptWrite(int index) {
		String str = "===================================\n";
		str += receipt.get(index).getReceiptNo();
		if(receipt.get(index).isChkTakeBack())	str += ". ȯ�ҿ�����\n";
		else									str += ". ������\n";
		str += receipt.get(index).getTable().toString();
		if(receipt.get(index).isType())			str += "\t| ī�����\n";
		else									str += "\t| ���ݰ���\n";
		str += receipt.get(index).getSalesTime();
		str += "\n===================================\n";
		return str;
	}
	//������ ��ȯ(index)
	public Receipt getReceipt(int index) {
		return receipt.get(index);
	}
	
	//������ ���(������)
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
