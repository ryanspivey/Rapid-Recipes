package webScrape;

public class Fraction {
	public String amount;
	public double conversion;
	
	public Fraction(String amount) {
		this.amount = amount;
		String[] arrString = new String[2];
		Double[] arr = new Double[2];
		
		//if amount is in fraction form then conversion is done
		try {
			conversion = Double.parseDouble(amount);
		}
		catch(NumberFormatException e) {
			arrString = amount.split("/");
			arr[0] = Double.parseDouble(arrString[0]);
			arr[1] = Double.parseDouble(arrString[1]);
			conversion = (arr[0] / arr[1]);
		}
	}
	
	public Double getConversion() {
		return conversion;
	}
}
