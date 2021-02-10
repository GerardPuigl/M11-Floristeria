package com.floristeria.model.domain;


public class Decoration extends Producte {

	int id;
	String name;
	String type;
	double price;
	
	public enum Types {
		Fusta,Plastic
	}

	public Decoration(int id, String name, String type, double price) throws Exception {
		super();
		this.id = id;
		this.name = name;
		if(	type.equalsIgnoreCase(Types.Fusta.toString())||
			type.equalsIgnoreCase(Types.Plastic.toString())){
			this.type = type;
		}else {
			throw new Exception("La decoració només pot ser de Fusta o de Plàstic");
		} 
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "	NOM: " + name + "	TIPUS: " + type + "	PREU: " + price ;
		
	}

}

