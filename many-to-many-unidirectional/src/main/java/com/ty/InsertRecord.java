package com.ty;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("StudentSubject");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et= em.getTransaction();
		
		Student student=new Student();
		student.setId(101);
		student.setName("kirti");
		student.setEmail("kirti@gmail.com");
		
		Subject subject1= new Subject();
		subject1.setSid(111);
		subject1.setName("HTML");
		subject1.setDays(20);
		
		Subject subject2=new Subject();
		subject2.setSid(222);
		subject2.setName("JAVA");
		subject2.setDays(60);
		
		List<Subject> subjects=Arrays.asList(subject1,subject2);
		
		student.setSubjects(subjects);
		
		et.begin();
		em.persist(student);
		em.persist(subject1);
		em.persist(subject2);
		et.commit();
		System.out.println("Record inserted");
	}

}
