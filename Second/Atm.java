package Second;

import java.util.Scanner;

public class Atm 
{
	public static boolean validateInputAmount(Double amount) 
	{
	return amount > 0;
	}
	
	public static void main(String[] args) 
	{
		double balance = 10000, withdraw, deposit;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("Amtometed Taller Machine");
			System.out.println("Choose 1 for Withdraw");
			System.out.println("Choose 2 for Deposit");
			System.out.println("Choose 3 for Check balance");
			System.out.println("Choose 4 for Exit");
			System.out.print("Choose the operation you want to perform:");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:  //get the withdraw money
				System.out.print("Enter money to be withdraw: ");
				
				withdraw = sc.nextDouble();
				if(!validateInputAmount(withdraw)) {
					System.out.println("Enter amount greater then zero");
					break;
				}
				
				if(balance >= withdraw) {
					balance = balance - withdraw;
					System.out.println("Please collect your monay");
				}else {
					System.out.println("Insufficiant Balance");
				}
				System.out.println("");
				break;
			case 2:  //get deposite amount from to user
				
				System.out.print("Enter mony to deposite: ");
				 
				deposit = sc.nextDouble();
				if(!validateInputAmount(deposit)) {
					System.out.println("Enter the amount greater then zero");
					break;
				}
				
				balance = balance + deposit;
				System.out.println("Your money has been successfully deposited");
				System.out.println("");
				break;
				
			case 3:
				System.out.println("Balance : "+balance);
				System.out.println("");
				break;
				
			case 4:
				
				System.exit(0);
			}
		}
	}
}
