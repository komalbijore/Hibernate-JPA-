package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAllRecords {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CarEngine");
		EntityManager em=emf.createEntityManager();
		
		Query query =em.createQuery("select c from Car c");
		
		List<Car> cars=query.getResultList();
		
		for(Car car:cars) {
			System.out.println("------- car details -------");
			System.out.println(car.getCid());
			System.out.println(car.getBrand());
			System.out.println(car.getPrice());
			
			System.out.println("------ engine details --------");
			Engine engine=car.getEngine();
			if(engine!=null) {
				System.out.println(engine.getEid());
				System.out.println(engine.getCc());
				System.out.println("=======================================");
			}else {
				System.out.println("No engine associated with this car");
			}
		}
		em.close();
	}
}