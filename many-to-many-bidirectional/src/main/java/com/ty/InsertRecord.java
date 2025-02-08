package com.ty;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CustomerProduct");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Customer customer1=new Customer();
		customer1.setId(101);
		customer1.setName("ram");
		customer1.setEmail("ram@gmail.com");
		customer1.setPhone(9867543219L);
		
		Customer customer2=new Customer();
		customer2.setId(102);
		customer2.setName("shreya");
		customer2.setEmail("sheray@gmail.com");
		customer2.setPhone(7865432189L);
		
		Product product1=new Product();
		product1.setPid(111);
		product1.setName("TSHIRT");
		product1.setPrice(800);
		
		Product product2=new Product();
		product2.setPid(222);
		product2.setName("Iphone");
		product2.setPrice(150000);
		
		Product product3=new Product();
		product3.setPid(333);
		product3.setName("Laptop");
		product3.setPrice(85000);
		
		customer1.setProducts(Arrays.asList(product1,product3));
		customer2.setProducts(Arrays.asList(product1,product2,product3));
		
		et.begin();
		em.persist(customer1);
		em.persist(customer2);
		et.commit();
		System.out.println("Record Inserted.");
		
	}

}
