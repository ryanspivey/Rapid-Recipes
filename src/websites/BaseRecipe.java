package websites;
import java.util.ArrayList;
import java.util.Collections;

import webScrape.Ingredient;

public class BaseRecipe {
	ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

	public BaseRecipe(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public ArrayList<Ingredient> getIngredients(){
		return ingredients;
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
	
	public int size() {
		return ingredients.size();
	}
	
}
