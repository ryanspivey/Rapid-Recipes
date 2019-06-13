package webScrape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
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
		
		for(int i = 0; i < allIngFix.size(); i++) {
			System.out.println("\nIngredient :" + allIngFix.get(i).getName() + "\nAmount :" + allIngFix.get(i).getAmount() + "\nUnit :" + allIngFix.get(i).getUnit());
		}
	}
	
	
	public static void getDuplicates() {
		String userInput = "";
		Scanner scan = new Scanner(System.in);
	    SimilarityStrategy strategy = new JaroWinklerStrategy();
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		
		for(int i = 0; i < allIng.size(); i++) {
			allIngFix.add(allIng.get(i));
			for(int j = i + 1; j < allIng.size(); j++) {
					String target = allIng.get(i).getName();
					String source = allIng.get(j).getName();
					if(service.score(target, source) > 0.90) {
						//if its higher than 85, set the amount of i index  as i + j amounts.
						allIngFix.add(j, new Ingredient(target, (allIng.get(i).getAmount() + allIng.get(j).getAmount()), allIng.get(i).getUnit()));
						allIng.set(i, new Ingredient("-1", -1.0, "-1"));
					}
					else if(service.score(target, source) > 0.80 && service.score(target, source) < 0.90) {
					    System.out.println("Should these ingredients be combined (Y/N) :\n" + target + " & " + source);
					    userInput = scan.next();
					    if(userInput.equals("Y")) {
					        allIngFix.add(j, new Ingredient(target, (allIng.get(i).getAmount() + allIng.get(j).getAmount()), allIng.get(i).getUnit()));
	                        allIng.set(i, new Ingredient("-1", -1.0, "-1"));
					    }
					    
					}
			}
		}
		
		ArrayList<Ingredient> found = new ArrayList<Ingredient>();
		for(Ingredient ing : allIngFix) {
			if(ing.getName().equals("-1")) {
				found.add(ing);
			}
		}
		System.out.println(allIngFix.size());
		allIngFix.removeAll(found);
		System.out.println(allIngFix.size());
		
	}
	
	private void addObject(int i, Object object, ArrayList list) {
	    while(list.size() < i) {
	        list.add(list.size(), null);
	    }
	    list.add(i, object);
	}

	
	public ArrayList<BaseRecipe> getRecipes() {
		return recipes;
	}
	
}
