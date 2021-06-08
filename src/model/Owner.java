package model;

public class Owner{
	
	private int idOwner;
	private String nameOwner;
	private String cellphone;
	private String direction;
	
	public Owner(int idOwner, String nameOwner, String cellphone, String direction){
		
		this.idOwner=idOwner;
		this.nameOwner=nameOwner;
		this.cellphone=cellphone;
		this.direction=direction;
	}
	
	public int getIdOwner(){
		
		return idOwner;
	}
	
	public String getNameOwner(){
		
		return nameOwner;
	}
	
	public String getCellphone(){
		
		return cellphone;
	}
	
	public String direction(){
		
		return direction;
	}

}