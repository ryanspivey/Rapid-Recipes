package webScrape;

import java.util.ArrayList;
import java.util.Scanner;

import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;
import websites.BaseRecipe;
import websites.BudgetBytes;



public class WebScrape {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		String url = "";
		ArrayList<BaseRecipe> bases = new ArrayList<BaseRecipe>();
		
		while(!url.equals("-1")) {
			url = scan.next();
			if(!url.equals("-1")) {
				BudgetBytes link = new BudgetBytes(url);
				bases.add(link.getBase());
			}
			else {
				break;
			}
		}
			Stacker stack = new Stacker(bases);
			
			
			
			
		}
		
		SimilarityStrategy strategy = new JaroWinklerStrategy();
		String target = "LEMONS";
		String source = "LEMON (OR ABOUT 1/2 TBSP JUICE)";
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		double score = service.score(source, target);
		
	//	System.out.println(link.getBase().getAmount().toString());
		
		
		//for(int i = 0; i < link.unit.size(); i++) {
		//	unitConversion convert = new unitConversion(link.unit.get(i), link.amount.get(i));
		//	System.out.println("Ingredient: " + link.getBase().getIngredient().get(i) + "\nAmount:" + link.getBase().getAmount().get(i) + "\nUnit: " + link.getBase().getUnit().get(i) + "\n\n");
		//}
		
}



