package com.qa.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.Utils;
import com.qa.ims.CrudServices;
import com.qa.ims.Item;
import com.qa.ims.Order;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order>{
public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private CrudServices<Order> orderService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	
	String input() {
		return Utils.input();
	}
	
	/**
	 * Reads all Orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for(Order order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter the customer id");
		int customerId = Integer.parseInt(input());
		LOGGER.info("Please enter the item id of item you wish to buy -- enter stop to finish creating");
		Long id = Long.valueOf(input());
		LOGGER.info("Please enter the quantity of item");
		int quantity = Integer.parseInt(input());
		double totalCost = 0;
		Order order= orderService.create(new Order(customerId, quantity, totalCost));
		LOGGER.info("Order created");
		System.out.println("------------");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you wish to update");
		Long id = Long.valueOf(input());
		LOGGER.info("Please enter the id of the customer");
		int customerId = Integer.parseInt(input());
		LOGGER.info("Please enter the quantity of item");
		int quantity = Integer.parseInt(input());
		double totalCost = 0;
		Order order= orderService.create(new Order(id, customerId, quantity, totalCost));
		LOGGER.info("Order Updated");
		System.out.println("------------");
		return order;
	}

	/**
	 * Deletes an existing order by the id of the order
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = Long.valueOf(input());
		orderService.delete(id);
		LOGGER.info("Order deleted");
	}
}
