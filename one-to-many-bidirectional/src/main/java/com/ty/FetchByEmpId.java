package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchByEmpId {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("DepartmentEmployee");
		EntityManager em=emf.createEntityManager();
		
		Employee employee=em.find(Employee.class, 333);
		
		if(employee!=null) {
			System.out.println("------- Employee Details --------");
			System.out.println(employee.getEid());
			System.out.println(employee.getName());
			System.out.println(employee.getEmail());
			
			Department dept=employee.getDept();
			if(dept!=null) {
			System.out.println("---- Deparment Details -------");
			System.out.println(dept.getDeptId());
			System.out.println(dept.getDname());
			System.out.println(dept.getLocation());
			}else {
				System.out.println("Department is not assigned.");
			}
		}else {
			System.out.println("Employee record not found.");
		}
		
	}

}
