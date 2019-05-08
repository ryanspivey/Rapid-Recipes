package webScrape;

import java.util.Scanner;

import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;
import websites.BudgetBytes;



public class WebScrape {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		final String url = scan.next();
		BudgetBytes link = new BudgetBytes(url);
		
		SimilarityStrategy strategy = new JaroWinklerStrategy();
		String target = "LEMONS";
		String source = "LEMON (OR ABOUT 1/2 TBSP JUICE)";
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		double score = service.score(source, target);
		
		System.out.println(score);

		
		for(int i = 0; i < link.unit.size(); i++) {
			unitConversion convert = new unitConversion(link.unit.get(i), link.amount.get(i));
			System.out.println("Ingredient: " + link.name.get(i) + "\nAmount:" + convert.toMl() + "\nUnit: " + convert.unit + "\n\n");
		}
		
	}

}
