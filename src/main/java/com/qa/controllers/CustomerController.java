package com.qa.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.Utils;
import com.qa.ims.CrudServices;
import com.qa.ims.Customer;



/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController<Customer>{

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CrudServices<Customer> customerService;
	
	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}
	
	public String getInput() {
		return Utils.input();
	}
	
	/**
	 * Reads all customers to the logger
	 */
	public List<Customer> readAll() {
		List<Customer> customers = customerService.readAll();
		for(Customer customer: customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		Customer customer = customerService.create(new Customer(firstName, surname));
		LOGGER.info("Customer created");
		return customer;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		Long customer_id = Long.valueOf(getInput());
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		Customer customer = customerService.update(new Customer(customer_id, firstName, surname));
		LOGGER.info("Customer Updated");
		return customer;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long customer_id = Long.valueOf(getInput());
		customerService.delete(customer_id);
	}
	
}
