package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertStudent {
	public static void main(String[] args) {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentCRUD");
			EntityManager em= emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
		
			Student student=new Student();
			
			student.setSid(103);
			student.setName("ram");
			student.setEmail("ram@gmail.com");
			student.setPhone(893456781);
			
			et.begin();
			em.persist(student);
			et.commit();
			em.close();
			System.out.println("student record inserted.");
			
	}

}
