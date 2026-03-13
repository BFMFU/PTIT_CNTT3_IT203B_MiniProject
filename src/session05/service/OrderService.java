package session05.service;

import session05.exception.InvalidOrderIdException;
import session05.modle.MenuItem;
import session05.modle.Order;
import session05.repository.OrderRepository;

import java.util.List;

public class OrderService {

	private OrderRepository repo;

	public OrderService(OrderRepository repo) {
		this.repo = repo;
	}

	public void createOrder(Order order) {
		repo.add(order);
	}

	public void addItem(String orderId, MenuItem item, int quantity)
			throws InvalidOrderIdException {

		Order order = repo.findById(orderId)
				              .orElseThrow(() -> new InvalidOrderIdException("Order not found"));

		order.addItem(item, quantity);
	}

	public double calculateTotal(String orderId)
			throws InvalidOrderIdException {

		Order order = repo.findById(orderId)
				              .orElseThrow(() -> new InvalidOrderIdException("Order not found"));

		return order.calculateTotal();
	}

	public List<Order> getAllOrders() {
		return repo.getAll();
	}
}