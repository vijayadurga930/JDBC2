package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.bean.Customer;
import com.capgemini.utility.DBconnection;

public class CustomerDaoImpl implements CustomerDao {
	PreparedStatement statement=null;
	ResultSet resultset=null;
	int row=-1;
	@Override
	public int insertCustomer(Customer customer) {
		int custId=0;
		try(Connection connection = DBconnection.getConnection();)
		{
			statement=connection.prepareStatement("select customerseq.NEXTVAL from dual");
			resultset=statement.executeQuery();
			if(resultset.next())
			custId=resultset.getInt(1);
			statement=connection.prepareStatement("insert into customer values(?,?,?,?,?) ");
			statement.setInt(1,custId);
			statement.setString(2,customer.getName());
			statement.setString(3,customer.getAddress());
			statement.setLong(5,customer.getPhone());
			Date sqldob=new Date(customer.getDob().getTime());
			statement.setDate(4, sqldob);
			
			row=statement.executeUpdate();
				}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return custId;
	}

	@Override
	public int updateCustomer(Customer customer) {
		int custId=0;
		try(Connection connection=DBconnection.getConnection();)
		{
			statement=connection.prepareStatement("update customer set name=?,address=?,phone=?,dob=? where custid=?)");
	
			statement.setString(1,customer.getName());
			statement.setString(2,customer.getAddress());
			statement.setLong(4,customer.getPhone());
			Date sqldob=new Date(customer.getDob().getTime());
			statement.setDate(3, sqldob);
			statement.setInt(5,customer.getCustId());
			row=statement.executeUpdate();
				}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return custId;
	}

	@Override
	public int deleteCustomer(int custId) {
		try(Connection connection=DBconnection.getConnection();)
		{
			statement=connection.prepareStatement("delete from customer  where custid=?");
	
			statement.setInt(1,custId);
			
			row=statement.executeUpdate();
				}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	
	}

	@Override
	public Customer getById(int custId) {
		Customer customer=null;
		try(Connection connection=DBconnection.getConnection();)
		{
			statement=connection.prepareStatement("select * from customer  where custid=?");
	
			statement.setInt(1,custId);
			resultset=statement.executeQuery();
			if(resultset.next()) {
				customer = new Customer();
				customer.setCustId(resultset.getInt("custId"));
				customer.setName(resultset.getString("name"));
				customer.setAddress(resultset.getString("Address"));
				customer.setPhone(resultset.getLong("phone"));
				customer.setDob(resultset.getDate("dob"));
			}row=statement.executeUpdate();
				}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	
	}

	@Override
	public List<Customer> viewAll() {
		Customer customer=null;
		List<Customer> customerlist=new ArrayList<>();
		try(Connection connection=DBconnection.getConnection();)
		{
			statement=connection.prepareStatement("select * from customer");
	
			resultset=statement.executeQuery();
			while(resultset.next())
			{
				customer = new Customer();
				customer.setCustId(resultset.getInt("custId"));
				customer.setName(resultset.getString("name"));
				customer.setAddress(resultset.getString("Address"));
				customer.setPhone(resultset.getLong("phone"));
				customer.setDob(resultset.getDate("dob"));
				customerlist.add(customer);
			}
				
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return customerlist;
		
		
	}

	

}
