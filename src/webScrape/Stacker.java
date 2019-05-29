package webScrape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import websites.BaseRecipe;
import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;


public class Stacker {
	public static ArrayList<BaseRecipe> recipes = new ArrayList<BaseRecipe>();
	public static ArrayList<Ingredient> allIng = new ArrayList<Ingredient>();
	public static ArrayList<Ingredient> allIngFix = new ArrayList<Ingredient>();
	
	
	public static ArrayList<String> ingredients = new ArrayList<String>();
	public static ArrayList<String> units = new ArrayList<String>();
	public static ArrayList<Double> amounts = new ArrayList<Double>();
	
	public static String ingredientCompare;
	
	public Stacker(ArrayList<BaseRecipe> list) {
		Stacker.recipes = list;
		
		for(int i = 0; i < recipes.size(); i++) {
			for(int j = 0; j < recipes.get(i).getIngredients().size(); j++) {
				allIng.add(recipes.get(i).getIngredient(j));
			}
		}
		for(int i = 0; i < allIng.size(); i++) {
			System.out.println(allIng.get(i).getName() + allIng.get(i).getAmount() + allIng.get(i).getUnit());
		}
		System.out.println("shit");
		getDuplicates();
	}
	
	
	public static void getDuplicates() {
		for(int i = 0; i < allIng.size(); i++) {
			allIngFix.add(allIng.get(i));
			for(int j = i + 1; j < allIng.size(); j++) {
					SimilarityStrategy strategy = new JaroWinklerStrategy();
					StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
					String target = allIng.get(i).getName();
					String source = allIng.get(j).getName();
					if(service.score(target, source) > 0.87) {
						//if its higher than 85 add amount of j to i then only add i to the list, if its not higher than 85, add both i and j to the list.
						allIngFix.set(i, new Ingredient(target, (allIng.get(i).getAmount() + allIng.get(j).getAmount()), allIng.get(i).getUnit()));
						allIng.set(j, new Ingredient("-1", -1.0, "-1"));
					}		
			}
		}
		
		ArrayList<Ingredient> found = new ArrayList<Ingredient>();
		for(Ingredient ing : allIngFix) {
			if(ing.getName().equals("-1")) {
				found.add(ing);
			}
		}
		allIngFix.removeAll(found);
		
		for(int i = 0; i < allIngFix.size(); i++) {
			System.out.println("\nIngredient :" + allIngFix.get(i).getName() + "\nAmount :" + allIngFix.get(i).getAmount() + "\nUnit :" + allIngFix.get(i).getUnit());
		}
		
	}

	
	public ArrayList<BaseRecipe> getRecipes() {
		return recipes;
	}
	
}
