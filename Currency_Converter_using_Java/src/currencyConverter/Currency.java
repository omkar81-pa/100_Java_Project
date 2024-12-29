package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency 
{
	private String name;
	private String shortName;
	
	private HashMap<String, Double> exchengeValues = new HashMap<String, Double>();
	

    // Constructor
	public Currency(String nameValue, String shortNameValue) {
		this.name = nameValue;
		this.shortName = shortNameValue;
	}
	
	// Getter for name
	public String getName() {
		return this.name;
	}
	
	 // Setter for name
	public void setName(String nameString, String name) {
		this.name = name;
	}
	
	 // Getter for shortName
	public String getShortName() {
		return this.shortName;
	}
	
	 // Setter for shortName
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	 // Getter for exchangeValues
	public HashMap<String, Double> getExchangeValues(){
		return this.exchengeValues;
	}
	
	// Setter for exchangeValues
	public void setExchengeValues(String key, Double value) {
		this.exchengeValues.put(key, value);
	}
	
	 // Set default values for a currency
	public void defaultValues() {
		String currency = this.name;
		
		switch(currency) {
		case "US Dollar":
			this.exchengeValues.put("USD", 1.00);
			this.exchengeValues.put("EUR", 0.93);
			this.exchengeValues.put("GBP", 0.66);
			this.exchengeValues.put("CHF", 1.01);
			this.exchengeValues.put("CNY", 6.36);
			this.exchengeValues.put("JPY", 123.54);
			break;
			
		case "Euro":
			this.exchengeValues.put("USD", 1.073);
			this.exchengeValues.put("EUR", 1.00);
			this.exchengeValues.put("GBP", 0.071);
			this.exchengeValues.put("CHF", 1.08);
			this.exchengeValues.put("CNY", 6.83);
			this.exchengeValues.put("JPY", 132.57);
			break;
			
		case "British Pound":
			this.exchengeValues.put("USD", 1.51);
			this.exchengeValues.put("EUR", 1.41);
			this.exchengeValues.put("GBP", 1.00);
			this.exchengeValues.put("CHF", 1.52);
			this.exchengeValues.put("CNY", 9.60);
			this.exchengeValues.put("JPY", 186.41);
			break;
			
		case "Swiss Franc":
			this.exchengeValues.put("USD", 0.99);
			this.exchengeValues.put("EUR", 0.93);
			this.exchengeValues.put("GBP", 0.66);
			this.exchengeValues.put("CHF", 1.00);
			this.exchengeValues.put("CNY", 6.33);
			this.exchengeValues.put("JPY", 122.84);
			break;
			
		case "CHinese Yuan":
			this.exchengeValues.put("USD", 0.66);
			this.exchengeValues.put("EUR", 0.15);
			this.exchengeValues.put("GBP", 0.11);
			this.exchengeValues.put("CHF", 0.16);
			this.exchengeValues.put("CNY", 1.00);
			this.exchengeValues.put("JPY", 19.41);
			break;
			
		case "Japan Yen":
			this.exchengeValues.put("USD", 0.008);
			this.exchengeValues.put("EUR", 0.007);
			this.exchengeValues.put("GBP", 0.005);
			this.exchengeValues.put("CHF", 0.008);
			this.exchengeValues.put("CNY", 0.051);
			this.exchengeValues.put("JPY", 1.000);
			break;
		}
	}
	
	// Initialize currencies
	public static ArrayList<Currency> init(){
		ArrayList<Currency> currencies = new ArrayList<Currency>();
		
		currencies.add(new Currency("US Doller", "USD"));
		currencies.add(new Currency("Euro", "EUR"));
		currencies.add(new Currency("British Pound", "GBP"));
		currencies.add(new Currency("Swiss Franc", "CHF"));
		currencies.add(new Currency("Chinese Yuan", "CNY"));
		currencies.add(new Currency("Japan Yen", "JPY"));
		
		for(Integer i = 0; i < currencies.size(); i++) {
			currencies.get(i).defaultValues();
		}
		
		return currencies;
	}
	
	// Convert a currency to another
	public static Double convert(Double amount, Double exchengeValue) {
		Double price;
		
		price = amount * exchengeValue;
		
		price = Math.round(price * 100) / 100d; // Round to 2 decimal places
		
		return price;
	}
}
