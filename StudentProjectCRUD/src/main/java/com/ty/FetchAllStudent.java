package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAllStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentCRUD");
		EntityManager em=emf.createEntityManager();
		
		Query query=em.createQuery("select s from Student s");
			
		List <Student> students=query.getResultList();
	
		System.out.println("-------- Student Details -----------");
		
		for(Student student:students) {
		System.out.println(student.getSid());
		System.out.println(student.getName());
		System.out.println(student.getEmail());
		System.out.println(student.getPhone());
		System.out.println("==========================");
		}
		em.close();
		
	}

}
