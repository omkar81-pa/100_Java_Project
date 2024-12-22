package basic_Bank_System;

import java.util.HashMap;
import java.util.Map;

public class Bank 
{
	private Map<String, Account> accounts;
	
	public Bank() {
		this.accounts = new HashMap<>();
	}
	
	public void addAccount(String accountNumber, String customerName, double balance) {
		Account account = new Account(accountNumber, customerName, balance);
		accounts.put(accountNumber, account);
	}
	
	public void displayAccountInfo(String accountNumber) {
		if(accounts.containsKey(accountNumber)) {
			Account account = accounts.get(accountNumber);
			System.out.println("Account Number: "+account.getAccountNumber());
			System.out.println("Customer Name: "+account.getCustomerName());
			System.out.println("Balance: $"+account.getBalance());
		}else {
			System.out.println("Account not found!");
		}
	}
	
	public void performTransaction(String accountNumber, double balance) {
		if(accounts.containsKey(accountNumber)) {
			Account account = accounts.get(accountNumber);
			account.deposit(balance);
			System.out.println("Transection successful. Update balance: $"+account.getBalance());
		}
		else {
			System.out.println("Account not found!");
		}
	}
}
