package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ItemDaoMysql implements Dao<Item> {
	
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);

	Item itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("item_id");
		String itemName = resultSet.getString("item_name");
		double price = resultSet.getDouble("price");
		return new Item(id, itemName, price);
	}
	/**
	 * Reads all items from the database
	 * 
	 * @return A list of items
	 */
	@Override
	public List<Item> readAll() {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from items");) {
			ArrayList<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(itemFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Item readLatest() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY item_id DESC LIMIT 1");) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an item in the database
	 * 
	 * @param item - takes in an item object. id will be ignored
	 */
	@Override
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into items(item_name, price) values('" + item.getItemName()
					+ "','" + item.getPrice() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Item readItem(Long item_id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item where item_id = " + item_id);) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null; 
	}

	/**
	 * Updates an item in the database
	 * 
	 * @param item - takes in an item object, the id field will be used to
	 *                 update that item in the database
	 * @return 
	 */
	@Override
	public Item update(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.19.218:3306/projectdb", "root", "g2e6can26");
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update items set item_name ='" + item.getItemName() + "', surname ='"
					+ item.getPrice() + "' where item_id =" + item.getId());
			return readItem(item.getId());
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
			statement.executeUpdate("delete from item where item_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
}
