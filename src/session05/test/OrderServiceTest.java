package session05.test;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import session05.modle.Drink;
import session05.modle.Food;
import session05.modle.MenuItem;
import session05.modle.Order;
import session05.repository.OrderRepository;
import session05.service.OrderService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

	private OrderService orderService;
	private OrderRepository repo;

	@BeforeEach
	void setup() {

		repo = new OrderRepository();
		orderService = new OrderService(repo);
	}

	@Test
	public void testCalculateTotal() throws Exception {

		Order order = new Order("O1");

		MenuItem burger = new Food("F1", "Burger", 50000);

		order.addItem(burger, 2);

		orderService.createOrder(order);

		double total = orderService.calculateTotal("O1");

		assertEquals(100000, total);
	}

	@Test
	public void testCalculateTotalWithDrinkSize() throws Exception {

		Order order = new Order("O2");

		MenuItem drink = new Drink("D1", "Coca", 10000, "L");

		order.addItem(drink, 1);

		orderService.createOrder(order);

		double total = orderService.calculateTotal("O2");

		assertEquals(20000, total);
	}
}