package com.qa.operations;

import org.apache.log4j.Logger;

import com.qa.Utils;


public enum customerOperation {
	
	CREATE("To save a new customer into the database"), READ("To read a customer from the database"),
	UPDATE("To change a customer already in the database"), DELETE("To remove a customer from the database"),
	RETURN("To return to domain selection");
	
	public static final Logger LOGGER = Logger.getLogger(customerOperation.class);
	
	private String description;
	
	private customerOperation(String description){
		this.description = description;
	}
	
	public String description() {
		return this.name() + ": " + this.description;
	}
	
	public static void printOperations() {
		for (customerOperation operation : customerOperation.values()) {
			LOGGER.info(operation.description());
		}
	}
	
	public static customerOperation getAction() {
		customerOperation action;
		while (true) {
			try {
				action = customerOperation.valueOf(Utils.input().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return action;
	}
}
