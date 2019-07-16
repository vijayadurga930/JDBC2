package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.Customer;

public interface CustomerService {
int saveCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean removeCustomer(int custId);
	Customer viewById(int custId);
	List<Customer> viewAll();

}
