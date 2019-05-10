package websites;
import java.util.ArrayList;

public class BaseRecipe {
	ArrayList<String> ingredient = new ArrayList<String>();
	ArrayList<Double> amount = new ArrayList<Double>();
	ArrayList<String> unit = new ArrayList<String>();
	
	
	public BaseRecipe(ArrayList<String> ingredient, ArrayList<Double> amount, ArrayList<String> unit) {
		this.ingredient = ingredient;
		this.amount = amount;
		this.unit = unit;
	}
	
	public int getIngredientNum() {
		return ingredient.size();
	}

	public ArrayList<String> getIngredient() {
		return ingredient;
	}


	public void setIngredient(ArrayList<String> ingredient) {
		this.ingredient = ingredient;
	}


	public ArrayList<Double> getAmount() {
		return amount;
	}


	public void setAmount(ArrayList<Double> amount) {
		this.amount = amount;
	}


	public ArrayList<String> getUnit() {
		return unit;
	}


	public void setUnit(ArrayList<String> unit) {
		this.unit = unit;
	}
	
}
