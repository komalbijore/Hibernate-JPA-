package com.ty;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertStudentRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("StudentSubject");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student student2=new Student();
		student2.setId(102);
		student2.setName("shruti");
		student2.setEmail("shruti@gmail.com");
		
		Subject subject1=new Subject();
		subject1.setSid(333);
		subject1.setName("CSS");
		subject1.setDays(10);
		
		//Fetch existing subjects from database 
		Subject subject2=em.find(Subject.class, 111); 
		Subject subject3=em.find(Subject.class, 222);
		
		List<Subject> subjects=Arrays.asList(subject1,subject2,subject3);
		
		student2.setSubjects(subjects);
		
		et.begin();
		em.persist(student2);
		em.persist(subject1);
		et.commit();
		System.out.println("Record inserted.");
		
	}
}
