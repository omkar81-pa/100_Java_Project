package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MaiinClass {

	public static void main(String[] args) {
		//Initialize currencies
		ArrayList<Currency> currencies = Currency.init();
		
		//Create a map for quick lookup by short name
		HashMap<String, Currency> currencyMap = new HashMap<String, Currency>();
		
		for(Currency currency : currencies) {
			currencyMap.put(currency.getShortName(), currency);
		}
		
		//User interaction
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Available Currencies");
		for(Currency currency : currencies) {
			System.out.println(currency.getShortName()+" - "+ currency.getName());
		}
		
		// Get source currency
		System.out.print("\nEnter the source currency short name (e.g., USD): ");
		String sourceCurrencyCode = sc.nextLine().toUpperCase();
		
		// Get target currency
		System.out.print("\nEnter the target currency short name (e.g., EUR): ");
		String targetCurrencyCode = sc.nextLine().toUpperCase();
		
		 // Get amount to convert
		System.out.print("\nEnter the amount to convert: ");
		double amount = sc.nextDouble();
		
		// Validate input and perform conversion
		if(currencyMap.containsKey(sourceCurrencyCode) && currencyMap.containsKey(targetCurrencyCode)) {
			Currency sourceCurrency = currencyMap.get(sourceCurrencyCode);
            Double exchangeRate = sourceCurrency.getExchangeValues().get(targetCurrencyCode);
            
            if(exchangeRate != null) {
            	double convertedAmount = Currency.convert(amount, exchangeRate);
            	System.out.printf("\n%.2f %s = %.2f %s\n", amount, sourceCurrencyCode, convertedAmount, targetCurrencyCode);
            }else {
            	System.out.println("\nExchenge rate not available for the selected currencies.");
            }
		}else {
			System.out.println("\nInvalid currancy code entered.");
		}
		sc.close();
	}
}
