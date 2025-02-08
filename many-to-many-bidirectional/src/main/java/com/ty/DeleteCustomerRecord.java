package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteCustomerRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CustomerProduct");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Customer customer=em.find(Customer.class, 101);
		if(customer!=null) {
			List<Product> products=customer.getProducts();
			if(products	!=null) {
				for(Product product:products) {
					product.getCustomers().remove(customer);
				}
			}
			em.remove(customer);
			System.out.println("Customer record deleted.");
		}else {
			System.out.println("Customer record not found.");
		}
		et.commit();
	}

}
