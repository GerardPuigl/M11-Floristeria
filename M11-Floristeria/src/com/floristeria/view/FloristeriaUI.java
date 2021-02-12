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
		// Crear floristeria
		Floristeria floristeria;
		do {
		floristeria = floristeriaCreate();
		}while(floristeria == null);
		
		// Menú de l'aplicació
		boolean exit = false;
		
		do {
			String option = ask("Menú", "Tria una opció:"
														+ "\n1. Afegir producte"
														+ "\n2. Retirar producte"
														+ "\n3. Gestió de productes"
														+ "\n4. Gestió de compres"
														+ "\n5. Sortir");

			if(option == null) {
				exit = true;
			}else if(option.equals("1")) {
				menuAdd(floristeria);
				exit = false;
			}else if(option.equals("2")) {
				menuRemove(floristeria);
				exit = false;
			}else if(option.equals("3")) {
				menuStock(floristeria);
				exit = false;
			}else if(option.equals("4")) {
				
				exit = false;
			}else if(option.equals("5")) {
				exit = true;
			}
			
		}while(!exit);
		System.out.println("Final de l'aplicació");
	}
	// Menú per afegir un producte
	private void menuAdd(Floristeria floristeria) {
		
		boolean exit = false;
		
		do {
			String option = ask("Menú", "Tria una opció:"
														+ "\n1. Afegir arbre"
														+ "\n2. Afegir flor"
														+ "\n3. Afegir decoració"
														+ "\n4. Sortir");
			if(option == null) {
				exit = true;
			}else if(option.equals("1")) {
				askTreeAdd(floristeria);
				exit = false;
			}else if(option.equals("2")) {
				askFlowerAdd(floristeria);
				exit = false;
			}else if(option.equals("3")) {
				askDecorationAdd(floristeria);
				exit = false;
			}else if(option.equals("4")) {
				exit = true;
			}
		}while(!exit);
	}
	// Menú per retirar un producte
	private void menuRemove(Floristeria floristeria) {

		boolean exit = false;
		
		do {			
			String option = ask("Menú", "Tria una opció:"
														+ "\n1. Retirar arbre"
														+ "\n2. Retirar flor"
														+ "\n3. Retirar decoració"
														+ "\n4. Sortir");
			
			if(option == null) {
				exit = true;
			}else if(option.equals("1")) {
				floristeriaController.getProductStock(floristeria, "Tree");
				askProductRemove(floristeria);
				exit = false;
			}else if(option.equals("2")) {
				floristeriaController.getProductStock(floristeria, "Flower");
				askProductRemove(floristeria);
				exit = false;
			}else if(option.equals("3")) {
				floristeriaController.getProductStock(floristeria, "Decoration");
				askProductRemove(floristeria);
				exit = false;
			}else if(option.equals("4")) {
				exit = true;
			}
		}while(!exit);
	}
	// Menú per veure l'stock i valor dels productes
	private void menuStock(Floristeria floristeria) {

		boolean exit = false;
		
		do {			
			String option = ask("Menú", "Tria una opció:"
														+ "\n1. Veure stock d'arbres"
														+ "\n2. Veure stock de flors"
														+ "\n3. Veure stock de decoració"
														+ "\n4. Veure stock de tots els productes"
														+ "\n5. Veure el valor de tots els productes"
														+ "\n6. Sortir");
			
			if(option == null) {
				exit = true;
			}else if(option.equals("1")) {
				floristeriaController.getProductStock(floristeria, "Tree");
				exit = false;
			}else if(option.equals("2")) {
				floristeriaController.getProductStock(floristeria, "Flower");
				exit = false;
			}else if(option.equals("3")) {
				floristeriaController.getProductStock(floristeria, "Decoration");
				exit = false;
			}else if(option.equals("4")) {
				floristeriaController.getAllProductsStock(floristeria);
				exit = false;
			}else if(option.equals("5")) {
				floristeriaController.getStockValue(floristeria);
				exit = false;
			}else if(option.equals("6")) {
				exit = true;
			}
		}while(!exit);
	}
	// Menú per crear i veure tickets 
	private void menuTicket(Floristeria floristeria) {
		
		boolean exit = false;
		
		do {
			String option = ask("Menú", "Tria una opció:"
														+ "\n1. Crear un nou ticket de compra"
														+ "\n2. Veure els tickets de compra antics"
														+ "\n3. Veure el valor de les ventes realitzades"
														+ "\n4. Sortir");
			
			if(option == null) {
				exit = true;
			}else if(option.equals("1")) {
				
				exit = false;
			}else if(option.equals("2")) {
				
				exit = false;
			}else if(option.equals("3")) {
				
				exit = false;
			}else if(option.equals("4")) {
				exit = true;
			}
		}while(!exit);
	}
	// Crear floristeria
	private Floristeria floristeriaCreate() {
		
		Floristeria floristeria = null;
		
		try {			
			String nomFloristeria = ask("Nom floristeria", "Introdueix el nom de la floristeria");
			
			if(nomFloristeria == null ){
                System.exit(0);
            }else{
    			floristeria = floristeriaController.createFloristeria(nomFloristeria);
            }
			
		}catch(Exception e) {
			System.err.println("No s'ha pogut crear la floristeria");
			System.err.println(e.getMessage());
		}
		return floristeria;
	}
	// Afegir arbre
	private void askTreeAdd(Floristeria floristeria) {
		try {
			String treeName = ask("Nom Arbre", "Introduiex el nom de l'arbre");
			double treeHeight = Double.parseDouble(ask("Altura Arbre", "Introdueix l'altura de l'arbre"));
			double treePrice = Double.parseDouble(ask("Preu Arbre", "Introdueix el preu de l'arbre"));
			
			floristeriaController.treeAdd(floristeria, treeName, treeHeight, treePrice);
		}catch(NullPointerException npe) {
			return;
		}catch(NumberFormatException nfe) {
			System.err.println("No s'ha pogut afegir l'arbre");
			System.err.println("S'ha introduït una paraula enlloc d'un número");
		}
		catch(Exception e) {
			System.err.println("No s'ha pogut afegir l'arbre");
			System.err.println(e.getMessage());
		}
	}
	// Afegir flor
	private void askFlowerAdd(Floristeria floristeria) {
		try {
			String flowerName = ask("Nom Flor", "Introdueix el nom de la flor");
			String flowerColor = ask("Color Flor", "Introdueix el color de la flor");
			double flowerPrice = Double.parseDouble(ask("Preu Flor", "Introdueix el preu de la flor"));
			
			floristeriaController.flowerAdd(floristeria, flowerName, flowerColor, flowerPrice);
		}catch(NullPointerException npe) {
			return;
		}catch(NumberFormatException nfe) {
			System.err.println("No s'ha pogut afegir la flor");
			System.err.println("S'ha introduït una paraula enlloc d'un número");
		}
		catch(Exception e) {
			System.err.println("No s'ha pogut afegir la flor");
			System.err.println(e.getMessage());
		}
	}
	// Afegir decoració
	private void askDecorationAdd(Floristeria floristeria) {
		try {
			String decorationName = ask("Nom Decoració", "Introdueix el nom de la decoració");
			String decorationType = ask("Tipus Decoració", "Introdueix el tipus de decoració (fusta o plastic)");
			double decorationPrice = Double.parseDouble(ask("Preu Decoració", "Introdueix el preu de la decoració"));
			
			floristeriaController.decorationAdd(floristeria, decorationName, decorationType, decorationPrice);
		}catch(NullPointerException npe) {
			return;
		}catch(NumberFormatException nfe) {
			System.err.println("No s'ha pogut afegir la decoració");
			System.err.println("S'ha introduït una paraula enlloc d'un número");
		}
		catch(Exception e) {
			System.err.println("No s'ha pogut afegir la decoració");
			System.err.println(e.getMessage());
		}
	}
	// Retirar producte
	private void askProductRemove(Floristeria floristeria) {
		try {
			int productId = Integer.parseInt(ask("ID Producte", "Introdueix l'ID del producte a eliminar"));
			
			floristeriaController.productRemove(floristeria, productId);
		}catch(NullPointerException npe) {
			return;
		}catch(NumberFormatException nfe) {
			System.err.println("No s'ha pogut retirar el producte");
			System.err.println("S'ha introduït una paraula enlloc d'un número");
		}catch(Exception e) {
			System.err.println("No s'ha pogut retirar el producte");
			System.err.println(e.getMessage());
		}
	}
	// Preguntar a l'usuari
	private String ask(String title, String question) {
        String response;
        do {
            response = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);
            if (response == null) return null;
            if (response.isBlank()) System.err.println("No podeu deixar aquest camp en blanc.");
        } while (response.isBlank());
        return response;
	}

}
