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
	ArrayList<BaseRecipe> list = new ArrayList<BaseRecipe>();
	
	
	public static ArrayList<String> ingredients = new ArrayList<String>();
	public static ArrayList<String> units = new ArrayList<String>();
	public static ArrayList<Double> amounts = new ArrayList<Double>();
	
	public static String ingredientCompare;
	
	public Stacker(ArrayList<BaseRecipe> list) {
		this.list = list;
		for(int i = 0; i < list.size(); i++) {
			ingredients.addAll(list.get(i).getIngredient());
			units.addAll(list.get(i).getUnit());
			amounts.addAll(list.get(i).getAmount());
		}
		getDuplicates(ingredients);

		
	}
	
	/*
	public void findDupes() {
		SimilarityStrategy strategy = new JaroWinklerStrategy();
		
		System.out.println(score);
		
		HashSet<String> map = new HashSet<String>();
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.get(i).getIngredientNum(); j++) {
				if(list.get(i).getIngredient().contains()) {	
					map.add(list.get(i).getIngredient().get(j));
				}
					
			}
		}
		String target = "KING ";
		String source = "BREAD FLOUR";
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		double score = service.score(source, target);
		
	}
	*/
	
	public static void getDuplicates(ArrayList<String> list) {
		ArrayList<String> ingredientSearch = new ArrayList<String>();
		ArrayList<String> distinctIngredients = new ArrayList<String>();
		distinctIngredients.addAll(ingredients);
		ingredientSearch.addAll(ingredients);
		Collections.reverse(ingredientSearch);
		int dups = 0;
		
		for(String ingredient : ingredients) {
			ingredientSearch.remove(ingredientSearch.size()-1);
			for(String ingredient2 : ingredientSearch) {
				SimilarityStrategy strategy = new JaroWinklerStrategy();
				StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
				double score = service.score(ingredient, ingredient2);
				
				if(score > 0.80) {
					dups += 1;
					System.out.println(dups + " " + ingredient + " " + ingredient2);
					int temp = distinctIngredients.indexOf(ingredient);
					int temp2 = distinctIngredients.indexOf(ingredient2);
					distinctIngredients.remove(ingredient2);
					units.remove(temp2);
					amounts.set(temp, 99 * (amounts.get(temp) + amounts.get(temp2)));
					amounts.set(temp2, -2.0);
					System.out.println(amounts.size());
					System.out.println(units.size());
					
				}
			}
		}

		System.out.println(amounts.toString());
		System.out.println(distinctIngredients.toString());
		for(int i = 0; i < distinctIngredients.size(); i++) {
			System.out.println("\nIngredient: " + distinctIngredients.get(i) + "\nUnit:" + units.get(i) + "\nAmounts: " + amounts.get(i));
		}
		
		
	}
	
	
	/*
	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if(object == null || object.getClass() != getClass()) {
			result = false;
		}
		else if(object instanceof String){
			SimilarityStrategy strategy = new JaroWinklerStrategy();
			StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
			String target = (String) object;
			String source = ingredientCompare;
			double score = service.score(source, target);
			if(score > 0.85) {
				System.out.println("shit");
				result = true;
			}
		}
		return result;
	}
	*/
	
	public ArrayList<BaseRecipe> getRecipes() {
		return list;
	}
	
	
	
}
