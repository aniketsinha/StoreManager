package com.grocerystore.inventory;

public class Discount {
	private String name;
	private float percent;
	private float flatOff;
	private int type;	//0=percent, 1=flatOff
	private boolean isCapped;
	private float maxPercent;
	private float maxOff;
	
	public Discount(String name, int type0Percent1Flatoff, float percent, float flatOffPrice, boolean isCapped, float maxPercent, float maxOff) {
		this.name = name;
		this.type = type0Percent1Flatoff;
		if(type == 0) {
			this.percent = percent;
			this.maxPercent = (isCapped)?maxPercent:100;
		}
		else {
			this.flatOff = flatOffPrice;
			this.maxOff= (isCapped)?maxOff:Integer.MAX_VALUE;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public float getFlatOff() {
		return flatOff;
	}

	public void setFlatOff(float flatOff) {
		this.flatOff = flatOff;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isCapped() {
		return isCapped;
	}

	public void setCapped(boolean isCapped) {
		this.isCapped = isCapped;
	}

	public float getMaxPercent() {
		return maxPercent;
	}

	public void setMaxPercent(float maxPercent) {
		this.maxPercent = maxPercent;
	}

	public float getMaxOff() {
		return maxOff;
	}

	public void setMaxOff(float maxOff) {
		this.maxOff = maxOff;
	}
	@Override
	public String toString() {
		if( name.equals("No Discount")) {
			return name;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" - ");
		if(type == DiscountType.PERCENT.getDiscountType()) {
			sb.append("Flat ").append(percent).append("% off.");
		}
		else {
			sb.append("Flat Rs.").append(flatOff).append(" off.");
		}
		return sb.toString();
	}
	
}
