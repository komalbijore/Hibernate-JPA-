package com.ty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CarEngine");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		Car car = em.find(Car.class, 103);
		if(car!=null) {
			car.setBrand("BMW");
			car.setPrice(8500000);
			em.merge(car);
			System.out.println("Record updated");
			
		}else {
			System.out.println("Record not found");
		}
		et.commit();
		em.close();
		emf.close();
	}
}