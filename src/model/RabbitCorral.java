package model;

public class RabbitCorral extends Habitat{

	private String typePlant;
	private int quantityPlant;
	
	public RabbitCorral(String id, double large, double wide, String typePlant, int quantityPlant) {
		super(id, large, wide);
		
		this.setTypePlant(typePlant);
		this.setQuantityPlant(quantityPlant);
	}
	public RabbitCorral(String specie, String namePet, int age, String breed, int idOwner, String nameOwner,String cellphone, String direction, String time) {
		
		super(specie, namePet, age, breed, idOwner, nameOwner, cellphone, direction, time);
	}

	public String getTypePlant() {
		return typePlant;
	}

	public void setTypePlant(String typePlant) {
		this.typePlant = typePlant;
	}

	public int getQuantityPlant() {
		return quantityPlant;
	}

	public void setQuantityPlant(int quantityPlant) {
		this.quantityPlant = quantityPlant;
	}
}
