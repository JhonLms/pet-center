package model;

public class Pet{
	
	private String species;
	private String namePet;
	private int age;
	private String breed;
	private String symptoms;
	private Priority priority;
	private Status status;
	public static int numAttention;
	
	private Owner owners; 
	private Veterinary veterinaryConsul;
	
	
	public Pet(String species, String namePet, int age, String breed,String symptoms,String priority, int idOwner,String nameOwner,String cellphone,String direction){
		
		this.species=species;
		this.namePet=namePet;
		this.age=age;
		this.breed=breed;
		this.symptoms=symptoms;
		this.priority=Priority.valueOf(priority);
		status=Status.WAITING;
		numAttention=0;
		
		owners=new Owner(idOwner,nameOwner,cellphone,direction);
		veterinaryConsul=null;
	}
	
	public String getSpecies(){
		
		return species;
	}
	
	public String getNamePet(){
		
		return namePet;
	}
	
	public int getAge(){
		
		return age;
	}
	
	public String getBreed(){
		
		return breed;
	}
	
	public String getSymptoms(){
		
		return symptoms;
	}
	
	public Priority getPriority(){
		
		return priority;
	}
	
	public void setPriority(Priority newPriority){
		
		newPriority=priority;
	}
	
	public Status getStatus(){
		
		return status;
	}
	
	public void setStatus(Status newStatus){
		
		newStatus=status;
	}
	
	public Owner getOwners(){
		
		return owners;
	}
	
	public Veterinary getVeterinaryConsul(){
		
		return veterinaryConsul;
	}
	
	public void setVeterinaryConsul(Veterinary newVeterinaryConsul){
		
		newVeterinaryConsul=veterinaryConsul;
	}

	public static int getNumAttention() {
		
		return numAttention;
	}
	
	public void setNumAttention(int newNumAttention) {
		
		newNumAttention=numAttention;
	}
}
