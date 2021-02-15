package com.floristeria.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.floristeria.model.domain.Floristeria;
import com.floristeria.model.domain.Producte;
import com.floristeria.model.domain.Ticket;
import com.floristeria.model.service.TicketRepository;

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
	
	public void createTicket(Floristeria floristeria, List<Integer> idsTicket) throws Exception {
		
		List<Producte> productesTicket  = floristeria.getAllProducts().stream()
				.filter(prod -> idsTicket.stream()
						.anyMatch(id -> prod.getId() == id))
				.collect(Collectors.toList());
		
		Ticket ticket = new Ticket(productesTicket);
		ticketRepository.addTicket(ticket);
		ticket.printTicket();
		
		idsTicket.stream().forEach(id -> {
			try {
				floristeria.removeProduct(id);
			} catch (Exception e) {
				System.err.println("No s'ha pogut retirar el producte");
				System.err.println(e.getMessage());
			}
		});
	}
	
	public void printAllTickets() {
		ticketRepository.getAllTickets().stream()
			.forEach(tic -> tic.printTicket());
	}
	
	public void getAllTicketsValue() {
		
		System.out.println("VALOR TOTAL DE VENTES REALITZADES: "+
				
		ticketRepository.getAllTickets().stream()
			.mapToDouble(Ticket::getTotalValue)
			.sum());
		
	}
	
	public boolean checkId(Floristeria floristeria, int id) {
		List<Integer> productesIds = floristeria.getAllProducts().stream()
				.map(Producte::getId)
				.collect(Collectors.toList());
		if(productesIds.contains(id)) {
			return true;
		}else {
			return false;
		}
	}
}
