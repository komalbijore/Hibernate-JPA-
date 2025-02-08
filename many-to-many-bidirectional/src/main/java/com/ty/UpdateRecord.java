package com.ty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CustomerProduct");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Customer customer=em.find(Customer.class, 101);
		if(customer!=null) {
			customer.setEmail("sara@gmail.com");
			List<Product> products = new ArrayList<>(customer.getProducts());
			 Product product = em.find(Product.class, 1111);
	        if (product == null) {  	
			product=new Product();
			product.setPid(1111);
			product.setName("Headphone");
			product.setPrice(5000);
			em.persist(product);
	        }
			products.add(product);
			customer.setProducts(products);
			em.merge(customer);
			System.out.println("Record updated.");
			et.commit();
		}else {
			System.out.println("Customer record not found.");
		}
	}

}
