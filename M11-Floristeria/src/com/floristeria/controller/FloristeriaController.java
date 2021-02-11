package com.floristeria.controller;

import com.floristeria.model.domain.Floristeria;

public class FloristeriaController {

	public Floristeria createFloristeria(String nomFloristeria) throws Exception {
		Floristeria floristeria = new Floristeria(nomFloristeria);
		return floristeria;
	}
	
	public void treeAdd(Floristeria floristeria, String name, double height, double price) throws Exception {
		floristeria.addTree(name, height, price);
	}
	
	public void flowerAdd(Floristeria floristeria, String name, String color, double price) throws Exception {
		floristeria.addFlower(name, color, price);
	}
	
	public void decorationAdd(Floristeria floristeria, String name, String type, double price) throws Exception {
		floristeria.addDecoration(name, type, price);
	}
	
	public void productRemove(Floristeria floristeria, int id) throws Exception {
		floristeria.removeProduct(id);
	}
	
	public void getProductStock(Floristeria floristeria, String product) {
		floristeria.printStock(product);
	}
	
	public void getAllProductsStock(Floristeria floristeria) {
		floristeria.printStock();
	}
	
	public void getStockValue(Floristeria floristeria) {
		floristeria.totalStockValue();
	}
}
