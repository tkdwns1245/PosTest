package manage;

import data.StrongBox;

public class AccountsManage extends Manage{

	private int [] daySales = new int[31];
	private StrongBox sb;
	
	public StrongBox getSb() {
		return sb;
	}
	public void setSb(StrongBox sb) {
		this.sb = sb;
	}
	{
		daySales[2] = 230000;
		daySales[3] = 110000;
		daySales[4] = 70000;
		daySales[5] = 50000;
		
	}
	
	//정산
	public void acounts(int index) {
		daySales[index] += sb.getMoney() - sb.getReadyMoney();
		sb.init();
	}
	//시재수정
	public void setReadyMoney(int money) {
		this.sb.setReadyMoney(money);
	}

	public int getDaySales(int index) {
		return daySales[index];
	}

	public void setDaySales(int[] daySales) {
		this.daySales = daySales;
	}
	
	private AccountsManage(){
		
	}
	public AccountsManage(StrongBox sb){
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
