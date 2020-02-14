package com.qa;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.controllers.CustomerController;
import com.qa.controllers.ItemController;
import com.qa.ims.Customer;
import com.qa.ims.Item;
import com.qa.services.CustomerServices;
import com.qa.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	/**
	 *  The thing I want to fake functionality for
	 */
	@Mock
	private ItemServices itemServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the customers I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>();
		items.add(new Item("Shield", 5));
		items.add(new Item("Hat", 7));
		items.add(new Item("Shoes", 10));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	public void createTest() {
		String itemName = "Shield";
		double price = 5.50;
		Mockito.doReturn(itemName).when(itemController).input();
		Mockito.doReturn(price).when(itemController).input();
		Item item = new Item(itemName, price);
		Item savedItem = new Item(1L, "Shield", 5.50);
		Mockito.when(itemServices.create(itemController.create()));
		assertEquals(savedItem, itemController.create());
	}

	@Test
	public void updateTest() {
		String item_id = "1";
		String itemName = "Gloves";
		double price = 10.99;
		Mockito.doReturn(item_id, itemName, price).when(itemController).input();
		Item item = new Item(1L, itemName, price);
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemController).input();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}
}
