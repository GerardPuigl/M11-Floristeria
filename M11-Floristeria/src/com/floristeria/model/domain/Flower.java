package com.floristeria.model.domain;

public class Flower extends Producte {

	String name;
	String color;

	public Flower(String name, String color, double price) throws Exception {
		super(price);
		if (name.isBlank()) throw new Exception("Heu d'introduir un nom de la flor.");
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "	ID: " + this.getId() + "	NOM: " + name + "	COLOR: " + color + "	PREU: " + this.getPrice();
	}
}
