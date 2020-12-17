/**
 * 
 */
package banking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * @author Jestin,Stephin,Vishnu,Giftson
 *
 */
public class Bank {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int choose;
		 JOptionPane.showMessageDialog(null,"Hello, Welcome To Banking System.");
       do {

    	   String choice = JOptionPane.showInputDialog("Please choose any of the option "
    	   		+ "from below:\n 1. Create Account\n 2. Deposit money"
   				+ "\n 3. Display Current Balance\n 4. Withdraw Money\n 5. Tranfer "
   				+ "\n 6. Bill Payment \n 7.Change Details \n 8. View Details \n 9. Exit");
   		 choose = Integer.parseInt(choice);
      switch(choose) {
      
      case 1: CreateAccount();
              	break;
      case 2: Deposit();
      		 	break;
      case 3: DisplayBalance();
              	break;
      case 4: Withdraw(); 
      		  	break;
      case 5: Transfer();
      			break;
      case 6: Bill();
      			break;
      case 7:ChangeDetails();
      			break;
      case 8:Details();
      			break;
      default:  JOptionPane.showMessageDialog(null,"Thank You for using our service, Have a Good Day"); 
				break;
      		}
       }
       while(choose!=9);
       }
	private static void CreateAccount() throws IOException {
		Customer object = new Customer();
		Scanner sc = new Scanner(System.in);
		String name= JOptionPane.showInputDialog("Enter your Name") ;
		int accounttype= Integer.parseInt(JOptionPane.showInputDialog("Hello "+name+" Please choose Account Type"
				+ "\n Press 1 for Savings Account "+ "\n Press 2. for Current Account \n Press 3. for Chequing Account \n "));
		if(accounttype==1)
		{
			object.setAccountType("Savings");
		}
		else if(accounttype==2)
		{
			object.setAccountType("Current");
		}
		else if(accounttype==3)
		{
			object.setAccountType("Chequing");
		}
		String address= JOptionPane.showInputDialog("Enter your Address") ;		
		String city= JOptionPane.showInputDialog("Enter your City") ;
		int number= Integer.parseInt(JOptionPane.showInputDialog("Enter your Contact Number")) ;
		
		object.setName(name);
		object.setName(name);
		object.setAddress(address);
		object.setCity(city);
		object.setContact(number);
		object.setAccnumber((int) ((Math.random() * 9000) + 2000));
		object.setBalance(0);
		
		writeFile(object);
		JOptionPane.showMessageDialog(null, " Account Created Succefully \n Your Account "
				+ "Number is :   " + object.getAccnumber ()+" and Your account type is: "+object.getAccountType());
	}
	private static void DisplayBalance() throws IOException, ClassNotFoundException
	{
	
		Scanner sc = new Scanner(System.in);
		Set<Customer>list=new HashSet<>();
		int accnumber= Integer.parseInt(JOptionPane.showInputDialog("To Display Balance Enter your account number")) ;
		
		list=  (Set<Customer>)readFile();
		for(Customer c: list)
		{
			if(accnumber==c.getAccnumber())
			{
				 JOptionPane.showMessageDialog(null,"Your account balance is "+c.getBalance());
			}
			
		}
	}
	private static void Deposit() throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		int accnumber = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number to deposit money")) ;
		double amount =Double.parseDouble(JOptionPane.showInputDialog("Enter the amount you want to deposit")) ;
		Set<Customer>list=new HashSet<>();
		list= (Set<Customer>) readFile();
		for(Customer c: list)
		{
			if(accnumber==c.getAccnumber())
			{
				c.setBalance(amount+c.getBalance());
		        JOptionPane.showMessageDialog(null,"Your account balance is "+c.getBalance());
		        writeFile(c);
		        break;
			}
		}
}
	private static void Withdraw() throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		int accnumber= Integer.parseInt(JOptionPane.showInputDialog("Enter your account number to withdraw money")) ;
		double amount =Double.parseDouble(JOptionPane.showInputDialog("Enter the amount you want to withdraw")) ;
		Set<Customer>list=new HashSet<>();
		list= (Set<Customer>) readFile();
		for(Customer c: list)
		{
			if(accnumber==c.getAccnumber())
			{
				float fee = (float) (amount*0.0003);
				float remaining = (float) (c.getBalance()-amount-fee);
				if(remaining>0)
				{
			        c.setBalance(c.getBalance()-amount-fee);
			        JOptionPane.showMessageDialog(null,"You have withdrawn "+amount);
			        JOptionPane.showMessageDialog(null,"You have charged a fee of "+fee);
			        JOptionPane.showMessageDialog(null,"Your account balance is "+c.getBalance());
			        writeFile(c);
			        break;
				}
				else
					JOptionPane.showMessageDialog(null,"Insuficiant Balance");
			}
		}
	}