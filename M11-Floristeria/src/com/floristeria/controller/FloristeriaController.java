package com.floristeria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.floristeria.model.domain.Floristeria;
import com.floristeria.model.domain.Producte;

public class FloristeriaController {

	private TicketRepository ticketRepository = new TicketRepository();
	
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
	
	public void createTicket(Floristeria floristeria, List<Integer> idsTicket) {
		
		List<Producte> productesTicket  = floristeria.getAllProducts().stream()
				.filter(prod -> idsTicket.stream()
						.anyMatch(id -> prod.getId().equals(id)))
				.collect(Collectors.toList());
		
		Ticket ticket = new Ticket(List<Producte> productesTicket);
		ticketRepository.add(ticket);
		
		idsTicket.stream().forEach(id -> floristeria.removeProduct(id));
	}
	
}
