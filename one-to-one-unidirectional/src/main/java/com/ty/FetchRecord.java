package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchRecord {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CarEngine");
		EntityManager em= emf.createEntityManager();
	
		Car car=em.find(Car.class, 101);
	
		if(car!=null) {
			System.out.println("--------------- Car Details ---------------");
			System.out.println(car.getCid());
			System.out.println(car.getBrand());
			System.out.println(car.getPrice());
			
			Engine engine=car.getEngine();
			if(engine!=null) {
				System.out.println("----------- Engine details -----------");
				System.out.println(engine.getEid());
				System.out.println(engine.getCc());
			}else {
				System.out.println("No engine associated with this car");
			}
		}
		else {
			System.out.println("car record not found");
		}
		em.close();

	}

}