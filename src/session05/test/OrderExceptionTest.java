package session05.test;


import org.junit.Test;
import session05.modle.Food;
import session05.modle.MenuItem;
import session05.repository.OrderRepository;
import session05.service.OrderService;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderExceptionTest {

	@Test
	public void testAddItemInvalidOrder() {

		OrderService service = new OrderService(new OrderRepository());

		MenuItem burger = new Food("F1", "Burger", 50000);

		assertThrows(Exception.class, () -> {

			service.addItem("O999", burger, 1);

		});
	}
}