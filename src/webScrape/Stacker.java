package webScrape;

import java.util.ArrayList;
import java.util.Comparator;

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
		/*SimilarityStrategy strategy = new JaroWinklerStrategy();
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		
		//adds every element (index i of list) to a list 
		for(int i = 0; i < allIng.size(); i++) {
			allIngFix.add(allIng.get(i));
			//compares every element(i) to every other element(j) O(n^2)
			for(int j = i + 1; j < allIng.size(); j++) {
				String target = allIng.get(i).getName();
				String source = allIng.get(j).getName();
					//if i is similar to j then i amount = i + j amounts. (j name, unit, & amt is set to -1 as identifier)
					if(service.score(target, source) > 0.85 ) {
						allIngFix.set(i, new Ingredient(target, (allIng.get(i).getAmount() + allIng.get(j).getAmount()), allIng.get(i).getUnit()));
						allIng.set(j, new Ingredient("-1", -1.0, "-1"));
					}		
			}
		}
		
		Ingredient temp = new Ingredient("-1", -1.0, "-1");
		ArrayList<Ingredient> found = new ArrayList<Ingredient>();
		//when -1 is found, add it to a list
		for(Ingredient ing : allIngFix) {
			if(ing.getName().equals("-1")) {
				found.add(ing);
			}
		}
		System.out.println(allIngFix.size());
		//remove the entire (-1)found list from the ingredient list
		allIngFix.removeAll(found);
		System.out.println(allIngFix.size());
		*/
		allIng.sort();
	}
	
	public static class StringComparator implements Comparator<Ingredient>{
		@Override
		public int compare(Ingredient ing1, Ingredient ing2) {
			SimilarityStrategy strategy = new JaroWinklerStrategy();
			StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
			String target = ing1.getName();
			String source = ing2.getName();
			
			return service.score(target, source).compareTo(0.80);
		}
		
	}

	
	public ArrayList<BaseRecipe> getRecipes() {
		return recipes;
	}
	
}
