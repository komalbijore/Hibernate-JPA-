package com.ty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CarEngine");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Car car= new Car();
		car.setCid(101);
		car.setBrand("AUDI");
		car.setPrice(1000000);
		
		Engine engine=new Engine();
		engine.setEid(111);
		engine.setCc(1000);
		 
		car.setEngine(engine);
		
		et.begin();
		em.persist(car);
		em.persist(engine);
		et.commit();
		System.out.println("Record inserted");
		em.close();
		emf.close();
	}

}