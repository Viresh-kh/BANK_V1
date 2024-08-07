package com.Bank.Dao;

import java.util.List;

import com.Bank.Dto.Customer;



public interface CustomerDao {
	
	public boolean insertCustomer(Customer c);
	public Customer getCustomer(long accno, int pin);
	public Customer getCustomer(long phone,String mail);
	public Customer getCustomer(long accno);
	public List     getCustomer();
	public boolean  updaetcustomer(Customer c);
	public boolean  deleteCustomer(Customer c);
	
	
	
	

}
