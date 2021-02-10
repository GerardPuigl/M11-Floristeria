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
		
		Floristeria floristeria = floristeriaCreate();		
		
		// Menú de l'aplicació
		boolean exit = false;
		int option;
		
		do {			
			try {
				option = Integer.parseInt(ask("Menú", "Tria una opció:"
														+ "\n1. Afegir producte"
														+ "\n2. Retirar producte"
														+ "\n3. Veure stock dels productes"
														+ "\n4. Veure el valor total dels productes"
														+ "\n5. Sortir"));
			}catch(Exception e){
				System.err.println("La resposta ha de ser un número");
				option = 0;
				exit = false;
			}

			if(option == 1) {
				menuAdd(floristeria);
				exit = false;
			}else if(option == 2) {
				menuRemove(floristeria);
				exit = false;
			}else if(option == 3) {
				menuStock(floristeria);
				exit = false;
			}else if(option == 4) {
					
				exit = false;
			}else if(option == 5) {
					
				exit = true;
			}else if(option == JOptionPane.CANCEL_OPTION) {
				exit = true;
			}
			
		}while(!exit);
	}
	
	private void menuAdd(Floristeria floristeria) {
		
		boolean exit = false;
		int option;
		
		do {			
			try {
				option = Integer.parseInt(ask("Menú", "Tria una opció:"
														+ "\n1. Afegir arbre"
														+ "\n2. Afegir flor"
														+ "\n3. Afegir decoració"
														+ "\n4. Sortir"));
			}catch(Exception e){
				System.err.println("La resposta ha de ser un número");
				option = 0;
				exit = false;
			}
			
			if(option == 1) {
				askTreeAdd(floristeria);
				exit = false;
			}else if(option == 2) {
				askFlowerAdd(floristeria);
				exit = false;
			}else if(option == 3) {
				askDecorationAdd(floristeria);
				exit = false;
			}else if(option == 4) {
				exit = true;
			}else if(option == JOptionPane.CANCEL_OPTION) {
				exit = true;
			}
		}while(!exit);
	}
	
	private void menuRemove(Floristeria floristeria) {

		boolean exit = false;
		int option;
		
		do {			
			try {
				option = Integer.parseInt(ask("Menú", "Tria una opció:"
														+ "\n1. Retirar arbre"
														+ "\n2. Retirar flor"
														+ "\n3. Retirar decoració"
														+ "\n4. Sortir"));
			}catch(Exception e){
				System.err.println("La resposta ha de ser un número");
				option = 0;
				exit = false;
			}
			
			if(option == 1) {
				floristeriaController.getProductStock(floristeria, "Tree");
				askProductRemove(floristeria);
				exit = false;
			}else if(option == 2) {
				floristeriaController.getProductStock(floristeria, "Flower");
				askProductRemove(floristeria);
				exit = false;
			}else if(option == 3) {
				floristeriaController.getProductStock(floristeria, "Decoration");
				askProductRemove(floristeria);
				exit = false;
			}else if(option == 4) {
				exit = true;
			}else if(option == JOptionPane.CANCEL_OPTION) {
				exit = true;
			}
		}while(!exit);
	}
	
	private void menuStock(Floristeria floristeria) {

		boolean exit = false;
		int option;
		
		do {			
			try {
				option = Integer.parseInt(ask("Menú", "Tria una opció:"
														+ "\n1. Veure stock d'arbres"
														+ "\n2. Veure stock de flors"
														+ "\n3. Veure stock de decoració"
														+ "\n4. Veure stock de tots els productes"
														+ "\n5. Sortir"));
			}catch(Exception e){
				System.err.println("La resposta ha de ser un número");
				option = 0;
				exit = false;
			}
			
			if(option == 1) {
				floristeriaController.getProductStock(floristeria, "Tree");
				exit = false;
			}else if(option == 2) {
				floristeriaController.getProductStock(floristeria, "Flower");
				exit = false;
			}else if(option == 3) {
				floristeriaController.getProductStock(floristeria, "Decoration");
				exit = false;
			}else if(option == 4) {
				floristeriaController.getAllProductsStock(floristeria);
				exit = false;
			}else if(option == 5) {
				exit = true;
			}else if(option == JOptionPane.CANCEL_OPTION) {
				exit = true;
			}
		}while(!exit);
	}
	
	private Floristeria floristeriaCreate() {
		
		Floristeria floristeria = null;
		
		try {			
			String nomFloristeria = ask("Nom floristeria", "Introdueix el nom de la floristeria");
			
			floristeria = floristeriaController.createFloristeria(nomFloristeria);
			
		}catch(Exception e) {
			System.err.println("No s'ha pogut crear la floristeria");
		}
		return floristeria;
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
			String decorationName = ask("Nom Decoració", "Introdueix el nom de la decoració");
			String decorationType = ask("Tipus Decoració", "Introdueix el tipus de decoració");
			double decorationPrice = Double.parseDouble(ask("Preu Decoració", "Introdueix el preu de la decoració"));
			
			floristeriaController.decorationAdd(floristeria, decorationName, decorationType, decorationPrice);
		}catch(Exception e) {
			System.err.println("No s'ha pogut afegir la decoració");
		}
	}
	
	private void askProductRemove(Floristeria floristeria) {
		try {
			int productId = Integer.parseInt(ask("ID Producte", "Introdueix l'ID del producte a eliminar"));
			
			floristeriaController.productRemove(floristeria, productId);
		}catch(Exception e) {
			System.err.println("No s'ha pogut retirar el producte");
		}
	}
	
	
	private String ask(String title, String question) {
		String response = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);
		return response;
	}

}
