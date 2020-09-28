package com.ericnguyen.springapi.dao;

import java.util.List;

import com.ericnguyen.springapi.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
