package webScrape;

public class unitConversion {
	public String unit;
	public Double amount;
	
	public unitConversion(String unit, Double amount) {
		this.unit = unit;
		this.amount = amount;
	}
	
	//cases must be uppercase
	public Double toMl() {
		switch(unit) {
		case "TSP":
			amount *= 5.0;
			unit = "ML";
			break;
		case "TBSP":
			amount *= 15.0;
			unit = "ML";
			break;
		case "FL OZ":
			amount *= 30.0;
			unit = "ML";
			break;
		case "CUP":
		case "CUPS":
			amount *= 240.0;
			unit = "ML";
			break;
		case "QT":
			amount *= 946.353;
			unit = "ML";
			break;
		case "GAL":
			amount *= 3785.41;
			unit = "ML";
			break;
		case "PT":
			amount *= 475.0;
			unit = "ML";
			break;
		case "PINCH":
			amount *= 0.31;
			unit = "ML";
		default:
			amount *= 1;
		}
		
		return amount;
	}
	
}
