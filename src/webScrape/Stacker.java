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
		ArrayList<Integer> indexOfDups = new ArrayList<Integer>();
		ArrayList<Integer> indexOfOgs = new ArrayList<Integer>();
		
		distinctIngredients.addAll(ingredients);
		ingredientSearch.addAll(ingredients);
		Collections.reverse(ingredientSearch);
		int dups = 0;
		int index = 0;
		int counter = 0;
		int counter2 = 0;
		
		for(String ingredient : ingredients) {
			ingredientSearch.remove(ingredientSearch.size()-1);
			counter++;
			counter2 = 0;
			for(String ingredient2 : ingredientSearch) {
				SimilarityStrategy strategy = new JaroWinklerStrategy();
				StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
				double score = service.score(ingredient, ingredient2);
				counter2++;
				
				if(score > 0.80) {
					dups++;
					System.out.println(dups + " " + ingredient + " " + ingredient2);
					int temp = counter;
					int temp2 = ingredientSearch.size() - counter2;
					
					System.out.println(temp + "shittt" + counter2 +  " " + ingredientSearch.size() + "\n\n\n");
					System.out.println(amounts.get(temp));
					System.out.println(amounts.get(temp2));
					
					indexOfOgs.add(temp-1);
					indexOfDups.add(indexOfDups.size(), temp2);
					
					amounts.set(indexOfOgs.get(index), 999 * (amounts.get(temp) + amounts.get(indexOfDups.get(index))));
					amounts.set(temp2, -2.0);
					index++;
					
				}
			}
		}
		//Collections.reverse(indexOfDups);
		
		for(int i = 0; i < indexOfDups.size(); i++) {
			System.out.println(ingredients.get(indexOfOgs.get(i)));
			System.out.println(indexOfOgs.toString());
			System.out.println(ingredients.get(indexOfDups.get(i)));
			System.out.println(indexOfDups.toString());
		}

		System.out.println(amounts.toString());
		System.out.println(distinctIngredients.toString());
		for(int i = 0; i < distinctIngredients.size(); i++) {
			System.out.println(i + "\nIngredient: " + distinctIngredients.get(i) + "\nUnit:" + units.get(i) + "\nAmounts: " + amounts.get(i));
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
