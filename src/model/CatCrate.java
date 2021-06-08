package model;

public class CatCrate extends Habitat {

	private int maxHigh;
	private int maxWeight;
	
	public CatCrate(String id, double large, double wide, int maxHigh, int maxWeight) {
		super(id, large, wide);
		
		this.setMaxHigh(maxHigh);
		this.setMaxWeight(maxWeight);
	}
	
	public CatCrate(String specie, String namePet, int age, String breed, int idOwner, String nameOwner,String cellphone, String direction, String time) {
		
		super(specie, namePet, age, breed, idOwner, nameOwner, cellphone, direction, time);
	}

	public int getMaxHigh() {
		return maxHigh;
	}

	public void setMaxHigh(int maxHigh) {
		this.maxHigh = maxHigh;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	

}
