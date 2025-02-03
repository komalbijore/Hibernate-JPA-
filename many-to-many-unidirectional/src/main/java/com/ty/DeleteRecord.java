package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("StudentSubject");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Student student=em.find(Student.class, 102);
		if(student!=null) {
			em.remove(student);
			et.commit();
			System.out.println("Student record deleted.");
		}else {
			System.out.println("student not found.");
		}
	}

}
