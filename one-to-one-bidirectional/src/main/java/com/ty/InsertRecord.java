package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {
	
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersonAadhaar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		
		Person person=new Person();
		person.setName("ram");
		person.setEmail("ram@gmail.com");
		person.setPhone(9767894530L);
		
		AadhaarCard aadhaar=new AadhaarCard();
		aadhaar.setAadhaarNo(836786787899L);
		aadhaar.setIssueDate("20-Jan-2014");
		
		person.setAadhaarCard(aadhaar);
		
		em.persist(person);
		et.commit();
		em.close();
		System.out.println("Record inserted");
	}
}
