import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 Account[] list = new Account[10];
		 Transaction[] transhistory = new Transaction[10];
		 String id;
		 String pwd;
		 String name;
		 String accountnumber;
		 String registerdate;
		 String phone;
		 int balance;
		 int money;
		 
		String transfernum;
		String recievernum;
		String date;//거래 날짜
		String description;//거래 메모
		 boolean cnd = true;
		 
		 
		 do {
			 System.out.println("------------------");
			 System.out.println("1.회원등록");
			 System.out.println("2.로그인");
			 System.out.println("3.입금");
			 System.out.println("4.출금");
			 System.out.println("5.이체");
			 System.out.println("6.거래 조회");
			 System.out.println("7.회원출력");
			 System.out.println("8.회원 탈퇴");
			 System.out.println("9.종료");
			 System.out.println("------------------");
	
	
			 System.out.println("번호 입력");
			 int menu = sc.nextInt();
			 
			 switch(menu) {
				 case 1: //회원등록
					 System.out.println("아이디:");
					 id = sc.next();
					 System.out.println("비밀:");
					 pwd = sc.next();
					 System.out.println("이름:");
					 name = sc.next();
					 System.out.println("계좌번호:");
					 accountnumber = sc.next();
					 System.out.println("등록날짜:");
					 registerdate = sc.next();
					 System.out.println("전화번호:");
					 phone = sc.next();
					 System.out.println("자산:");
					 balance = sc.nextInt();
					 list[Account.count] = new Account(id, pwd, 
							 name, accountnumber, registerdate, 
							 phone, balance);//list 배열에 Account 삽입
					 Account.count++;
					 break;
				 case 2: //로그인
					System.out.println("* 로그인 *");
					  System.out.println("아이디:");
					 id = sc.next();
					 System.out.println("비밀:");
					 pwd = sc.next();
					boolean isLogin = false;
					for (int i =0; i< Account.count; i++){
						if((list[i].accountid).equals(id) && (list[i].pwd).equals(pwd)){
							System.out.println("로그인 성공!");
							isLogin = true;
							break;
						}
					}
					if(!isLogin){
						System.out.println("로그인 실패!!");
					}
				 case 3: //입금
					 //deposit(money)
					 System.out.println("* 입금 *");
					 System.out.println("ID 입력: ");
					id = sc.next();
					 System.out.println("받는 계좌번호를 입력: ");
					 recievernum = sc.next();
					 
					 for (int i = 0; i < Account.count; i++) {
						 if((list[i].accountnumber).equals(recievernum)) {//id,pwd가 같은지 비교
							 System.out.println("금액을 입력!!");
							 money = sc.nextInt();
							 System.out.println("날짜를 입력!!");
							 date = sc.next();
							 System.out.println("메모를  입력!!");
							 description = sc.next();
							 list[i].deposit(money);
							 transhistory[Transaction.count] = new Transaction(recievernum,money,date,description); 
							 Transaction.count++;
							 break;
						 }
						 else {
							 System.out.println("id, 계좌번호를 잘못 입력. 다시 확인...");
							 break;
						 }
					 }
					 
					 break;
				 case 4: //출금
					 //withdraw(money)
					 System.out.println("* 출금 *");
					 
					 System.out.println("계좌번호를 입력: ");
					 transfernum = sc.next();
					 for (int i = 0; i < Account.count; i++) {
						 if((list[i].accountnumber).equals(transfernum)) {//id,pwd가 같은지 비교
							 System.out.println("금액을 입력!!");
							 money = sc.nextInt();
							 System.out.println("날짜를 입력!!");
							 date = sc.next();
							 System.out.println("메모를  입력!!");
							 description = sc.next();
							 list[i].deposit(money);
							 transhistory[Transaction.count] = new Transaction(transfernum,money,date,description); 
							 Transaction.count++;
							 break;
						 }
						 else {
							 System.out.println("id, 계좌번호를 잘못 입력. 다시 확인...");
							 break;
						 }
					 }
					 
					 break;
				 case 5://이체
			 		System.out.println("* 이체 *");
					 
					 System.out.println("이체하는 계좌번호를 입력: ");
					 transfernum = sc.next();
					 
					 System.out.println("받는 계좌번호를 입력: ");
					 receivernum = sc.next();
					 for (int i = 0; i < Account.count; i++) {
						 if((list[i].accountnumber).equals(receivernum)) {//id,pwd가 같은지 비교
							 System.out.println("금액을 입력!!");
							 money = sc.nextInt();
							 System.out.println("날짜를 입력!!");
							 date = sc.next();
							 System.out.println("메모를  입력!!");
							 description = sc.next();
							 list[i].deposit(money);
							 transhistory[Transaction.count] = new Transaction(transfernum, receivernum, money,date,description); 
							 Transaction.count++;
							 break;
						 }
						 else {
							 System.out.println("id, 계좌번호를 잘못 입력. 다시 확인...");
							 break;
						 }
					 }
					 
					 break;
				 case 6: //거래조회
					 System.out.println("* 거래조회 *");
					 for (int i = 0; i < Transaction.count; i++) {
						 System.out.println(transhistory[i]);
					 }
					 break;
				 case 7: //출력
					 for (int i = 0; i < Account.count; i++) {
//						 System.out.print("id: "+ list[i].accountid +" ,pwd: "+ list[i].pwd +"\n");
						 System.out.print(list[i]);
					 }
					 break;
				 case 8: //회원 탈퇴
					 System.out.println("* 회원탈퇴 *");
					 System.out.println("탈퇴하고 싶은 계좌의 아이디 입력:");
					 id = sc.next();
					 System.out.println("비번 입력:");
					 pwd = sc.next();
					  
					 
					 for (int i = 0; i < Account.count; i++) {
						 if((list[i].accountid).equals(id) && (list[i].pwd).equals(pwd)) {//id,pwd가 같은지 비교
							list = list.remove(list[i]);
							 break;
						 }
					 }
					 
					 break;
				 case 9: //종료
					 cnd = false;
					 break;
				 default:
					 System.out.println("디시 입력하세요");
					 break;
			 }
		 }while(cnd);
		 System.out.println("프로그램 종료!");
	}
	
 }

