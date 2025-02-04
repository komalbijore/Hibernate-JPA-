package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersonAadhaar");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Person person=em.find(Person.class, 4);
		if(person!=null) {
			person.setPhone(9876543210L);
			person.setEmail("ramkapoor@gmail.com");
			em.merge(person);
			System.out.println("Person Details Updated.");
		}
		else {
			System.out.println("Person record not found");
		}
		et.commit();
		em.close();
	}

}
