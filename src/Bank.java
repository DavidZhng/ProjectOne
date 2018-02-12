import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;


public class Bank extends JFrame{
	private static JFrame a = new JFrame();
	
	private static JPanel menu = new JPanel();
	
	//image scaling
	private static ImageIcon img1 = new ImageIcon("Jim's_Bank.png");
	private static ImageIcon img2 = new ImageIcon("halal.jpg");
	private static Image scaleImage1 = img1.getImage().getScaledInstance(175, 100,Image.SCALE_DEFAULT);
	private static Image scaleImage2 = img2.getImage().getScaledInstance(175, 100,Image.SCALE_DEFAULT);
	
	private static JButton bank = new JButton(new ImageIcon(scaleImage1));
	private static JButton shops = new JButton("Shops");
	private static JButton work = new JButton("Work");
	private static JButton deposit = new JButton("Deposit");
	private static JButton withdrawal = new JButton("Withdrawal");
	private static JButton main = new JButton("Main Menu");
	private static JButton halal = new JButton(new ImageIcon(scaleImage2));
	
	private static JTextField depositlabel = new JTextField();
	private static JTextField withdrawallabel = new JTextField();
	
	private static JLabel pocket = new JLabel("Pocket:$ ");
	private static JLabel pmoney = new JLabel("");
	private static JLabel balancelabel = new JLabel("Balance:$ ");
	private static JLabel bbalance = new JLabel("");
	private static JLabel background = new JLabel(new ImageIcon("logo.png"));
	private static JLabel halallabel = new JLabel("$5.00");
	private static JLabel healthlabel = new JLabel("Health");
	
	private final static JProgressBar healthbar = new JProgressBar(0,100);
	
	//classes
	private static Balance you = new Balance();
	private static Cash tu = new Cash();
	

	
   public static String helper(double n){
   
   		int count = 0;
   		count += n * 100;
   		String str = "" + count;
   		return (str.substring(0, str.length()-2) + "." + str.substring(str.length()-2, str.length()));
   			
   		}

  
	public static void main(String[] args) {
		
		//hpbar
		healthbar.setValue(100);
		healthbar.setStringPainted(true);
	
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
	    //pocket money
	    menu.add(pocket);
	    menu.add(pmoney);
	    //deposit/withdrawal buttons
	    menu.add(deposit);
	    menu.add(withdrawal);
	    //return to main menu
	    menu.add(main);
	    //deposit/withdrawal textfields
	    menu.add(depositlabel);
	    menu.add(withdrawallabel);
	    //balance label
	    menu.add(balancelabel);
	    menu.add(bbalance);
	    menu.add(background);
	    //shop options
	    menu.add(halal);
	    menu.add(halallabel);
	    menu.add(healthbar);
	    menu.add(healthlabel);
	    
	 
		//button location
		bank.setBounds(400, 100, 175, 100);
		shops.setBounds(600, 400, 175, 75);
		work.setBounds(200, 400, 175, 75);
		deposit.setBounds(200, 400, 175, 75);
		withdrawal.setBounds(600, 400, 175, 75);
		main.setBounds(400, 100, 175, 75);
		depositlabel.setBounds(200, 500, 175, 25);
		withdrawallabel.setBounds(600, 500, 175, 25);
		background.setBounds(0,0,1000,700);
		halal.setBounds(200, 400, 175, 75);
		halallabel.setBounds(200, 500, 175, 25);
		healthbar.setBounds(25, 50, 300, 25);
		healthlabel.setBounds(160,25,175,25);
			

		//bank
		deposit.setVisible(false);
		withdrawal.setVisible(false);
		main.setVisible(false);
		depositlabel.setVisible(false);
		withdrawallabel.setVisible(false);
		balancelabel.setVisible(false);
		bbalance.setVisible(false);
		//shops
		halal.setVisible(false);
		halallabel.setVisible(false);
	   
	    //top right money count
	    pocket.setBounds(825, 25, 75, 50);
        pmoney.setBounds(895, 25, 75, 50);
        pmoney.setText(helper(tu.getCash()));
        
        balancelabel.setBounds(825, 75, 75, 50);
        bbalance.setBounds(895, 75, 75, 50);
        bbalance.setText(helper(you.getBalance()));
   
        
      //interest
		  Timer interest = new Timer(1000,  new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(you.getBalance()>0){
		    		 you.deposit(10.00);
		    		 balancelabel.setText(you.getBalance()+"");
		    	  }
		    	  
		      }
		});
		  
        main.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				bank.setVisible(true);	
				shops.setVisible(true);
				work.setVisible(true);
				deposit.setVisible(false);
				withdrawal.setVisible(false);
				main.setVisible(false);
				depositlabel.setVisible(false);
				withdrawallabel.setVisible(false);
				balancelabel.setVisible(false);
				bbalance.setVisible(false);
				halal.setVisible(false);
				halallabel.setVisible(false);
				
				
			}
		

		});
    	deposit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	
				double dep = Double.parseDouble(depositlabel.getText());
					if(dep<=tu.getCash()){
						you.deposit(dep);
						tu.output(dep);
						bbalance.setText(helper(you.getBalance()));
						pmoney.setText(helper(tu.getCash()));
						depositlabel.setText("");
					
					}
			}
		

		});
    	withdrawal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				double wit = Double.parseDouble(withdrawallabel.getText());
					if(wit<=you.getBalance()){
						you.withdrawal(wit);
						tu.input(wit);
						bbalance.setText(helper(you.getBalance()));
						pmoney.setText(helper(tu.getCash()));
						withdrawallabel.setText("");
						
					}
			}
		

		});
        
		bank.addActionListener(new ActionListener(){

			@Override
			
			public void actionPerformed(ActionEvent e) {
				
			bank.setVisible(false);	
			shops.setVisible(false);
			work.setVisible(false);
			deposit.setVisible(true);
			withdrawal.setVisible(true);
			main.setVisible(true);
			depositlabel.setVisible(true);
			withdrawallabel.setVisible(true);
			balancelabel.setVisible(true);
			bbalance.setVisible(true);
			
			
			}
			
		});
		
		shops.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				bank.setVisible(false);	
				shops.setVisible(false);
				work.setVisible(false);
				main.setVisible(true);
				halal.setVisible(true);
				halallabel.setVisible(true);
			}
		});
		
		work.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				tu.input(.1);
				pmoney.setText(helper(tu.getCash()));
				
				
				
			}
		});
		
		halal.addActionListener(new halalaction());
				
	    }
			
		public static class halalaction implements ActionListener{
				
			    public void actionPerformed (ActionEvent e){
			    	tu.output(5);
					pmoney.setText(helper(tu.getCash()));
			        new Thread(new thread1()).start(); 

			    }

			}
		public static class thread1 implements Runnable{
				
			public void run(){
			
				for(int i=healthbar.getValue();i>=0;i--){
					 healthbar.setValue(i);
					 healthbar.repaint();
					 try{
						 Thread.sleep(4000);
					 }
					 catch (InterruptedException err){}

				}
			}
		}
}

