package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchProductRecord {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CustomerProduct");
		EntityManager em=emf.createEntityManager();
		
		Product product=em.find(Product.class, 111);
		if(product!=null) {
			System.out.println("----- Product Details-------");
			System.out.println(product.getPid());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			
			List<Customer> customers=product.getCustomers();
			
			System.out.println("-------- Customer Details --------");
			if(customers!=null && !customers.isEmpty()) {
				for(Customer customer:customers) {
					System.out.println(customer.getId());
					System.out.println(customer.getName());
					System.out.println(customer.getEmail());
					System.out.println(customer.getPhone());
					System.out.println("==================================");
					
				}
			}else {
				System.out.println("Customer record not found.");
			}
		}else {
			System.out.println("Product record not found.");
		}
		
	}

}
