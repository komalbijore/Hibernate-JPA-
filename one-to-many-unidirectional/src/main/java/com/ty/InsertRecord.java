package com.ty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("BankAccount");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Bank bank=new Bank();
		bank.setId(101);
		bank.setName("SBI");
		bank.setIfsc("SBI1020");
		
		Account account1=new Account();
		account1.setAccNumber(1111);
		account1.setName("kajal");
		account1.setPhone(987653566);
		
		Account account2=new Account();
		account2.setAccNumber(2222);
		account2.setName("ram");
		account2.setPhone(767866777);
		
		Account account3=new Account();
		account3.setAccNumber(3333);
		account3.setName("shreya");
		account3.setPhone(978658873);;
		
		List <Account> accounts=new ArrayList<Account>();
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		bank.setAccounts(accounts);
		et.begin();
		em.persist(bank);
		em.persist(account1);
		em.persist(account2);
		em.persist(account3);
		et.commit();
		System.out.println("Record inserted.");	
		}
}
