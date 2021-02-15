package com.floristeria.model.domain;

import java.text.Collator;

public class Decoration extends Producte {

	private String name;
	private String type;
	private Collator comparador= Collator.getInstance();
	
	public Decoration(String name, String type, double price) throws Exception {
		super(price);
		if (name.isBlank()) throw new Exception("Heu d'introduir un nom per la botiga.");
		this.name = name;
		
		comparador.setStrength(Collator.PRIMARY);
		
		if (!comparador.equals(type,"Plàstic") &&
			!comparador.equals(type, "Fusta")) {
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
