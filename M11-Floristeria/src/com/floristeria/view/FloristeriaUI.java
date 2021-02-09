package com.floristeria.view;

import javax.swing.JOptionPane;

import com.floristeria.controller.FloristeriaController;
import com.floristeria.model.domain.Floristeria;

public class FloristeriaUI {

	private FloristeriaController floristeriaController = null;
	
	public FloristeriaUI() {
		floristeriaController = new FloristeriaController();
	}

	public void menu() {
		
		// Demanem les dades de l'periodista amb el que treballarem
		Floristeria floristeria = floristeriaCreate();

		//if (floristeria != null) {
		
		
		// Men� de l'aplicaci�
		boolean exit;
		int option;
		
		do {			
			try {
				// Comprovar que la resposta �s int
				option = Integer.parseInt(ask("Men�", "Tria una opci�:"
															+ "\n1. Afegir arbre"
															+ "\n2. Afegir flor"
															+ "\n3. Afegir decoraci�"
															+ "\n4. Veure stock"
															+ "\n5. Sortir"));
			} catch (NumberFormatException e){
				option = 0;
				exit = true;
			}
				
			switch(option) {
			case 1:
				askTreeAdd(floristeria);
				exit = false;
				break;
			case 2:
				askFlowerAdd(floristeria);
				exit = false;
				break;
			case 3:
				askDecorationAdd(floristeria);
				exit = false;
				break;
			case 4:
				floristeria.printStock();
				exit = false;
				break;
			case 5:
				// Sortir del men�
				System.out.println("Sortir del programa");
				exit = false;
				break;
			default:
				// Tornar al men�
				System.out.println("\nLa resposta no �s v�lida. Torna-ho a provar.");
				exit = true;
				break;
			}
		}while(exit);
	}
	
	private Floristeria floristeriaCreate() {
		
		Floristeria floristeria = null;
		
		try {			
			String nomFloristeria = ask("Nom floristeria", "Introdueix el nom de la floristeria");
			
			floristeria floristeriaController.createFloristeria(nomFloristeria);
			
		}catch(Exception e) {
			System.err.println("No s'ha pogut crear la floristeria");
		}
	}
	
	private void askTreeAdd(Floristeria floristeria) {
		try {
			String treeName = ask("Nom Arbre", "Introduiex el nom de l'arbre");
			double treeHeight = Double.parseDouble(ask("Altura Arbre", "Introdueix l'altura de l'arbre"));
			double treePrice = Double.parseDouble(ask("Preu Arbre", "Introdueix el preu de l'arbre"));
			
			floristeriaController.treeAdd(floristeria, treeName, treeHeight, treePrice);
		}catch(Exception e) {
			System.err.println("No s'ha pogut afegir l'arbre");
		}
	}
	
	private void askFlowerAdd(Floristeria floristeria) {
		try {
			String flowerName = ask("Nom Flor", "Introdueix el nom de la flor");
			String flowerColor = ask("Color Flor", "Introdueix el color de la flor");
			double flowerPrice = Double.parseDouble(ask("Preu Flor", "Introdueix el preu de la flor"));
			
			floristeriaController.flowerAdd(floristeria, flowerName, flowerColor, flowerPrice);
		}catch(Exception e) {
			System.err.println("No s'ha pogut afegir la flor");
		}
	}
	
	private void askDecorationAdd(Floristeria floristeria) {
		try {
			String decorationName = ask("Nom Decoraci�", "Introdueix el nom de la decoraci�");
			String decorationType = ask("Tipus Decoraci�", "Introdueix el tipus de decoraci�");
			double decorationPrice = Double.parseDouble(ask("Preu Decoraci�", "Introdueix el preu de la decoraci�"));
			
			floristeriaController.decorationAdd(floristeria, decorationName, decorationType, decorationPrice);
		}catch(Exception e) {
			System.err.println("No s'ha pogut afegir la decoraci�");
		}
	}
	
	
	private String ask(String title, String question) {
		String response = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);
		return response;
	}

}
