package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("StudentSubject");
		EntityManager em=emf.createEntityManager();
		
		Student student=em.find(Student.class, 101);
		
		if(student!=null) {
			System.out.println("------- Student details ---------");
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			
			List<Subject>subjects=student.getSubjects();
			if(subjects!=null) {
				System.out.println("------Subject details ---------");
				for(Subject subject:subjects) {
					System.out.println(subject.getSid());
					System.out.println(subject.getName());
					System.out.println(subject.getDays());
					System.out.println("============================");
				}
			}else {
				System.out.println("Subject not selected");
			}
		}else {
			System.out.println("Student record not found");
		}
	
	}

}
