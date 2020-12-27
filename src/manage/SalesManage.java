package manage;

import data.Goods;
import data.Receipt;
import data.StrongBox;
import data.Table;

public class SalesManage extends Manage{
	private StrongBox sb = new StrongBox();	//�ݰ�
	
	private Receipt receipt; //�ӽ������ �ֹ���
	
	//���̺� ��ǰ�߰�
	public void order(Table t, Goods g) {
		t.addGoodsCount(g);
	}
	//���̺� ��ǰ����
	public void cancell(Table t, Goods g) {
		t.delGoodsCount(g);
	}
	
	//����	(���� ���̺�, ��������(����f, ī��t));
	public Receipt calculate(Table t, boolean means) {
		if(means)	sb.setCard(sb.getCard() + t.getTotalPrice());
		else		sb.setCash(sb.getCash() + t.getTotalPrice());
		//Receipt receipt = new Receipt(t);

		this.receipt = new Receipt(t);
		this.receipt.setType(means);
		t.init();
		
		return receipt;
	}
	//ȯ��	(�������� ����)
	public void takeBack(Receipt rec) {
		if(!rec.isChkTakeBack()) {
			if(rec.isType())	sb.setCard(sb.getCard() - rec.getTable().getTotalPrice());
			else				sb.setCash(sb.getCash() - rec.getTable().getTotalPrice());
		}
		rec.setChkTakeBack(true);
	}
	//����Ȯ��
	public String salesCheck() {
		return sb.toString();
	}
	
	//ȯ��	(�������� ������ ����)
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
