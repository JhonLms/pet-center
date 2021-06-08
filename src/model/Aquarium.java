package model;

public class Aquarium extends Habitat {
	
	public static final char AMFIBHIAM= 'a';
	public static final char TERRA= 't';
	
	private String material;
	private char type;
		
	public Aquarium(String id, double large, double wide, String material, char type) {
		super(id, large, wide);
		
		this.material=material;
		this.type=type;
	}
	
	public Aquarium(String specie, String namePet, int age, String breed, int idOwner, String nameOwner,String cellphone, String direction, String time) {
		
		super(specie, namePet, age, breed, idOwner, nameOwner, cellphone, direction, time);
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}	
}
