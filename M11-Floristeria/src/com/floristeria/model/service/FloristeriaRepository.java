package com.floristeria.model.service;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.model.domain.Producte;

public class FloristeriaRepository {
	
		private List<Producte> productList = new ArrayList<>();

		public FloristeriaRepository(){
		}
		
		public List<Producte> getAllProducts(){
			return productList;
		}
				
		public void addProducte(Producte producte) throws Exception {
			if(producte==null) throw new Exception();
			productList.add(producte);
		}

		public void removeProduct(int id) throws Exception {
			if (productList.stream().anyMatch(p -> p.getId() == id)) {
				productList.removeIf(p -> p.getId() == id);
			} else {
				throw new Exception("No s'ha trobat cap producte amb aquest id.");
			}
			
		}
		
}
