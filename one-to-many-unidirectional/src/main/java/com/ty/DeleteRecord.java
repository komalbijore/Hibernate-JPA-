package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("BankAccount");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		Bank bank= em.find(Bank.class, 102);
		if(bank!=null) {
			em.remove(bank);
			System.out.println("Bank record deletd.");
		}else {
			System.out.println("Bank record not found.");
		}
		et.commit();
	}

}
