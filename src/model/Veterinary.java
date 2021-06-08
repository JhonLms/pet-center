package model;

public class Veterinary{
	
	private int id;
	private String name;
	private String lastName;
	private String register;
	private boolean available;
	private Pet consultation;
	private static int consults;
	
	public Veterinary(int id, String name, String lastName, String register){
		
		this.id=id;
		this.name=name;
		this.lastName=lastName;
		this.register=register;
		available=true;
		consultation=null;
		consults=0;
	}
	
	public int getId(){
		
		return id;
	}
	
	public String getName(){
		
		return name;
	}
	
	public String getLastName(){
		
		return lastName;
	}
	
	public String getRegister(){
		
		return register;
	}
	
	public boolean getAvailable(){
		
		return available;
	}
	
	public void setAvailable(boolean newAvailable){
		
		newAvailable=available;
	}
	
	public Pet getConsultation(){
		
		return consultation;
	}
	
	public void setConsultation(Pet newConsultation){
		
		newConsultation=consultation;
	}
	
	public static int getConsults(){
		
		return consults;
	}
	
	public void setConsults(int newConsults){
		
		newConsults= consults;
	}
}