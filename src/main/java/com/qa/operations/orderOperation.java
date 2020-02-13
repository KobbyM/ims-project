package com.qa.operations;

import org.apache.log4j.Logger;

import com.qa.Utils;


public enum orderOperation {
	
	CREATE("To save a new order into the database"), READ("To read an order from the database"),
	UPDATE("To change an order already in the database"), DELETE("To remove an order from the database"),
	RETURN("To return to domain selection");
	
	public static final Logger LOGGER = Logger.getLogger(orderOperation.class);
	
	private String description;
	
	private orderOperation(String description){
		this.description = description;
	}
	
	public String description() {
		return this.name() + ": " + this.description;
	}
	
	public static void printOperations() {
		for (orderOperation operation : orderOperation.values()) {
			LOGGER.info(operation.description());
		}
	}
	
	public static orderOperation getAction() {
		orderOperation action;
		while (true) {
			try {
				action = orderOperation.valueOf(Utils.input().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return action;
	}
}
