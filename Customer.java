package com.capgemini.bean;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	 private int custId;
	 private String name;
	 private String address;
	 private Date dob;
	 private long phone;

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", address=" + address + ", dob=" + dob + ", phone="
				+ phone + "]";
	}
	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
		public void setAddress(String address) {
		this.address = address;
	}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}


	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Customer(int custId, String name, String address, Date dob, long phone) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		
	}

	public Customer() {
		super();
	}

	public static void main(String[] args) {
		

	}

}
