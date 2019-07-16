package com.capgemini.dao;

import java.util.List;

import com.capgemini.bean.Customer;

public interface CustomerDao {
         int insertCustomer(Customer customer);
         int updateCustomer(Customer customer);
         int deleteCustomer(int custId);
         Customer getById(int custId);
         List<Customer> viewAll();
         
         
         
	
	
	
}
