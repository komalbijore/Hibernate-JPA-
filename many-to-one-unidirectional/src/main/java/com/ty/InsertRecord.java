package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ReviewProduct");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		Product product=new Product();
		product.setPid(101);
		product.setName("TSHIRT");
		product.setPrice(800);
		
		Review review1=new Review();
		review1.setId(111);
		review1.setReview("Veryt good");	
		review1.setProduct(product);
		
		Review review2=new Review();
		review2.setId(222);
		review2.setReview("Best Quality.");
		review2.setProduct(product);
		
		et.begin();
		em.persist(review1);
		em.persist(product);
		em.persist(review2);
		et.commit();
		System.out.println("Record inserted");
	}

}
