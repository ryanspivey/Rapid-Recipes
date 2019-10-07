package webScrape;

import java.util.ArrayList;

import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;

public class MergeSort {
	void merge(ArrayList<Ingredient> list, int l, int m, int r) {
		//find sizes of 2 subarrays
		int n1 = m - l + 1;
		int n2 = r - m;
		
		//create temp arrays
		Ingredient L[] = new Ingredient [n1];
		Ingredient R[] = new Ingredient [n2];
		
		//Copy data to temp arrays
		for(int i = 0; i < n1; i++)
			L[i] = list.get(l + 1);
		for(int j = 0; j < n2; j++)
			R[j] = list.get(m + 1 + j);
		
		/* --Merge Temp Arrays-- */
		
		//Initial indexes of first & second subarrays
		int i = 0, j = 0;
		
		//Initial index of merged subarray array
		SimilarityStrategy strategy = new JaroWinklerStrategy();
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);

		int k = l;
		while(i < n1 && j < n2) {
			String target = L[i].getName();
			String source = R[j].getName();
			double score = service.score(target, source);
			
			if(score <= 0.85) {
				list.set(k, L[i]);
				i++;
			}
			else {
				list.set(k, R[j]);
			}
			k++;
		}
		
		//Copy remaining elements of L[] if any
		while(i < n1) {
			list.set(k, L[i]);
			i++;
			k++;
		}
		
		//Copy remaining elements of R[] if any
		while(j < n2) {
			list.set(k, R[j]);
			j++;
			k++;
		}
	}
	
	void sort(ArrayList<Ingredient> list, int l, int r) {
		SimilarityStrategy strategy = new JaroWinklerStrategy();
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		String target = list.get(l).getName();
		String source = list.get(l).getName();
		double score = service.score(target, source);
		
		if(score < 0.85) {
			//Find middle
			int m = (l + r)/2;
			
			//Sort 1st & 2nd Halves
			sort(list, l, m);
			sort(list, m+1, r);
			
			//Merge what is sorted
			merge(list, l, m, r);
		}
	}
}
