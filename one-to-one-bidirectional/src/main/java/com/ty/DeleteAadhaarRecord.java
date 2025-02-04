package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteAadhaarRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersonAadhaar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		AadhaarCard aadhaar=em.find(AadhaarCard.class, 676786787899L) ;
		if(aadhaar!=null) {
			em.remove(aadhaar);
			System.out.println("Aadhaar record deleted");
		}else {
			System.out.println("Invalid aadhaar number.");
		}
		et.commit();
		em.close();
	}

}
