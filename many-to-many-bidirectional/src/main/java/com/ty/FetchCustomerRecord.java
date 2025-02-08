package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchCustomerRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CustomerProduct");
		EntityManager em=emf.createEntityManager();
		
		Customer customer=em.find(Customer.class, 101);
		if(customer!=null) {
			System.out.println("--------- Customer Details -----------");
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
			System.out.println(customer.getPhone());
			
			List<Product> products=customer.getProducts();
			
			if(products !=null && !products.isEmpty() ) {
				for(Product product:products) {
					System.out.println(product.getPid());
					System.out.println(product.getName());
					System.out.println(product.getPrice());
					System.out.println("=========================");
				}
			}else {
				System.out.println("Product record not found.");
			}

		}else {
			System.out.println("Customer record not found.");
		}
	}

}
