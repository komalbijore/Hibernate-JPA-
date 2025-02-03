package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("StudentSubject");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Student student=em.find(Student.class, 101);
		if(student!=null) {
			
			List<Subject> subject=student.getSubjects();
			
			Subject sub=new Subject();
			sub.setSid(444);
			sub.setName("SDLC");
			sub.setDays(7);
			
			subject.add(sub);
			
			student.setSubjects(subject);
			
			em.persist(sub);
			em.merge(student);
			et.commit();
			System.out.println("Student record updated.");
			
		}else {
			System.out.println("Student record not found.");
		}
	}
}
