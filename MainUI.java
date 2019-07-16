package com.capgemini.presentation;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


import com.capgemini.bean.Customer;
import com.capgemini.service.CustomerService;
import com.capgemini.service.CustomerServiceImpl;

public class MainUI {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		CustomerService service=new CustomerServiceImpl();
		boolean status=false;
		scanner.close();
		while(true) {
			System.out.println("1.Register\n2.update\n3.delete\n4.viewById\n5.ViewAll");
			int choice=scanner.nextInt();
			switch(choice) {
			case 0:System.exit(0);
			case 1:{
				
				try {
					System.out.println("enter name,address,phone");
				String name=scanner.next();
				String address=scanner.next();
				long phone=scanner.nextLong();
				System.out.println("Enter DOB in the format of dd-MM-yy");
				String dob=scanner.next();
				SimpleDateFormat sf= new SimpleDateFormat("dd-MM-yy");
				Date d =sf.parse(dob);
					Customer customer = new Customer(0,name,address,d,phone);
					int custId=service.saveCustomer(customer);
					if (custId>0)
						System.out.println(" customer registered successfully and your id is:"+custId);
					else
						System.out.println("not registerd try again.......");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}break;
			case 2:

				try {
					System.out.println("enter custId to update:");
					int custId=scanner.nextInt();
					System.out.println("enter name,address,phone");
					String name=scanner.next();
				String address=scanner.next();
				long phone=scanner.nextLong();
				System.out.println("Enter DOB in the format of dd-MM-yy");
				String dob=scanner.next();
				SimpleDateFormat sf= new SimpleDateFormat("dd-MM-yy");
				Date d =sf.parse(dob);
				
					Customer customer = new Customer(custId,name,address,d,phone);
					status=service.updateCustomer(customer);
					if (status)
						System.out.println(" customer updated successfully ");
					else
						System.out.println("not updated try again.......");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			default:
				System.out.println(" ");
			
			}
			
		}

	}

}
