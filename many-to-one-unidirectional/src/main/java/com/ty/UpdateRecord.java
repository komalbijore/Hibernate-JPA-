package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ReviewProduct");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Review review=em.find(Review.class, 1111);
		if(review!=null) {
			review.setReview("Product quality is not good.");
			em.merge(review);
			System.out.println("Review updated.");
		}else {
			System.out.println("Review not found");
		}
		et.commit();
	}
}
