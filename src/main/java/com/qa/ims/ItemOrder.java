package com.qa.ims;

public class ItemOrder {
	
	private Long id;
	private int order_id;
	private int item_id;
	private int quantity;

	public ItemOrder(int orderId, int itemId, int quantity) {
		this.order_id = orderId ;
		this.item_id = itemId;
		this.quantity = quantity;
	}

	public ItemOrder(Long id, int orderId, int itemId, int quantity) {
		this.id = id;
		this.order_id = orderId ;
		this.item_id = itemId;
		this.quantity = quantity;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrderId() {
		return order_id;
	}

	public void setOrderId(int order_id) {
		this.order_id = order_id;
	}

	public int getItemId() {
		return item_id;
	}

	public void setItemId(int item_id) {
		this.item_id = item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
