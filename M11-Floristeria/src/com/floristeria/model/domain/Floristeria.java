package com.floristeria.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Floristeria {

	List<Producte> productList = new ArrayList<>();

	public void addTree(int id, String name, double height, double price) {

		Tree tree = new Tree(id, name, height, price);
		productList.add(tree);

	}

	public void addFlower(int id, String name, String color, double price) {

			Flower flower = new Flower(id, name, color, price);
			productList.add(flower);

	}

	public void addDecoration(int id, String name, String type, double price) {

		try {
			Decoration decoration = new Decoration(id, name, type, price);
			productList.add(decoration);

		} catch (Exception e) {
			System.out.println(e.getMessage() + "\nDecoració no afegida.");
		}

	}
	
	public void printStock() {
		
		System.out.println("ARBRES:");
		
		productList.stream()
		.filter(p->p.getClass().getSimpleName().equals("Tree"))
		.forEach(p->System.out.println(p.toString()));
		
		System.out.println("FLORS:");
		productList.stream()
		
		.filter(p->p.getClass().getSimpleName().equals("Flower"))
		.forEach(p->System.out.println(p.toString()));
		System.out.println("DECORACIÓ:");
		
		productList.stream()
		.filter(p->p.getClass().getSimpleName().equals("Decoration"))
		.forEach(p->System.out.println(p.toString()));
		
	}

}
