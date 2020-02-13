package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class OrderDaoMysql implements Dao<Order> {
	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);

	Order orderFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("order_id");
		int customer_id = resultSet.getInt("customer_id");
		int quantity = resultSet.getInt("quantity");
		double total_cost = resultSet.getDouble("total_cost");
		return new Order(id, customer_id, quantity, total_cost);
	}
	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders");) {
			ArrayList<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(orderFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return orderFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order in the database
	 * 
	 * @param order - takes in an order object. id will be ignored
	 */
	@Override
	public Order create(Order order) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders(customer_id, quantity, total_cost) values('" + order.getCustomerId() + "','" + order.getQuantity() + 
					"','" + order.getTotalCost() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Order readOrder(Long order_id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where order_id = " + order_id);) {
			resultSet.next();
			return orderFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null; 
	}

	/**
	 * Updates an order in the database
	 * 
	 * @param order - takes in an order object, the id field will be used to
	 *                 update that order in the database
	 * @return 
	 */
	@Override
	public Order update(Order order) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update orders set customer_id ='" + order.getCustomerId() + "quantity ='" + order.getQuantity() + "' where order_id =" + order.getId());
			return readOrder(order.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an item in the database
	 * 
	 * @param id - id of the item
	 */
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from order where order_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
