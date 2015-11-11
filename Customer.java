package BankAccount;

import java.util.ArrayList;

public class Customer {
	private ArrayList<SavingsAccount>accounts;
	private static String name;
	private static long pNr;
	
	public Customer(String name, long pNr, ArrayList<SavingsAccount> accounts){
		Customer.name = name;
		this.pNr = pNr;
		this.accounts = accounts;
	}
	
	public static void setName(String name){
		name = Customer.name;
	}
	public static String getName(){
		return name;
		
	}
	public static void setPrsNbr(long pNr){
		pNr = Customer.pNr;
	}
	public long pNr(){
		return pNr;
	}
	public void setAccounts(ArrayList<SavingsAccount> accounts){
		this.accounts = accounts;
	}
	public ArrayList<SavingsAccount> getAccounts(){
		return accounts;	
	}
	public String toString(){
		return ("Namn: " + name + "\n" + "Personnummer: " + pNr + "\n" + "Konton: " + accounts);
	}

}
