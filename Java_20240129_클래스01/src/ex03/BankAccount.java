package ex03;

public class BankAccount {

	private String accountNumber;
	private String accountHolder;
	private int balance;
	
	
	
	BankAccount(String b,String b2,int b3){
		accountNumber = b;
		accountHolder = b2;
	    balance = b3;
	
	}   
	
	void deposit(int amount) {
		balance += amount;
		System.out.println("계좌번호 :" + accountNumber);
		
	}
	
	void withdraw(int amount) {
		balance -= amount;
		System.out.println("출금인 :" + accountHolder);
	}
	
	void displayBalance() {
      
		System.out.println("남은잔액 :" + balance);
	}
}
