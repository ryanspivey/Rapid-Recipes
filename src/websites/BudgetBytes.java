package websites;


import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import webScrape.Fraction;
import webScrape.Ingredient;
//git testing testing
import webScrape.unitConversion;
import webScrape.unitConversion;

public class BudgetBytes {
	public BaseRecipe base;
	public ArrayList <String> name = new ArrayList<String>();
	public ArrayList <String> unit = new ArrayList<String>();
	public ArrayList <String> unitMl = new ArrayList<String>();
	public ArrayList<String> amountString = new ArrayList<String>();
	public ArrayList<Double> amount = new ArrayList<Double>();
	public ArrayList<Double> amountMl = new ArrayList<Double>();
	ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	
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
				if(amountString.get(i).contains("/")) {
					try {
						Fraction frac = new Fraction(amountString.get(i));
						amount.add(i, frac.getConversion());
					}
					catch(NumberFormatException e){
						e.printStackTrace();
					}
				}
				else if(amountString.get(i).contains(" ")) {
					try {
						String[] array = amountString.get(i).split(" ");
						amount.add(Double.parseDouble(array[0]));
						unit.set(i, array[1]);
					}
					catch(Exception e) {
						System.out.print("Invalid Amount");
					}
				}
				else if(amountString.get(i).equals("")) {
					amount.add(1.0);
				}
				else {
					amount.add(Double.parseDouble(amountString.get(i)));
				}
					
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		for(int i = 0; i < amount.size(); i++) {
			unitConversion convert = new unitConversion(unit.get(i), amount.get(i));
			ingredients.add(new Ingredient(name.get(i), convert.toMl(), convert.unit));
		}
		base = new BaseRecipe(ingredients);
	}
	
	public BaseRecipe getBase() {
		return base;
	}

	
	
	public String toString() {
		String list = "";
		
		for(int i = 0; i < name.size(); i++) {
			list += "Ingredient: " + name.get(i) + "\nAmount:" + amount.get(i) + "\nUnit: " + unit.get(i) + "\n\n";
		}
		return list;
	}
	
}
