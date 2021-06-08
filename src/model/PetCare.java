package model;


public class PetCare{
	
	//Constantes
	
	public static final int NUMVET = 7;
	public static final int NUMPET = 120;
	
	//Atributos
	
	private String schedule;
	
	//Relaciones
	private Veterinary [] veterinaries;
	private Pet[] pets;
	private Owner[] owners;
	private Habitat [][] habitats;
	private Aquarium [][] reptiles;
	private BirdCage [][] birds;
	private CatCrate [][] cats;
	private DogHouse [][] dogs;
	private RabbitCorral[][] rabbits;
	
	//Metodo constructor
	
	public PetCare(String schedule) {
		
		this.schedule=schedule;
		
		veterinaries= new Veterinary[NUMVET];
		
		pets= new Pet[NUMPET];
		
		owners= new Owner[NUMPET];
		
		habitats= new Habitat[5][6];
		
		reptiles= new Aquarium[2][2];
		
		birds= new BirdCage[2][2];
		
		cats= new CatCrate[3][3];
		
		dogs= new DogHouse[3][3];
		
		rabbits= new RabbitCorral[2][2];
	}
	
	//metodos
	
	public String getSchedule(){
		
		return schedule;
	}
	public void setSchedule(String schedules){
		
		schedule=schedules;
	}
	
	/**
	* Name searchVeterinary <br>
	* @author Jhon Lamus <br>
	* check that there aren't duplicate veterinarians, verifying by means of their id. <br>
	* <b> Pre: </b> there must be at least one veterinarian already registered <br>
	* @param id int saves the value of the veterinary's id. id != null <br>
	* @return find keep comparison of veterinarians information <br>
	*/
	
	public Veterinary searchVeterinary(int id){
		
		Veterinary find=null;
		
		for(int i = 0; i<NUMVET; i++){
			
			if(veterinaries[i]!=null && veterinaries[i].getId()==id){
				
				find=veterinaries[i];
			}
		}
		return find;
	}
	
	/**
	* Name searchPet <br>
	* @author Jhon Lamus <br>
	* compares the pet's name and owner id with the one entered so that the owner,pet relationship only exists once. <br>
	* <b> Pre: </b> there must be at least one pet with its owner <br>
	* @param namePet String saves the pet's name. namePet != null <br>
	* @param idOwner String saves the owner's id. idOwner != null <br>
	* @return find keep the comparison between pets with the owner's id <br>
	*/
	
	public Pet searchPet(String namePet,int idOwner){
		
		Pet find=null;
		
		for(int i = 0; i<NUMPET; i++){
			
			if(pets[i]!=null && pets[i].getNamePet().equalsIgnoreCase(namePet) && pets[i].getOwners().getIdOwner()==idOwner){
				
				find= pets[i];
			}
		}
		return find;
	}
	
	/**
	* Name addVeterinary <br>
	* @author Jhon Lamus <br>
	* method that calls the searchVeterinary method and registers the veterinarian with all his information <br>
	* <b> Pre: </b> the searchVeterinary method must be created or used. <br>
	* <b> Pos: </b> With the searchVeterinary comparison, it sends a message to the user saying that the veterinarian is already registered and in case he/she is not registered, it registers him/her and sends a message that the veterinarian was created correctly. <br>
	* @param id int saves the veterinary's id. id != null <br>
	* @param name String saves the veterinary's name. name != null <br>
	* @param lastName String saves the veterinary's lastName. lastName != null <br>
	* @param register String saves the veterinary's register. register != null <br>
	* @return message returns the message depending on whether or not the veterinarian is already registered. <br>
	*/
	
	public String addVeterinary(int id, String name, String lastName, String register){
		
		String message = null;
		Veterinary sameNameV=searchVeterinary(id);
		
		boolean continues=true;
		
		if(sameNameV!=null){
			
			message="it already is exist this veterinary";
		}
		else{
			for(int i = 0; i<NUMVET && continues; i++){
			
				if(veterinaries[i]==null){
				
					veterinaries[i]=new Veterinary(id,name,lastName,register);
				
					message="the veterinary was created correctly";
				}
			}
			if(continues==true){
				
				message="ERROR, they can't create more veterinaries";
			}
		}
		return message;
	}
	
	/**
	* Name eliminateVet <br>
	* @author Jhon Lamus <br>
	* method that eliminates a veterinarian selected by the user <br>
	* <b> Pre: </b> the searchVeterinary method must be created or used and the id written by the user must be used <br>
	* <b> Pos: </b> returns a message stating that the user was deleted or gives an error if the veterinarian does not exist or if there are pets registered in the center. <br>
	* @param idve int saves the value of veterinary's id. idve != null <br>
	* @return message returns a message stating that the user was deleted or gives an error if the veterinarian does not exist or if there are pets registered in the center.<br>
	*/
	
	public String eliminateVet(int idve){
		
		String message = null;
		Veterinary eliVet= searchVeterinary(idve);
		boolean continues=true;
		
		if(eliVet==null){
				
				message="ERROR, this veterinarian does not exist";
		}
		else{
			for(int i = 0; i<NUMPET && continues; i++){
				if(pets[i]==null && idve==veterinaries[i].getId()) {
				
					veterinaries[i]=null;
				
					message="the veterinarian has been properly removed";
				
					continues=false;
				}
				else {
			
					message="ERROR, the veterinarian cannot be removed because there are pets admitted";
				
					continues=false;
				}
			}
		}
		return message;
	}
	
	/**
	* Name addPet <br>
	* @author Jhon Lamus <br>
	* method that calls the searchPet method and registers the pet with its respective owner with all its information <br>
	* <b> Pre: </b> the searchPet method must be created or used. <br>
	* <b> Pos: </b> With the searchPet comparison, it sends a message to the user saying that the pet-owner relationship already exists and if it does not, it registers it and sends a message that the pet was created correctly. <br>
	* @param specie String saves the pet's specie. specie != null <br>
	* @param namePet String saves the pet's name. namePet	!= null <br>
	* @param age String saves the pet's age. age != null <br>
	* @param breed String saves the pet's breed. breed != null <br>
	* @param symptoms String saves the pet's symptoms. symptoms != null <br>
	* @param priority String saves the pet's priority. priority != null <br>
	* @param idOwner int saves the owner's id. idOwner !=null <br>
	* @param nameOwner String saves the owner's name. nameOwner != null <br>
	* @param cellphone String saves the owner's cellphone. cellphone !=null <br>
	* @param direction String saves the owner's direction. direction !=null <br>
	* @return message returns the message depending on whether the pet-owner relationship is already registered or not. <br>
	*/
	
	public String addPet(String specie, String namePet, int age, String breed, String symptoms, String priority, int idOwner, String nameOwner, String cellphone, String direction){
		
		String message = null;
		Pet samePet=searchPet(namePet,idOwner);
		
		boolean continues=true;
		
		if(samePet!=null){
				
				message="it already exists is combination pet's name and owner's name";
		}
		else{
			for(int i = 0; i<NUMPET && continues; i++){
				
				if(pets[i]==null){
					
					pets[i]=new Pet(specie,namePet,age,breed,symptoms,priority,idOwner,nameOwner,cellphone,direction);
					continues=false;
					message="the pet was entered correctly";
				}
			}
			if(continues==true){
				
				message="They can't enter more pets";
			}
		}
		return message;
	}
	
	/**
	* Name eliPet <br>
	* @author Jhon Lamus <br>
	* method that eliminates a pet selected by the user <br>
	* <b> Pre: </b> the pet's name must be brought in from main <br>
	* <b> Pos: </b> after comparison returns a message depending on whether the pet is in the Waiting state or not <br>
	* @param nameP String saves the pet's name. nameP != null <br>
	* @return message returns a message saying that the pet was successfully deleted or gives an error because the pet is not in the Waiting state. <br>
	*/
	
	public String eliPet(String nameP){
		
		String message = null;
		Pet elimPet=searchPet(nameP,0);
		
		boolean continues=true;
		
		if(elimPet==null) {
			
			message="ERROR, There is not pet to eliminate";
		}
		else {
			for(int i = 0; i<NUMPET && continues; i++){
				if(pets[i].getStatus()==Status.WAITING && nameP==pets[i].getNamePet()) {
				
					pets[i]=null;
				
					message="the pet has been properly removed";
				
					continues=false;
				}
				else {
			
					message="ERROR, the pet is not waiting to be cared for";
				
					continues=false;
				}
			}
		}
		return message;
	} 
	
	/**
	* Name petPriority <br>
	* @author Jhon Lamus <br>
	* Method that chooses the pet depending on its priority starting from 1 to 5<br>
	* <b> Pre: </b> the searchPet method must be created or used. <br>
	* <b> Pos: </b> depending on the comparison returns the first pet with the highest priority <br>
	* @param specie String saves the pet's specie. specie != null <br>
	* @param namePet String saves the pet's name. namePet	!= null <br>
	* @param age String saves the pet's age. age != null <br>
	* @param breed String saves the pet's breed. breed != null <br>
	* @param symptoms String saves the pet's symptoms. symptoms != null <br>
	* @param priority String saves the pet's priority. priority != null <br>
	* @param idOwner int saves the owner's id. idOwner !=null <br>
	* @param nameOwner String saves the owner's name. nameOwner != null <br>
	* @param cellphone String saves the owner's cellphone. cellphone !=null <br>
	* @param direction String saves the owner's direction. direction !=null <br>
	* @return message returns the first pet with the highest priority <br>
	*/
	
	public Pet petPriority(String specie, String namePet, int age, String breed, String symptoms, String priority, int idOwner, String nameOwner, String cellphone, String direction){
		
		Pet prioPet=searchPet(namePet,idOwner);
		Pet levelPrio=null;
		
		boolean continues=true;
			
		if(prioPet==null){
				
			levelPrio=prioPet;
				
			continues=false;
		}
		else {
			for(int i = 0; i<NUMPET && continues; i++){
					
				if(pets[i].getPriority()==Priority.PRIORITY1 && pets[i].getStatus()==Status.WAITING){
				
					pets[i].setNumAttention(Pet.getNumAttention()+1);
					levelPrio=pets[i];
				
					continues=false;
				}
				else if(pets[i].getPriority()==Priority.PRIORITY2 && pets[i].getStatus()==Status.WAITING){
				
					pets[i].setNumAttention(Pet.getNumAttention()+1);
					levelPrio=pets[i];
				}
				else if(pets[i].getPriority()==Priority.PRIORITY3 && pets[i].getStatus()==Status.WAITING){
				
					pets[i].setNumAttention(Pet.getNumAttention()+1);
					levelPrio=pets[i];
				}
				else if(pets[i].getPriority()==Priority.PRIORITY4 && pets[i].getStatus()==Status.WAITING){
				
					pets[i].setNumAttention(Pet.getNumAttention()+1);
					levelPrio=pets[i];
				}
				else if(pets[i].getPriority()==Priority.PRIORITY5 && pets[i].getStatus()==Status.WAITING){
				
					pets[i].setNumAttention(Pet.getNumAttention()+1);
					levelPrio=pets[i];
				}
			}
		}
		return levelPrio;
	}
	
	/**
	* Name addConsult <br>
	* @author Jhon Lamus <br>
	* method that creates a consult <br>
	* <b> Pre: </b> you must create or use the searchVeterinary method, the searchPet method and the petPriority method. <br>
	* <b> Pos: </b> creates the consultation or sends an error that the veterinarian does not exist, is not available or there is no pet available to be attended.  <br>
	* @param idV int saves the values of Veterinary's id. idV != null <br>
	* @return message returns a message showing that the consultation was created correctly or gives an error if the veterinary id does not exist, is not available or there is no pet available to be treated. <br>
	*/
	
	public String addConsult(int idV){
		
		String message = null;
		Veterinary idVeri=searchVeterinary(idV);
		
		
		if(idVeri==null){
				
				message="ERROR, there is not veterinarian's id";
		}
		else{
			if(idVeri.getAvailable()!=true){
				
				message="the veterinarian is not available";
			}
			else{
				Pet next= petPriority(message, message, idV, message, message, message, idV, message, message, message);
				
				if(next==null){
					
					message="ERROR, No pets available for service";
				}
				else{
					
					idVeri.setAvailable(false);
					idVeri.setConsultation(next);
					next.setStatus(Status.INCONSULT);
					next.setVeterinaryConsul(idVeri);
					
					message="The consultation was started correctly";
				}
			}
		}
		return message;
	}
	
	/**
	* Name endConsult <br>
	* @author Jhon Lamus <br>
	* method that ends consultation <br>
	* <b> Pre: </b> you must create or use the searchVeterinary method and the searchPet method <br>
	* <b> Pos: </b> ends the consultation and leaves the veterinarian available for another consultation <br>
	* @param idv int stores the values related to the veterinary's id. idv != null <br>
	* @param namesPet String stores the pet's name. ser != null <br>
	* @param num int stores the values related to that whether or not to hospitalize the pet. edu != null <br>
	* @return message returns a message saying that the query has finished successfully or gives an error if the veterinarian does not exist <br>
	*/
	
	public String endingConsult(int idv, String namesPet, int num){
		
		String message = null;
		Veterinary checkVet= searchVeterinary(idv);
		Pet checkPet= searchPet(namesPet,num);
		
		
		if(checkVet==null){
				
				message="ERROR, this veterinarian does not exist";
		}
		else{
			
			if(checkPet.getStatus()==Status.INCONSULT && checkVet.getAvailable()==false && num==1){
				
				
				checkVet.setAvailable(true);
				
				checkVet.setConsults(Veterinary.getConsults()+1);
				
				checkVet.setConsultation(null);
				
				message="the consult was successfully completed";
			}
			else if(checkPet.getStatus()==Status.INCONSULT && checkVet.getAvailable()==false && num==2){
				
				
				checkVet.setAvailable(true);
				
				checkVet.setConsults(Veterinary.getConsults()+1);
				
				checkVet.setConsultation(null);
				
				checkPet.setStatus(Status.HOSPITALIZATION);
				
				message="the consult was successfully completed";
			}
		}
		return message;
	}
	
	/**
	* Name waitPet <br>
	* @author Jhon Lamus <br>
	* method that adds up the pets that have not been attended to <br>
	* @return message returns a message saying the number of unattended pets are with the number in question. <br>
	*/
	
	public String waitPet(){
		
		String message = "";
		int check=0;
		
		for(int i = 0; i<NUMPET; i++){
			
			if(pets[i].getStatus()==Status.WAITING) {
			
				check++;
			}
		}
		
		message="the number of pets that have not been attended to are: "+check;
			
		return message;
	}
	
	/**
	* Name searchHabitat <br>
	* @author Jhon Lamus <br>
	* method that runs through the matrix when there is at least one habitat created. <br>
	* <b> Pre: </b> there must be at least one habitat created <br>
	* @param id String saves the habitat identifier. id !=null<br>
	* @return message Returns a message depending on whether the habitat is already created or if no more habitats can be created.  <br>
	*/
	
	public Habitat searchHabitat(String id){
		
		Habitat find=null;
		
		for(int i = 0; i<habitats.length; i++){
			
			for(int j=0; j<habitats.length; j++) {
				
				if(habitats[i][j]!=null && habitats[i][j].getId()==id){
					
					find=habitats[i][j];
				}
			}	
		}
		return find;
	}
	
	/**
	* Name searchDayCare <br>
	* @author Jhon Lamus <br>
	* method that runs through the matrix when there is at least one pet entered. <br>
	* <b> Pre: </b> there must be at least one pet entered <br>
	* @param namePet String saves the pet's name. namePet !=null<br>
	* @param idOwner int saves the owner's id of the pet. idOwner !=null<br>
	* @return message Returns a message depending on whether the pet is already entered or if no more pet can be entered.  <br>
	*/
	
	public Habitat searchDayCare(String namePet, int idOwner){
		
		Habitat find=null;
		
		for(int i = 0; i<habitats.length; i++){
			
			for(int j=0; j<habitats.length; j++) {
				
				if(habitats[i][j]!=null && owners[i].getIdOwner()==idOwner){
					
					find=habitats[i][j];
				}
			}	
		}
		return find;
	}
	
	/**
	* Name addDayCare <br>
	* @author Jhon Lamus <br>
	* method that registers the pet in the nursery in its respective habitat. <br>
	* <b> Pre: </b> the searchDayCare method must be created or used <br>
	* <b> Pos: </b> With the searchDayCare comparison, sends a message to the user depending on whether the pet is already registered in the nursery, or the pet is registered correctly or the habitat is already full.. <br>
	* @param specie String saves the pet's specie. specie != null <br>
	* @param namePet String saves the pet's name. namePet	!= null <br>
	* @param age String saves the pet's age. age != null <br>
	* @param breed String saves the pet's breed. breed != null <br>
	* @param idOwner int saves the owner's id. idOwner !=null <br>
	* @param nameOwner String saves the owner's name. nameOwner != null <br>
	* @param cellphone String saves the owner's cellphone. cellphone !=null <br>
	* @param direction String saves the owner's direction. direction !=null <br>
	* @param time String saves the time that pet will be in the DayCare. time != null <br>
	* @return message Returns a message depending on whether the pet is already entered or if no more pet can be entered because is full the habitat for this pet.  <br>
	*/
	

	public String addDayCare(String specie, String namePet, int age, String breed, int idOwner, String nameOwner,String cellphone, String direction, String time) {
		
		String message=null;
		Habitat samePet=searchDayCare(namePet, idOwner);
		
		boolean continues=true;
		
		if(samePet!=null){
				
				message="it already exists is combination pet's name and owner's name";
		}
		else{
			for(int i = 0; i<habitats.length && continues; i++){
				
				for(int j=0; i<habitats.length && continues; i++ ) {
					
					if(habitats[i][j]==null && habitats[i][j].getSpecie().equalsIgnoreCase("reptil")){
						
						
						continues=false;
						message="Sorry, I tried it but honestly it was very complicated to perform the method.";
					}
				}
				
				
			}
			if(continues==true){
				
				message="They can't enter more pets";
			}
		}
		
		return message;
	}
	
	/**
	* Name addDayCare <br>
	* @author Jhon Lamus <br>
	* method that created the habitats with its respective id and dimensions <br>
	* <b> Pre: </b> the searchHabitat method must be created or used <br>
	* <b> Pos: </b> With the searchHabitat comparison, sends a message to the user depending on whether the habitat is already created in the nursery, or the habitat is created correctly or all habitats are already created. <br>
	* @param id String saves the habitat's id. id != null <br>
	* @param large double saves the habitat's large. large != null <br>
	* @param wide double saves the habitat's wide. wide != null <br>
	* @return message Returns a message depending on whether the habitat is already created or if no more habitats can be created because all habitats are already created  <br>
	*/

	public String createHabitat(String id, double large, double wide) {
		String message=null;
		Habitat sameHabitat= searchHabitat(id);
		
		boolean continues=true;
		
		if(sameHabitat!=null) {
			message="it already exists is habitat";
		}
		else{
			
			for(int i = 0; i<habitats.length; i++){
				
				for(int j=0; j<habitats.length; j++) {
					
					if(habitats[i][j]==null ){
						
						
						continues=false;
						message="Sorry, I tried it but honestly it was very complicated to perform the method.";
					}
				}
			}
			if(continues==true){
					
				message="They can't enter more habitats";
			}
				
		}
		return message;
	}
}
