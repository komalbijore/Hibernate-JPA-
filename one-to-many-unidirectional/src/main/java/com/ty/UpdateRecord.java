package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("BankAccount");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Bank bank=em.find(Bank.class, 101);
		if(bank!=null) {
			bank.setIfsc("SIB10101");
			List<Account> accounts=bank.getAccounts();
			
			Account account=new Account();
			account.setAccNumber(5555);
			account.setName("raj");
			account.setPhone(865753727);
			
			accounts.add(account);
			
			bank.setAccounts(accounts);
			
			em.persist(account);
			em.merge(bank);
			System.out.println("Record updated.");
		}else {
			System.out.println("Bank record not found.");
		}
		
		et.commit();
		
	}
}
