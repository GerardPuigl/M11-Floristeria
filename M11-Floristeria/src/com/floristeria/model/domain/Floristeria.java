package com.floristeria.model.domain;

import java.util.List;

import com.floristeria.model.service.FloristeriaRepository;

public class Floristeria {
	
	private int id;
	private static int next_id=0;

	private String name;

	//private List<Producte> productList = new ArrayList<>();

	private FloristeriaRepository floristeriaRepository=new FloristeriaRepository();
	
	public Floristeria(String name) throws Exception {
		id = next_id++;
		if (name.isBlank()) {
			throw new Exception("Heu d'introduir un nom per la botiga.");
		}
		this.name = name;
	}
	
	public int getId() {
		return id;
	}	
		
	public String getName() {
		return name;
	}	

	public void addTree(String name, double height, double price) {

		Tree tree = new Tree(name, height, price);
		//productList.add(tree);
		floristeriaRepository.addProducte(tree);
		System.out.println("Arbre afegit correctament.");

	}

	public void addFlower(String name, String color, double price) {

		Flower flower = new Flower(name, color, price);
		//productList.add(flower);
		floristeriaRepository.addProducte(flower);
		System.out.println("Flor afegida correctament.");

	}

	public void addDecoration(String name, String type, double price) throws Exception {

		Decoration decoration = new Decoration(name, type, price);
		//productList.add(decoration);
		floristeriaRepository.addProducte(decoration);
		System.out.println("Decoració afegida correctament.");

	}
	
	public void removeProduct(int id) {
		//productList.removeIf(p->p.getId()==id);
		floristeriaRepository.removeProduct(id);
	}
	
	public void printStock() {
		
		List<Producte> productList = floristeriaRepository.getAllProducts();
		
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
	public void stockQuantities() {
		
		List<Producte> productList = floristeriaRepository.getAllProducts();
		
		System.out.println("TOTAL ARBRES: "+
			
		productList.stream()
			.filter(p->p.getClass().getSimpleName().equals("Tree"))
			.count());
		
		System.out.println("TOTAL FLORS: "+ 
		
		productList.stream()
			.filter(p->p.getClass().getSimpleName().equals("Flower"))
			.count());
		
		System.out.println("TOTAL DECORACIONS: "+
		
		productList.stream()
			.filter(p->p.getClass().getSimpleName().equals("Decoration"))
			.count());
	}
	
	public void totalStockValue() {
		
		System.out.println("VALOR TOTAL DEL STOCK: "+
		
		floristeriaRepository.getAllProducts().stream()
			.mapToDouble(p->p.getPrice())
			.sum());
	}
}
