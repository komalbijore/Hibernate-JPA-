package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("DepartmentEmployee");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();	
		Employee employee=em.find(Employee.class, 1111);
		if(employee!=null) {
			Department dept=employee.getDept();
			if(dept!=null) {
				List<Employee> employees=dept.getEmployees();
				employees.remove(employee);
			}
			em.remove(employee);
			et.commit();
			System.out.println("Employee record deleted.");
		}
		else {
			System.out.println("Employee record not found.");
		}
		
	}
}
