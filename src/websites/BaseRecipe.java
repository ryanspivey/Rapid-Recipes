package websites;
import java.util.ArrayList;
import java.util.Collections;

import webScrape.Ingredient;

public class BaseRecipe {
	ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	ArrayList<Ingredient> reversedIngredients = ingredients;

	public BaseRecipe(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
		for(int i = 0; i < ingredients.size(); i++) {
			//System.out.println(ingredients.get(i).getName() + " " + ingredients.get(i).getUnit() + " " + ingredients.get(i).getAmount() + " ");
		}
	}
	
	public ArrayList<Ingredient> getIngredients(){
		return ingredients;
	}
	
	public ArrayList<Ingredient> getReversedIngredients(){
		Collections.reverse(reversedIngredients);
		return reversedIngredients;
	}
	
	public void setIngredient(String ingredient, int i) {
		ingredients.get(i).setName(ingredient);
	}
	
	public Ingredient getIngredient(int i) {
		return ingredients.get(i);
	}
	
	public void setUnit(String unit, int i) {
		ingredients.get(i).setUnit(unit);
	}
	
	public String getUnit(int i) {
		return ingredients.get(i).getUnit();
	}
	
	public void setAmount(Double amount, int i) {
		ingredients.get(i).setAmount(amount);
	}
	
	public Double getAmount(int i) {
		return ingredients.get(i).getAmount();
	}
	
}
