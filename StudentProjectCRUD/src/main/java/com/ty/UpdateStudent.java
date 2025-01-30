package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateStudent {
	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("studentCRUD");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		
		Student student=em.find(Student.class, 101);
		
		if(student!=null) {
			student.setEmail("ramakant@gmail.com");
			student.setPhone(876565783);
			em.merge(student);
			System.out.println("student record updated.");
		}else {
			System.out.println("student record not found.");
		}
		et.commit();
		em.close();
	}

}
