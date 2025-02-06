package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetcByDeptId {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("DepartmentEmployee");
		EntityManager em=emf.createEntityManager();

		Department dept=em.find(Department.class, 1);
		if(dept!=null) {
			System.out.println("----- Department Details -------");
			System.out.println(dept.getDeptId());
			System.out.println(dept.getDname());
			System.out.println(dept.getLocation());
			
			List <Employee> employees=dept.getEmployees();
			if(employees!=null) {
				System.out.println("------ Employees Details -------");
				for(Employee emp:employees) {
					System.out.println(emp.getEid());
					System.out.println(emp.getName());
					System.out.println(emp.getEmail());
					System.out.println("================================");
				}
			}else {
				System.out.println("Employee not found");
			}
		}else {
			System.out.println("Department not found.");
		}
	}

}
