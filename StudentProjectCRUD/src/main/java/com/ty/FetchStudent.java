package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchStudent {
   public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentCRUD");
	EntityManager em= emf.createEntityManager();
	
	Student student=em.find(Student.class, 102);
	
	if(student!=null) {
		System.out.println("---------- Student Details -----------");
		System.out.println("sid : "+student.getSid());
		System.out.println("Name : " +student.getName());
		System.out.println("Email : "+student.getEmail());
		System.out.println("phone : " +student.getPhone());
	}else {
		System.out.println("student record not found.");
		
	}
	em.close();
}
}
