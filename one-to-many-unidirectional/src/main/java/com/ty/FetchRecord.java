package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("BankAccount");
		EntityManager em=emf.createEntityManager();
		
		Bank bank=em.find(Bank.class, 101);
		if(bank!=null) { 
			System.out.println("-------- Bank details --------");
			System.out.println(bank.getId());
			System.out.println(bank.getName());
			System.out.println(bank.getIfsc());
			
			System.out.println("---------- Account details ---------");
			List<Account> accounts=bank.getAccounts();
			if(accounts!=null) {
				for(Account account:accounts) {
					System.out.println(account.getAccNumber());
					System.out.println(account.getName());
					System.out.println(account.getPhone());
					System.out.println("===============================");
				}
			}
			else {
				System.out.println("Accounts are not found.");
			}
		}else {
			System.out.println("Bank record not found.");
		}
	}

}
