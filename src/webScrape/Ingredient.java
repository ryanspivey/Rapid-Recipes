package webScrape;

public class Ingredient {
	String unit;
	String name;
	Double amount;
	
	public Ingredient(String name, Double amount, String unit) {
		this.unit = unit;
		this.name = name;
		this.amount = amount;
		unit.replaceAll("[^a-zA-Z]", "");
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
