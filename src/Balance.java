
public class Balance {

	private double balance;
	
	public Balance(){
		balance = 100.00;
	}
	public void deposit(double amount){
		balance = balance + amount;
	}
	public void withdrawal(double amount){
		if(amount<=balance){
			balance = balance - amount;
		}
		else{
			System.err.println("YOU ARE TOO POOR FOR THIS");
		}
		
	}
	public double getBalance(){
		return balance;
	}

}
