package data;

public class StrongBox {
	private int readyMoney;
	private int cash;
	private int card;
	
	{
		cash = 20000;
		card = 350000;
	}
	
	public int getReadyMoney() {
		return readyMoney;
	}
	public void setReadyMoney(int readyMoney) {
		this.readyMoney = readyMoney;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getCard() {
		return card;
	}
	public void setCard(int card) {
		this.card = card;
	}
	public int getMoney() {
		return cash + card;
	}
	
	public void init() {
		this.card = 0;
		this.cash = 0;
	}
	@Override
	public String toString() {
		return "매출 [현금=" + cash + ", 신용카드=" + card + "]";
	}
	
	public StrongBox(){
		this.readyMoney = 200000;
		this.cash += this.readyMoney;
	}

}
