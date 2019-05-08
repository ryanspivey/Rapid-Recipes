package websites;

import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import webScrape.Fraction;
//git test


public class BudgetBytes {
	public ArrayList <String> name = new ArrayList<String>();
	public ArrayList <String> unit = new ArrayList<String>();
	public ArrayList<String> amountString = new ArrayList<String>();
	public ArrayList<Double> amount = new ArrayList<Double>();
	
	public BudgetBytes(String url) {
		try {
			//reads in ingredients from specific rows from BudgetBytes
			final Document document = Jsoup.connect(url).get();
			for(Element row: document.select(
					"div.wprm-recipe-ingredients-container.wprm-block-text-normal li")) {	
				
				name.add(row.select("span.wprm-recipe-ingredient-name").text().toUpperCase());
				unit.add(row.select("span.wprm-recipe-ingredient-unit").text().toUpperCase());
				amountString.add(row.select("span.wprm-recipe-ingredient-amount").text());	
			}
			
			//calls fraction object to convert fractions to doubles
			for(int i = 0; i < amountString.size(); i++) {
				if(isNumeric(amountString.get(i))) {
					Fraction frac = new Fraction(amountString.get(i));
					amount.add(frac.getConversion());
				}
				else {
					unit.set(i, amountString.get(i).toUpperCase());
					amount.add(1.0);
				}
					
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public String toString() {
		String list = "";
		
		for(int i = 0; i < name.size(); i++) {
			list += "Ingredient: " + name.get(i) + "\nAmount:" + amount.get(i) + "\nUnit: " + unit.get(i) + "\n\n";
		}
		return list;
	}
	
}
