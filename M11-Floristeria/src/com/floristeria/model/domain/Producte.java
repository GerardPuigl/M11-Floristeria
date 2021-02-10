package com.floristeria.model.domain;

public abstract class Producte {

	private int id;
	private static int next_id=0;
	
	private double price;
	
	public Producte(double price) {
		id=next_id++;
		this.price=price;
	}
	
	public double getId() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
