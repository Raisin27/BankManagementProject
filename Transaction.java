
public class Transaction {
	String transfernum;//보내는 계좌번호
	String recievernum;//받는 계좌번호
	int money;
	String date;//거래 날짜
	String description;
	
	static int count;//객체생성 숫자
	
	Transaction(){};//기본 생성자
	Transaction(String recievernum, int money, String date, String description) {
		this.recievernum=recievernum;
		this.money=money;
		this.date=date;
		this.description=description;
	}
	Transaction(String transfernum, int money, String date, String description) {
		this.transfernum=transfernum;
		this.money=money;
		this.date=date;
		this.description=description;
	}
	Transaction( String transfernum, String recievernum, int money, String date, String description) {
		this.transfernum=transfernum;
		this.recievernum=recievernum;
		this.money=money;
		this.date=date;
		this.description=description;
	}
	@Override
	public String toString() {
		return 
				"transfernum: " + this.transfernum + "recievernum: "+ this.recievernum +'\n'+
				"money: " + this.money +'\n'+
				"date: " + this.date +'\n'+
				"description:" + this.description;
	}
	
	
	
}
