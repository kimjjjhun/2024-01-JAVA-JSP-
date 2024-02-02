package ex03;

public class Example01 {

	public static void main(String[] args) {
		  BankAccount b1 = new BankAccount("001122","김정훈",1000);
             
		  
		b1.deposit(5000);
	    b1.displayBalance();
	    b1.withdraw(3000);
	    b1.displayBalance();

	
	
	
	}
}

