package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ReviewProduct");
		EntityManager em=emf.createEntityManager();
		
		Review review=em.find(Review.class, 1111);
		if(review!=null) {
			System.out.println("-------Review details -----");
			System.out.println(review.getId());
			System.out.println(review.getReview());
			
			Product product=review.getProduct();
			if(product!=null) {
				System.out.println("------- product details --------");
				System.out.println(product.getPid());
				System.out.println(product.getName());
				System.out.println(product.getPrice());
				
			}else {
				System.out.println("Product Not found.");
			}
		}else {
			System.out.println("Review not found.");
		}
		
		
	}

}
