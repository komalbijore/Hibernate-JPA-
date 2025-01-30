package com.ty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	    @Id
		private int sid;
		private String name;
		private String email;
		private long phone;
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		
	
}
