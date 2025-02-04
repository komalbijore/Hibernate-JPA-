package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletePersonRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersonAadhaar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		et.begin();
		Person person=em.find(Person.class,1);
		if(person!=null) {
			em.remove(person);
			System.out.println("Person record deleted");
		}
		else {
			System.out.println("Person record Not found");
		}
		et.commit();
		em.close();
	}
}
