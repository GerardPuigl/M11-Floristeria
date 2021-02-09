package com.floristeria.model.domain;

public class Tree extends Producte {

	int id;
	String name;
	double hight;
	double price;

	public Tree(int id, String name, double hight, double price) {
		super();
		this.id = id;
		this.name = name;
		this.hight = hight;
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
	public double getHight() {
		return hight;
	}
	public void setHight(double hight) {
		this.hight = hight;
	}
	
	@Override
	public String toString() {
		return "	NOM: " + name + "	ALÇADA: " + hight + "	PREU: " + price ;
		
	}

}
