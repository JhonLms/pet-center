package model;

import java.util.ArrayList;

public class BirdCage extends Habitat{

	private int highCage;
	private int maxBirds;
	
	ArrayList<String> hanging;
	ArrayList<String> onLand;
	
	public BirdCage(String id, double large, double wide, String specie, int highCage, int maxBirds) {
		super(id, large, wide);
		
		this.setHighCage(highCage);
		this.setMaxBirds(maxBirds);
		
		hanging= new ArrayList<String>();
		onLand= new ArrayList<String>();
	}
	
	public BirdCage(String specie, String namePet, int age, String breed, int idOwner, String nameOwner,String cellphone, String direction, String time) {
		
		super(specie, namePet, age, breed, idOwner, nameOwner, cellphone, direction, time);
	}

	public int getHighCage() {
		return highCage;
	}

	public void setHighCage(int highCage) {
		this.highCage = highCage;
	}

	public int getMaxBirds() {
		return maxBirds;
	}

	public void setMaxBirds(int maxBirds) {
		this.maxBirds = maxBirds;
	}
}
