package com.floristeria.controller;

import com.floristeria.model.domain.Floristeria;

public class FloristeriaController {

	public Floristeria createFloristeria(String nomFloristeria) {
		
		Floristeria floristeria = null;
		try {
			floristeria = new Floristeria(nomFloristeria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return floristeria;
	}
	
	public void treeAdd(Floristeria floristeria, String name, double height, double price) {
		
		try {
			floristeria.addTree(name, height, price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void flowerAdd(Floristeria floristeria, String name, String color, double price) {
		
		try {
			floristeria.addFlower(name, color, price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void decorationAdd(Floristeria floristeria, String name, String type, double price) {
		
		try {
			floristeria.addDecoration(name, type, price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
