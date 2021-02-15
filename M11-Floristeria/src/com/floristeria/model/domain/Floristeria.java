package com.floristeria.model.domain;

import java.util.List;
import java.util.stream.Collectors;

import com.floristeria.model.service.FloristeriaRepository;

public class Floristeria {
	
	private int id;
	private static int next_id=0;

	private String name;

	private FloristeriaRepository floristeriaRepository=new FloristeriaRepository();
	
	public Floristeria(String name) throws Exception {
		id = next_id++;
		if (name.isBlank()) throw new Exception("Heu d'introduir un nom per la botiga.");
		this.name = name;
	}
	
	public int getId() {
		return id;
	}	
		
	public String getName() {
		return name;
	}	

	public void addTree(String name, double height, double price) throws Exception {

		Tree tree = new Tree(name, height, price);
		floristeriaRepository.addProducte(tree);
		System.out.println("Arbre afegit correctament.");
	}

	public void addFlower(String name, String color, double price) throws Exception {

		Flower flower = new Flower(name, color, price);
		floristeriaRepository.addProducte(flower);
		System.out.println("Flor afegida correctament.");

	}

	public void addDecoration(String name, String type, double price) throws Exception {

		Decoration decoration = new Decoration(name, type, price);
		floristeriaRepository.addProducte(decoration);
		System.out.println("Decoració afegida correctament.");
	}
	
	public void removeProduct(int id) throws Exception {
		floristeriaRepository.removeProduct(id);
	}
	
	public List<Producte> getAllProducts(){
		return floristeriaRepository.getAllProducts();
	}
	
	//imprimeix tot el stock
	public void printStock() {
	
		//recorre el llistat i caputura una llista dels tipus de Classes que hi ha pressents.
		List<String> productTypes = floristeriaRepository.getAllProducts()
				.stream().map(p->p.getClass().getSimpleName())
				.distinct()
				.collect(Collectors.toList());

		//imprimeix una llista per cada tipus trobat
		productTypes.stream().forEach(s->printStock(s));
	}
	
	//imprimeix una llista d'un producte concret	
	public void printStock(String product) {
		
		//defineix el títol del llistat en funció del producte
		String tipus = "";
		switch (product) {
		case "Tree":
			tipus = "ARBRES";
			break;
		case "Flower":
			tipus = "FLORS";
			break;
		case "Decoration":
			tipus = "DECORACIONS";
			break;
		}

		//imprimeix el llistat
		System.out.println("TOTAL " + tipus + ": ");
		floristeriaRepository.getAllProducts().stream()
			.filter(p->p.getClass().getSimpleName().equals(product))
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
			.mapToDouble(Producte::getPrice)
			.sum());
	}
}
