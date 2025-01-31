package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteRecord {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CarEngine");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		et.begin();
		Car car=em.find(Car.class, 101);
	
		if(car!=null) {
			em.remove(car);
			System.out.println("record deleted");
		}else {
			System.out.println("record not found");
		}
		
		et.commit();
		em.close();
	
	}

}