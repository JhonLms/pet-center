package model;

public class DogHouse extends Habitat {
	
	private int quantityToys;
	
	public DogHouse(String id, double large, double wide, int quantityToys) {
		super(id, large, wide);
		
		this.setQuantityToys(quantityToys);
	}
	
	public DogHouse(String specie, String namePet, int age, String breed, int idOwner, String nameOwner,String cellphone, String direction, String time) {
		
		super(specie, namePet, age, breed, idOwner, nameOwner, cellphone, direction, time);
	}

	public int getQuantityToys() {
		return quantityToys;
	}

	public void setQuantityToys(int quantityToys) {
		this.quantityToys = quantityToys;
	}
}
