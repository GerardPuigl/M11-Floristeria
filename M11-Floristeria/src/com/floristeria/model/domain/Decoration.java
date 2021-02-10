package com.floristeria.model.domain;

public class Decoration extends Producte {

	String name;
	String type;

	public enum Types {
		Fusta, Plastic
	}

	public Decoration(String name, String type, double price) throws Exception {
		super(price);
		this.name = name;
		if (!type.equalsIgnoreCase(Types.Fusta.toString()) &&
			!type.equalsIgnoreCase(Types.Plastic.toString())) {
			throw new Exception("La decoració només pot ser de Fusta o de Plàstic");
		}
		this.type = type;
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
		return "	ID: " + this.getId() + "	NOM: " + name + "	TIPUS: " + type + "	PREU: " + this.getPrice();
	}

}
