package com.qa.ims;

public class Order {

		private Long id;
		private int customer_id;
		private int quantity;
		private double total_cost;

		public Order(int customerId, int quantity, double totalCost) {
			this.customer_id = customerId ;
			this.quantity = quantity;
			this.total_cost = totalCost;
		}

		public Order(Long id, int customerId, int quantity, double totalCost) {
			this.id = id;
			this.customer_id = customerId ;
			this.quantity = quantity;
			this.total_cost = totalCost;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public int getCustomerId() {
			return customer_id;
		}
		
		public void setCustomerId(int customer_id) {
			this.customer_id = customer_id;
		}

		public double getTotalCost() {
			return total_cost;
		}

		public void setTotalCost(double total_cost) {
			this.total_cost = total_cost;
		}

		public String toString() {
			return "id:" + id + " | customer id:" + customer_id + " | Quantity: " + quantity + " | Total Cost: £" + total_cost;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + customer_id;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + quantity;
			long temp;
			temp = Double.doubleToLongBits(total_cost);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Order other = (Order) obj;
			if (customer_id != other.customer_id)
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (quantity != other.quantity)
				return false;
			if (Double.doubleToLongBits(total_cost) != Double.doubleToLongBits(other.total_cost))
				return false;
			return true;
		}

		

		
	
}
