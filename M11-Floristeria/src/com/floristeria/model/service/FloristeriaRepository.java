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
				
		public void addProducte(Producte producte) {
			//if(producte==null) throw new Exception();
			productList.add(producte);
		}

		public void removeProduct(int id) {
			productList.removeIf(p->p.getId()==id);
		}
		
}
