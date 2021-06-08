package ui;

/**
* Tarea integradora2: PetCenter
*
* @author Jhon Alexander Lamus 
*/

import java.util.Scanner;

import model.PetCare;

public class Main{
	 
	public static final PetCare infPetCare=new PetCare("schedule"); 
	private static final Scanner sc= new Scanner (System.in);
	
	public static void main (String[]args){
		
		int option=0;
		int option2=0;
		int option3=0;
		
		while (option!=9){
			
			option=menu();
			
			switch (option){
			
				case 1:
					menuEmergency();
					
					break;
			
				case 2:
					menuHabitats();
					break;
				
				case 9:
					break;
				
				default: System.out.println("ERROR. Invalide Option.");
			}
		}
		while (option2!=9){
			
			option2=menuEmergency();
			
			switch (option){
			
				case 1:
					registerVeterinary();
					
					break;
			
				case 2:
					eliminateVeterinary();
					break;
				
				case 3:
					registerPet();
					break;
			
				case 4:
					eliminatePet();
					break;	
				
				case 5:
					consult();
					break;
				
				case 6:
					endConsult();
					break;
					
				case 7:
					notAttention();
					break;
				
				case 9:
					break;
				
				default: System.out.println("ERROR. Invalide Option.");
			}
		}
		while (option3!=9){
			
			option3=menuHabitats();
			
			switch (option){
			
				case 1:
					creationHabitat();
					break;
			
				case 2:
					registerDaycarePet();
					break;
				
				case 3:
					
					break;
			
				case 4:
					
					break;	
				
				case 5:
					
					break;
				
				case 9:
					break;
				
				default: System.out.println("ERROR. Invalide Option.");
			}
		}
	}
	
	/**
	* Name: menu <br>
	* @author Jhon Lamus <br>
	* menu method, it's used to create the main menu  <br>
	* <b> Pre: </b> you must create a switch in Main that contains all the menu options <br>
	*/
	
	public static int menu(){
		
		int selected=0;
		int a=0;
		
		System.out.println("\n Choose the service you wish to join: \n");
		System.out.println("1: Veterinary emergencies");
		System.out.println("2: Pet daycare");
		System.out.println("9: Exit of the program ");
		
		while (a==0){
			
			selected=sc.nextInt();
			sc.nextLine();
		
			if (selected>9 && selected<9&& selected>2){
				System.out.println("the option entered is not valid, Try again ");
			}
			else  
				a=1;
		}
		
		return selected;
		
	}
	
	public static int menuEmergency(){
		
		int selected=0;
		int a=0;
		
		System.out.println("\n Please, Choose a option: \n");
		System.out.println("1: Register the veterinary");
		System.out.println("2: Eliminate at veterinary");
		System.out.println("3: Register the pet");
		System.out.println("4: Eliminate at pet");
		System.out.println("5: Create the consult");
		System.out.println("6: End Consultation");
		System.out.println("7: pets that have not yet been attented");
		System.out.println("9: Back to main menu ");
		
		while (a==0){
			
			selected=sc.nextInt();
			sc.nextLine();
		
			if (selected>9 && selected<9&& selected>5){
				System.out.println("the option entered is not valid, Try again ");
			}
			else  
				a=1;
		}
		
		return selected;
		
	}
	public static int menuHabitats(){
		
		int selected=0;
		int a=0;
		
		System.out.println("\n Please, Choose a option: \n");
		System.out.println("1: Creation of the habitats");
		System.out.println("2: Register the pet");
		System.out.println("3: Status of the pet");
		System.out.println("4: Map of status of the pet Daycare");
		System.out.println("5: information of the Habitats");
		System.out.println("6: Statistics of the habitats and pets");
		System.out.println("9: Back to main menu ");
		
		while (a==0){
			
			selected=sc.nextInt();
			sc.nextLine();
		
			if (selected>9 && selected<9&& selected>5){
				System.out.println("the option entered is not valid, Try again ");
			}
			else  
				a=1;
		}
		
		return selected;
		
	}
	
	/**
	* Name: registerVeterinary <br>
	* @author Jhon Lamus <br>
	* The user will be able to enter the veterinarian's details <br>
	* <b> Pre: </b> You must create a class that stores veterinary's data and method that create to the veterinary with the all information <br>
	* <b> Pos: </b> display to the user that the veterinary has been created correctly or that the veterinary has already been entered  <br>
	*/
	
	public static void registerVeterinary(){
		
		System.out.println("Enter the id of the veterinary");
		int id=sc.nextInt();
		
		System.out.println("Enter the name of the veterinary");
		String name=sc.nextLine();
		
		System.out.println("Enter the lastname of the veterinary");
		String lastName=sc.nextLine();
		
		System.out.println("enter the register unique of the veterinary");
		String register=sc.nextLine();
		
		String message= infPetCare.addVeterinary(id,name,lastName,register);
		
		System.out.println(message);
	}
	
	/**
	* Name: EliminateVeterinary <br>
	* @author Jhon Lamus <br>
	* The user will be able to eliminate to the veterinary that the user want <br>
	* <b> Pre: </b> You must create a method that check that not exist registered pets in the center and eliminate to the veterinary  <br>
	* <b> Pos: </b> display to the user that the veterinary has been eliminated correctly or that still exists pets in the center or that the veterinary not exist <br>
	*/
	
	public static void eliminateVeterinary(){
		
		System.out.println("Enter the id of the veterinary that you wish to remove");
		int idVe=sc.nextInt();
		
		String message= infPetCare.eliminateVet(idVe);
		System.out.println(message);
	}
	
	/**
	* Name: registerPet <br>
	* @author Jhon Lamus <br>
	* The user will be able to enter the pet's details and the Owner's details of the pet <br>
	* <b> Pre: </b> You must create a class that stores pet's data and owner's data, and method that create to the pet with the information of the pet and its owner <br>
	* <b> Pos: </b> display to the user that the pet has been created correctly or that can't enter more pets or that already exists a combination between the pet and the owner <br>
	*/
	
	public static void registerPet(){
	
		System.out.println("enter the specie of the pet");
		String specie=sc.nextLine();

		System.out.println("enter the name of the pet");
		String namePet=sc.nextLine();
		
		System.out.println("enter the age of the pet");
		int age=sc.nextInt();
		sc.nextLine();
				
		System.out.println("enter the breed of the pet");
		String breed=sc.nextLine();
		
		System.out.println("enter the symptoms of the pet");
		String symptoms=sc.nextLine();
		
		System.out.println("enter the priority's level of the pet (PRIORITY1,PRIORITY2,PRIORITY3,PRIORITY4,PRIORITY5)");
		String priority=sc.nextLine();
		
		
		System.out.println("enter the id of the pet's owner");
		int idOwner=sc.nextInt();
		
		System.out.println("enter the name of the pet's owner");
		String nameOwner=sc.nextLine();
		
		System.out.println("enter the cellphone of the pet's owner");
		String cellphone=sc.nextLine();
		
		System.out.println("enter the direction of the pet's owner");
		String direction=sc.nextLine();

		
		String message= infPetCare.addPet(specie,namePet,age,breed,symptoms,priority,idOwner,nameOwner,cellphone,direction);
		System.out.println(message);
	}
	
	/**
	* Name: eliminatePet <br>
	* @author Jhon Lamus <br>
	* The user will be able to eliminate to the pet that the user want <br>
	* <b> Pre: </b> You must create a method that check that the pet is on the status Waiting and eliminate the pet <br>
	* <b> Pos: </b> display to the user that the pet has been eliminated correctly or that the pets not found in the status Waiting <br>
	*/

	public static void eliminatePet(){
		
		System.out.println("Enter the name of the pet que desees eliminar");
		String nameP=sc.nextLine();
		
		String message= infPetCare.eliPet(nameP);
		System.out.println(message);
	}
	
	/**
	* Name: consult <br>
	* @author Jhon Lamus <br>
	* The user will be able to create the consult with the veterinary's id <br>
	* <b> Pre: </b> You must create a method that create the consult <br>
	* <b> Pos: </b> display the user different information depending that the exists veterinary,it is available or some pet is available <br> 
	*/
	
	public static void consult(){
		
		System.out.println("Enter the Veterinary's id");
		int idV1=sc.nextInt();
		
		String message = infPetCare.addConsult(idV1);
		System.out.println(message);		
	}
	
	/**
	* Name: endConsult <br>
	* @author Jhon Lamus <br>
	* The user will be able to end consult with the veterinary's id and pet's name <br>
	* <b> Pre: </b> You must create a method that end the consult <br>
	* <b> Pos: </b> display the user different information depending that the exists veterinary or end consult with the pet in the status Hospitalization or not <br> 
	*/
	
	public static void endConsult(){
		
		System.out.println("ingresa el id del veterinario");
		int idv=sc.nextInt();
		
		System.out.println("ingresa el nombre de la mascota");
		String namesPet=sc.nextLine();
		
		System.out.println("Si autoriza la salida de la mascota ponga 1 o por el contrario debe pasar a hospitalizacion escriba 2");
		int num=sc.nextInt();
		sc.nextLine();
		
		String message = infPetCare.endingConsult(idv,namesPet,num);
		System.out.println(message);
	}
	
	/**
	* Name: notAttention <br>
	* @author Jhon Lamus <br>
	* The user will be able to see the pets' number that hasn't been attention <br>
	* <b> Pre: </b> You must create a method that add and send the number of pets that hasn't been attention <br>
	* <b> Pos: </b> display the user a message with the number of pets that hasn't been attention <br> 
	*/
	
	public static void notAttention(){
		
		String message = infPetCare.waitPet();
		
		System.out.println(message);
	}
	
	/**
	* Name: creationHabitat <br>
	* @author Jhon Lamus <br>
	* The user can create habitats with dimensions and an identifier. <br>
	* <b> Pre: </b> You must create a method that create the habitat <br>
	* <b> Pos: </b> display the user different information depending that the exists habitat or no more habitats can be created <br> 
	*/
	
	public static void creationHabitat() {
		
		System.out.println("enter the id of the habitat");
		String id=sc.nextLine();

		System.out.println("enter the large of the habitat");
		double large=sc.nextDouble();
		
		System.out.println("enter the wide of the habitat");
		double wide=sc.nextDouble();
		sc.nextLine();
				
		String message= infPetCare.createHabitat(id,large,wide);
		System.out.println(message);;
		
	}
	
	/**
	* Name: registerDaycarePet <br>
	* @author Jhon Lamus <br>
	* The user will be able to enter the information of the pet he/she wishes to enter the nursery. <br>
	* <b> Pre: </b> You must create a method that to put the pet in its respective habitat. <br>
	* <b> Pos: </b> display the user different information depending that the exists the pet or the space for this pet's habitat is full. <br> 
	*/
	
	public static void registerDaycarePet() {
		
		System.out.println("enter the specie of the pet");
		String specie=sc.nextLine();

		System.out.println("enter the name of the pet");
		String namePet=sc.nextLine();
		
		System.out.println("enter the age of the pet");
		int age=sc.nextInt();
		sc.nextLine();
				
		System.out.println("enter the breed of the pet");
		String breed=sc.nextLine();
		
		System.out.println("enter the id of the pet's owner");
		int idOwner=sc.nextInt();
		
		System.out.println("enter the name of the pet's owner");
		String nameOwner=sc.nextLine();
		
		System.out.println("enter the cellphone of the pet's owner");
		String cellphone=sc.nextLine();
		
		System.out.println("enter the direction of the pet's owner");
		String direction=sc.nextLine();
		
		System.out.println("enter the time that the pet is going to be admitted");
		String time=sc.nextLine();
		
		String message= infPetCare.addDayCare(specie,namePet,age,breed,idOwner,nameOwner,cellphone,direction,time);
		System.out.println(message);
	}
}
