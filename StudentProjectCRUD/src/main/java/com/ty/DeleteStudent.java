package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentCRUD");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Student student= em.find(Student.class, 101);
		
		if(student!=null) {
			em.remove(student);
			System.out.println("student record deleted.");
			
		}else {
			System.out.println("student record not found.");
		}
		
		et.commit();
		em.close();
		
	}

}
