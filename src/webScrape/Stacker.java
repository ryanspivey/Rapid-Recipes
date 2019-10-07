package webScrape;

import java.util.ArrayList;
import java.util.Comparator;

import websites.BaseRecipe;
import webScrape.MergeSort;
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
		System.out.println(recipes.get(0).getIngredients().toString());
		getDuplicates();
		/*
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
		
		/*for(int i = 0; i < allIngFix.size(); i++) {
			System.out.println("\nIngredient :" + allIngFix.get(i).getName() + "\nAmount :" + allIngFix.get(i).getAmount() + "\nUnit :" + allIngFix.get(i).getUnit());
		}*/
	}
	
	
	public static void getDuplicates() {
		
		
		SimilarityStrategy strategy = new JaroWinklerStrategy();
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		
		for(int i = 0; i < recipes.size(); i++) {
			System.out.println(recipes.size());
			if(allIng.isEmpty()) {
				allIng.addAll(recipes.get(i).getIngredients());
			}
			try {
				allIng.addAll(recipes.get(i + 1).getIngredients());
			}
			catch(Exception e) {
			}
			
			for(int j = 0; j < allIng.size(); j++) {
				//compares every element(i) to every other element(j) O(n^2)
				for(int k = j + 1; k < allIng.size(); k++) {
					String target = allIng.get(j).getName();
					String source = allIng.get(k).getName();
					System.out.println(target + " " + source);
						//if i is similar to j then i amount = i + j amounts. (j name, unit, & amt is set to -1 as identifier)
						if(service.score(target, source) > 0.85 ) {
							allIng.set(j, new Ingredient(target, (allIng.get(j).getAmount() + allIng.get(k).getAmount()), allIng.get(j).getUnit()));
							allIng.remove(k);
						}
				}
			}
			
		}
		for(int i= 0; i < allIng.size(); i++) {
			System.out.println(allIng.get(i).getName() + " " + allIng.get(i).getAmount() + " " + allIng.get(i).getUnit());
		}
		
	}

	


	public ArrayList<BaseRecipe> getRecipes() {
		return recipes;
	}
	
}
