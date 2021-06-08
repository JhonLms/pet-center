package model;

public abstract class Habitat {
	
	public final int FILA=5, COLUMNA=6;
	private String id;
	private double large;
	private double wide;
	private String specie;
	private String namePet;
	private int age;
	private String breed;
	private Owner owners;
	
	String [][] habitats;
	
	public Habitat(String id, double large, double wide) {
		
		this.setId(id);
		this.setLarge(large);
		this.setWide(wide);
		
		
		habitats= new String [FILA][COLUMNA];
		
		
	}
	
	public Habitat(String specie, String namePet, int age, String breed, int idOwner, String nameOwner,String cellphone, String direction, String time) {
		
		this.setSpecie(specie);
		this.setNamePet(namePet);
		this.setAge(age);
		this.setBreed(breed);
		
		habitats= new String [FILA][COLUMNA];
		setOwners(new Owner(idOwner,nameOwner,cellphone,direction));
	}

	public double getWide() {
		return wide;
	}

	public void setWide(double wide) {
		this.wide = wide;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getLarge() {
		return large;
	}

	public void setLarge(double large) {
		this.large = large;
	}
	
	public void multiMatriz() {
		
		for(int i=0; i<habitats.length-2;i++) {
			
			for(int j=0; j<habitats[0].length-3;j++) {
				
			}
		}
		
		for(int i=0;i<habitats.length-2;i++) {
			for(int j=3;j<habitats[0].length;i++) {
				
			}
		}
		
		for(int i=3; i<habitats.length;i++) {
			for(int j=0;j<habitats[0].length-4;i++) {
				
			}
		}
		for(int i=3; i<habitats.length;i++) {
			for(int j=2;j<habitats[0].length-2;i++) {
				
			}
		}
		for(int i=3; i<habitats.length;i++) {
			for(int j=4;j<habitats[0].length;i++) {
				
			}
		}
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getNamePet() {
		return namePet;
	}

	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Owner getOwners() {
		return owners;
	}

	public void setOwners(Owner owners) {
		this.owners = owners;
	}
}
