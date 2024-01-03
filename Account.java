

public class Account {
		//필드 선언
		String accountid, pwd;//아이디 ,비번
		String name, phone;//이름, 전번
		String accountnumber;//계좌번호
		String registerdate; //가입 날짜
		

		int balance;//자산
		
		static int count;//객체생성 숫자
		//생성자
		
	    
		Account(){};//기본 생성자
		Account(String accountid, String pwd){//아이디, 비번 초기화
			this.accountid = accountid;
			this.pwd = pwd;
		}
		Account(String name, String accountnumber, String registerdate, String phone){//이름, 계좌번호, 등록 날짜, 전화번호 초기화
			this.name = name;
			this.accountnumber = accountnumber;
			this.registerdate = registerdate;
			this.phone = phone;
		}
		Account(int balance){//자산 필드 초기화
			this.balance = balance;
		}
		Account(String accountid, String pwd, 
				String name, String accountnumber, 
				String registerdate, String phone, 
				int balance){//이름, 계좌번호, 등록 날짜, 전화번호 초기화
			this.accountid = accountid;
			this.pwd = pwd;
			this.name = name;
			this.accountnumber = accountnumber;
			this.registerdate = registerdate;
			this.phone = phone;
			this.balance = balance;
		}
		
		
		void deposit(int money) {//입금
			balance += money;
		}
			
		void withdraw(int money) {//출금
			balance -= money;
		}
		
		@Override
		public String toString() {
			return "id: "+this.accountid +", pwd:"+ this.pwd+'\n'+
					"name:"+ this.name+", accountnumber: "+this.accountnumber+ ", registerdate: "+ 
					this.registerdate+", phone:"+this.phone+"\n"+
					"balance: "+ this.balance+"\n";
		}
}
