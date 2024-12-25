package Budget_Tracker_Project;

import java.util.Scanner;

public class BudgetTracker 
{
	private double balance;
	
	public BudgetTracker() {
		balance = 0.0;
	}
	
	public void addIncome(double amount) {
		balance += amount;
	}
	
	public void addExpencse(double amount) {
		balance -= amount;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		BudgetTracker tracker = new BudgetTracker();
		
		while(true) {
			System.out.println("1. Add Income");
			System.out.println("2. Add Expense");
			System.out.println("3. View Balance");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			
			switch(choice) 
			{
			case 1:
				System.out.print("Enter income amount: ");
				double income = sc.nextDouble();
				tracker.addIncome(income);
				System.out.println();
				break;
				
			case 2:
				System.out.print("Enter expense amount: ");
				double expense = sc.nextDouble();
				tracker.addExpencse(expense);
				System.out.println();
				break;
				
			case 3:
				System.out.println("Current Balance: Rs"+tracker.getBalance());
				System.out.println();
				break;
				
			case 4:
				System.out.println("Exiting... Thank you!");
				System.out.println();
				return;
				
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
