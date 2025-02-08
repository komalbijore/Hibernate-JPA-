package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteProductRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CustomerProduct");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		
		Product product=em.find(Product.class, 111);
		if(product!=null) {
			List<Customer> customers=product.getCustomers();
			if(customers!=null ) {
				for(Customer customer:customers) {
					customer.getProducts().remove(product);
				}
			}
			em.remove(product);
			et.commit();
			System.out.println("product record is deleted.");
		}else {
			System.out.println("product record not found");
		}
	}

}
