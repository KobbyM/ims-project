package com.qa;

import org.apache.log4j.Logger;

import com.qa.controllers.CrudController;
import com.qa.controllers.CustomerController;
import com.qa.controllers.ItemController;
import com.qa.controllers.OrderController;
import com.qa.ims.CustomerDaoMysql;
import com.qa.ims.Domain;
import com.qa.ims.ItemDaoMysql;
import com.qa.ims.OrderDaoMysql;
import com.qa.operations.customerOperation;
import com.qa.operations.itemOperation;
import com.qa.operations.orderOperation;
import com.qa.services.CustomerServices;
import com.qa.services.ItemServices;
import com.qa.services.OrderServices;

public class Ims {
	
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	
	public void imsSystem() {
		
		
		//while (true) {
			LOGGER.info("Which entity would you like to use");
			System.out.println("------------");
			Domain.printDomains();
		
			Domain domain = Domain.getDomain();
			LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");
			System.out.println("------------");
			
			String operation = Utils.input();
			customerOperation cOperation = null;
			itemOperation iOperation = null;	
			orderOperation oOperation = null;
		
			switch (domain) {
			case CUSTOMER:
				customerOperation.printOperations();
				cOperation = customerOperation.getAction();
				CustomerController customerController = new CustomerController(new CustomerServices(new CustomerDaoMysql("username", "password")));
				doCustomerAction(customerController, cOperation);
				break;
			case ITEM:
				itemOperation.printOperations();
				iOperation = itemOperation.getAction();
				ItemController itemController = new ItemController(new ItemServices(new ItemDaoMysql()));
				doItemAction(itemController, iOperation);
				break;
			case ORDER:
				orderOperation.printOperations();
				oOperation = orderOperation.getAction();
				OrderController orderController = new OrderController(new OrderServices(new OrderDaoMysql()));
				doOrderAction(orderController, oOperation);
				break;
			case STOP:
				//System.exit(0);
				break;
			default:
				break;
			}
			
			//break;
		//}
			
	}		
	
	
	public void doCustomerAction(CrudController crudController, customerOperation cOperation) {
		switch (cOperation) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			imsSystem();
			break;
		default:
			break;
		}
	}
	
	public void doItemAction(CrudController crudController, itemOperation iOperation) {
		switch (iOperation) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			imsSystem();
			break;
		default:
			break;
		}
	}
	
	public void doOrderAction(CrudController crudController, orderOperation oOperation) {
		switch (oOperation) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			imsSystem();
			break;
		default:
			break;
		}
	}
}
