package com.floristeria.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Floristeria {

	private String name;
	
	private int producte_id=0;
	
	private List<Producte> productList = new ArrayList<>();
	
	public Floristeria(String name) {
		this.name = name;
	}

	public void addTree(String name, double height, double price) {
		
		Tree tree = new Tree(producte_id++, name, height, price);
		productList.add(tree);
		System.out.println("Arbre afegit correctament.");

	}

	public void addFlower(String name, String color, double price) {

		Flower flower = new Flower(producte_id++, name, color, price);
		productList.add(flower);
		System.out.println("Flor afegida correctament.");

	}

	public void addDecoration(String name, String type, double price) {

		try {
			Decoration decoration = new Decoration(producte_id++, name, type, price);
			productList.add(decoration);
			System.out.println("Decoració afegida correctament.");

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
		
		System.out.println("DECORACIONS“:");
		
		productList.stream()
			.filter(p->p.getClass().getSimpleName().equals("Decoration"))
			.forEach(p->System.out.println(p.toString()));
		
	}


}
