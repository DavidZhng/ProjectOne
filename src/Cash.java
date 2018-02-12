
public class Cash {

	private double cash;
	
	public Cash(){
		cash = 20.00;
	}
	public void output(double amount){	
		cash = cash - amount;
	}
	public void input(double amount){
		cash = cash + amount;
	}
	public double getCash(){
		return cash;
	}
}
