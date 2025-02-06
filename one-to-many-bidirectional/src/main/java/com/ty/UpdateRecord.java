package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("DepartmentEmployee");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		
		Department dept=em.find(Department.class, 1);
		if(dept!=null) {
			dept.setLocation("Airoli");
			
			List <Employee>employees=dept.getEmployees();
			
			Employee employee=new Employee();
			employee.setEid(444);
			employee.setName("rishi");
			employee.setEmail("rishi@gmail.com");
			employee.setDept(dept);
			
			employees.add(employee);
			et.commit();
			System.out.println("Record updated.");
			
		}else {
			System.out.println("Department not found.");
		}
	}
}
