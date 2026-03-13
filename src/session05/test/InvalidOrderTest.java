package session05.test;

import org.junit.jupiter.api.Test;
import session05.exception.InvalidOrderIdException;
import session05.repository.OrderRepository;
import session05.service.OrderService;


import static org.junit.jupiter.api.Assertions.*;

public class InvalidOrderTest {

	@Test
	void testInvalidOrderId() {

		OrderService service = new OrderService(new OrderRepository());

		assertThrows(
				InvalidOrderIdException.class,
				() -> service.calculateTotal("INVALID_ID")
		);
	}
}