/**
 * 
 */
package banking;

import java.io.Serializable;

/**
 * @author Jestin,Stephin,Vishnu,Giftson
 *
 */
public class Customer implements Serializable {

	/**
	 * @param args
	 */

		private String name;
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccnumber() {
		return accnumber;
	}
	public void setAccnumber(int accnumber) {
		this.accnumber = accnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
		private int accnumber;
		private String address;
		private String city; 
		private int contact;
		private double balance;
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
	private String AccountType;
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
}

