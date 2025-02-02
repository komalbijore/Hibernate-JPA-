package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteRecord {
	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ReviewProduct");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Review review=em.find(Review.class, 111);
		if(review!=null) {
			em.remove(review);
			System.out.println("Review deleted.");
		}else {
			System.out.println("Review not found");
		}
		et.commit();
	}
}
