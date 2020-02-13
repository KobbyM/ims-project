package com.qa.services;

import java.util.List;

import com.qa.ims.CrudServices;
import com.qa.ims.Customer;
import com.qa.ims.Dao;



public class CustomerServices implements CrudServices<Customer> {

	Dao<Customer> customerDao;
	
	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}
	
	public List<Customer> readAll() {
		return customerDao.readAll();
	}

	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}

	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}

	public void delete(Long customer_id) {
		customerDao.delete(customer_id);
	}

}
