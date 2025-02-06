package com.ty;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("DepartmentEmployee");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		
		Department dept=new Department();
		dept.setDeptId(1);
		dept.setDname("Software development");
		dept.setLocation("Navi Mumbai");
		
		Employee emp1=new Employee();
		emp1.setEid(111);
		emp1.setName("rahul");
		emp1.setEmail("rahul@gmail.com");
		emp1.setDept(dept);
		
		Employee emp2=new Employee();
		emp2.setEid(222);
		emp2.setName("karan");
		emp2.setEmail("karan@gmail.com");
		emp2.setDept(dept);
		
		Employee emp3=new Employee();
		emp3.setEid(333);
		emp3.setName("mayur");
		emp3.setEmail("mayur@gmail.com");
		emp3.setDept(dept);
		
		 List<Employee>employees=Arrays.asList(emp1,emp2,emp3);
		dept.setEmployees(employees);
		
		em.persist(dept);
		et.commit();
		System.out.println("Record inserted.");
	}

}
