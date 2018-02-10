
public class Cash {

	private double cash;
	
	public Cash(){
		cash = 20.00;
	}
	public void deposit(double amount){	
		cash = cash - amount;
	}
	public void withdrawal(double amount){
		cash = cash + amount;
	}
	public void work(double amount){
		cash = cash + amount;
	}
	public double getCash(){
		return cash;
	}
}
