import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Bank extends JFrame{
	
	private static JPanel menu = new JPanel();
	
	

	private static JButton bank = new JButton("Bank");
	private static JButton shops = new JButton("Shops");
	private static JButton work = new JButton("Work");
	private static JButton deposit = new JButton("Deposit");
	private static JButton withdrawal = new JButton("Withdrawal");
	private static JButton main = new JButton("Main Menu");
	
	private static JTextField dtxt = new JTextField();
	private static JTextField wtxt = new JTextField();
	
	
	public static void main(String[] args) {
		
		//pocket money
	
		//bank account balance
		Balance you = new Balance();
		Cash tu = new Cash();
		
		Bank a = new Bank();
	
		JLabel pocket = new JLabel("Pocket:$ ");
		JLabel pmoney = new JLabel("");
		JLabel btext = new JLabel("Balance:$ ");
		JLabel bbalance = new JLabel("");
		
		//frame a
		a.setTitle("ProjectOne");
		a.setBounds(175,25,1000,700);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    a.setVisible(true);
	    a.add(menu);
	    
	    //menu
	    menu.setLayout(null);
	    menu.add(bank);
	    menu.add(shops);
	    menu.add(work);
	    menu.add(pocket);
	    menu.add(pmoney);
	    menu.add(deposit);
	    menu.add(withdrawal);
	    menu.add(main);
	    menu.add(dtxt);
	    menu.add(wtxt);
	    menu.add(btext);
	    menu.add(bbalance);
	    
	 
		//button location
		bank.setBounds(400, 100, 175, 75);
		shops.setBounds(600, 400, 175, 75);
		work.setBounds(200, 400, 175, 75);
		deposit.setBounds(200, 400, 175, 75);
		withdrawal.setBounds(600, 400, 175, 75);
		main.setBounds(400, 100, 175, 75);
		dtxt.setBounds(200, 500, 175, 25);
		wtxt.setBounds(600, 500, 175, 25);
		
		deposit.setVisible(false);
		withdrawal.setVisible(false);
		main.setVisible(false);
		dtxt.setVisible(false);
		wtxt.setVisible(false);
		btext.setVisible(false);
		bbalance.setVisible(false);
	   
	    //top right money count
	    pocket.setBounds(825, 25, 75, 50);
        pmoney.setBounds(895, 25, 75, 50);
        pmoney.setText(tu.getCash() + "");
        
        btext.setBounds(825, 25, 75, 50);
        bbalance.setBounds(895, 25, 75, 50);
        bbalance.setText(you.getBalance() + "");
        
        main.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				bank.setVisible(true);	
				shops.setVisible(true);
				work.setVisible(true);
				pocket.setVisible(true);
				pmoney.setVisible(true);
				deposit.setVisible(false);
				withdrawal.setVisible(false);
				main.setVisible(false);
				dtxt.setVisible(false);
				wtxt.setVisible(false);
				btext.setVisible(false);
				bbalance.setVisible(false);
				
				
			}
		

		});
    	deposit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	
				double dep = Double.parseDouble(dtxt.getText());
					if(dep<=tu.getCash()){
						you.deposit(dep);
						tu.deposit(dep);
						bbalance.setText(you.getBalance() + "");
						pmoney.setText(tu.getCash() + "");
					
					}
			}
		

		});
    	withdrawal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				double wit = Double.parseDouble(wtxt.getText());
					if(wit<=you.getBalance()){
						you.withdrawal(wit);
						tu.withdrawal(wit);
						bbalance.setText(you.getBalance() + "");
						pmoney.setText(tu.getCash() + "");
						
					}
			}
		

		});
        
		bank.addActionListener(new ActionListener(){

			@Override
			
			public void actionPerformed(ActionEvent e) {
				
			bank.setVisible(false);	
			shops.setVisible(false);
			work.setVisible(false);
			pocket.setVisible(false);
			pmoney.setVisible(false);
			deposit.setVisible(true);
			withdrawal.setVisible(true);
			main.setVisible(true);
			dtxt.setVisible(true);
			wtxt.setVisible(true);
			btext.setVisible(true);
			bbalance.setVisible(true);
			
			
			}
			
		});
		
		shops.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
		});
		
		work.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
		//interest
		  Timer interest = new Timer(1000,  new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(you.getBalance()>0){
		    		 you.deposit(10.00);
		    	  }
		    	  else{
		    		 you.deposit(0);
		    	  }
		         
		      }
		});
 
		
		}
	}

