package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersonAadhaar");
		EntityManager em=emf.createEntityManager();
		
		AadhaarCard aadhaar=em.find(AadhaarCard.class, 676786787899L);
		if(aadhaar!=null) {
			Person person=aadhaar.getPerson();
			System.out.println("--------Person details ----------");
			System.out.println(person.getName());
			System.out.println(person.getEmail());
			System.out.println(person.getPhone());
			
			System.out.println("------- Aadhaar  details --------");
			System.out.println(aadhaar.getAadhaarNo());
			System.out.println(aadhaar.getIssueDate());
		}
		else {
			System.out.println("Invalid aadhaar Card Number");
		}
	}

}
