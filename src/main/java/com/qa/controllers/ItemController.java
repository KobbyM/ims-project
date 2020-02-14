package com.qa.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.Utils;
import com.qa.ims.CrudServices;
import com.qa.ims.Item;


/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item>{

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	private CrudServices<Item> itemService;
	
	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}
	
	public String input() {
		return Utils.input();
	}
	
	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for(Item item: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates an item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter the item name");
		String itemName = input();
		LOGGER.info("Please enter a price for the item");
		double price = Double.parseDouble(input());
		Item item = itemService.create(new Item(itemName, price));
		LOGGER.info("Item created");
		System.out.println("------------");
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you wish to update");
		Long id = Long.valueOf(input());
		LOGGER.info("Please enter an item name");
		String itemName = input();
		LOGGER.info("Please enter a price");
		double price = Double.parseDouble(input());
		Item item = itemService.update(new Item(id, itemName, price));
		LOGGER.info("Item Updated");
		System.out.println("------------");
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = Long.valueOf(input());
		itemService.delete(id);
		LOGGER.info("Item deleted");
	}
	
}
