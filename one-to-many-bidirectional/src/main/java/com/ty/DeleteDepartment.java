package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteDepartment {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("DepartmentEmployee");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Department dept=em.find(Department.class,1);
		if(dept!=null) {
			em.remove(dept);
			et.commit();
			System.out.println("Department record deleted.");
		}else {
			System.out.println("Department not found.");
		}
	}
}
