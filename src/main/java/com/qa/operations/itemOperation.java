package com.qa.operations;

import org.apache.log4j.Logger;

import com.qa.Utils;


public enum itemOperation {
	
	CREATE("To save a new item into the database"), READ("To all items in the database"),
	UPDATE("To change an item already in the database"), DELETE("To remove an item from the database"),
	RETURN("To return to domain selection");
	
	public static final Logger LOGGER = Logger.getLogger(itemOperation.class);
	
	private String description;
	
	private itemOperation(String description){
		this.description = description;
	}
	
	public String description() {
		return this.name() + ": " + this.description;
	}
	
	public static void printOperations() {
		for (itemOperation operation : itemOperation.values()) {
			LOGGER.info(operation.description());
		}
	}
	
	public static itemOperation getAction() {
		itemOperation action;
		while (true) {
			try {
				action = itemOperation.valueOf(Utils.input().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return action;
	}
}
