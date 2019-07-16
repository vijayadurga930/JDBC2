package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.Customer;
import com.capgemini.dao.CustomerDao;
import com.capgemini.dao.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {
	boolean status=false;
	int row=-1;
	CustomerDao customerDao= new CustomerDaoImpl();

	@Override
	public int saveCustomer(Customer customer) {
		row=customerDao.insertCustomer(customer);
		return row;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		row=customerDao.updateCustomer(customer);
		if(row>0)
			status=true;
		return status;
	}

	@Override
	public boolean removeCustomer(int custId) {
		row=customerDao.deleteCustomer(custId);
		if(row>0)
			status=true;
		return status;
	
	}

	@Override
	public Customer viewById(int custId) {
		
		return customerDao.getById(custId);
	}

	@Override
	public List<Customer> viewAll() {
		
		return customerDao.viewAll();
	}

	
}
