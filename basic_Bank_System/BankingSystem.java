package basic_Bank_System;

public class BankingSystem 
{
	public static void main(String[] args) 
	{
		Bank bank = new Bank();
		
		//add accounts
		bank.addAccount("101", "Omkar Pathak", 10000.0);
		bank.addAccount("102", "Shubam Mishra", 20000.0);
		
		//Parforming transection
		bank.performTransaction("101", 1000.0);
		bank.performTransaction("102", 1500.0);
		System.out.println();
		//Display account information
		bank.displayAccountInfo("101");
		System.out.println();
		bank.displayAccountInfo("102");
		System.out.println();
	}
}
