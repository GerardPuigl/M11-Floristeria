package com.floristeria.model.domain;

public class Flower extends Producte  {

	int id;
	String name;
	String color;
	double price;
	
	public Flower(int id, String name, String color, double price) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "	NOM: " + name + "	COLOR: " + color + "	PREU: " + price ;
		
	}
}
