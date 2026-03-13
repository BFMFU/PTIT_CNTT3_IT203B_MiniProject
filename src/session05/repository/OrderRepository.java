package session05.repository;


import session05.modle.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

	private List<Order> orders = new ArrayList<>();

	public void add(Order order) {
		orders.add(order);
	}

	public List<Order> getAll() {
		return orders;
	}

	public Optional<Order> findById(String id) {
		return orders.stream()
				       .filter(o -> o.getOrderId().equals(id))
				       .findFirst();
	}

}