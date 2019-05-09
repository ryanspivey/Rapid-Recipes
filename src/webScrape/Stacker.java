package webScrape;

import java.util.ArrayList;
import websites.BaseRecipe;


public class Stacker {
	ArrayList<BaseRecipe> list = new ArrayList<BaseRecipe>();
	
	public Stacker(ArrayList<BaseRecipe> list) {
		this.list = list;
		System.out.println(list.toString());
	}
	
	public ArrayList<BaseRecipe> getList() {
		return list;
	}
	
	
	
}
