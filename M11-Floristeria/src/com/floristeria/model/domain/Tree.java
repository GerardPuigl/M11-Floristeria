package com.floristeria.model.domain;

public class Tree extends Producte {

	private String name;
	private double hight;

	public Tree(String name, double hight, double price) throws Exception {
		super(price);
		if (name.isBlank()) throw new Exception("Heu d'introduir un nom de l'arbre.");
		this.name = name;
		this.hight = hight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	@Override
	public String toString() {
		return "	ID: " + this.getId() + "	NOM: " + name + "	ALǇADA: " + hight + "	PREU: " + this.getPrice();

	}

}
