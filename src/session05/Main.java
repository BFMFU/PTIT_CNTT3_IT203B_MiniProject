package session05;

import session05.modle.Drink;
import session05.modle.Food;
import session05.modle.MenuItem;
import session05.modle.Order;
import session05.repository.MenuRepository;
import session05.repository.OrderRepository;
import session05.service.MenuService;
import session05.service.OrderService;

import java.util.List;
import java.util.Scanner;

public class Main {

	private static MenuService menuService;
	private static OrderService orderService;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		MenuRepository menuRepo = new MenuRepository();
		OrderRepository orderRepo = new OrderRepository();

		menuService = new MenuService(menuRepo);
		orderService = new OrderService(orderRepo);

		int choice;

		do {

			System.out.println("\n====== FAST FOOD MANAGEMENT ======");
			System.out.println("1. Thêm món ăn");
			System.out.println("2. Hiển thị menu");
			System.out.println("3. Tìm món theo tên");
			System.out.println("4. Tìm món theo khoảng giá");
			System.out.println("5. Tạo đơn hàng");
			System.out.println("6. Thêm món vào đơn");
			System.out.println("7. Tính tổng tiền đơn hàng");
			System.out.println("8. Xem danh sách đơn hàng");
			System.out.println("9. Thoát");

			System.out.print("Chọn: ");
			choice = Integer.parseInt(sc.nextLine());

			switch (choice) {

				case 1 -> addMenuItem();

				case 2 -> showMenu();

				case 3 -> searchByName();

				case 4 -> searchByPrice();

				case 5 -> createOrder();

				case 6 -> addItemToOrder();

				case 7 -> calculateOrderTotal();

				case 8 -> showOrders();

				case 9 -> System.out.println("Thoát chương trình");

				default -> System.out.println("Lựa chọn không hợp lệ");
			}

		} while (choice != 9);
	}

	private static void addMenuItem() {

		System.out.print("ID: ");
		String id = sc.nextLine();

		System.out.print("Tên: ");
		String name = sc.nextLine();

		System.out.print("Giá: ");
		double price = Double.parseDouble(sc.nextLine());

		System.out.print("Loại (1-Food | 2-Drink): ");
		int type = Integer.parseInt(sc.nextLine());

		MenuItem item;

		if (type == 2) {

			System.out.print("Size (S/M/L): ");
			String size = sc.nextLine();

			item = new Drink(id, name, price, size);

		} else {

			item = new Food(id, name, price);
		}

		menuService.addItem(item);

		System.out.println("Đã thêm món!");
	}

	private static void showMenu() {

		List<MenuItem> list = menuService.getAll();

		if (list.isEmpty()) {
			System.out.println("Menu trống");
			return;
		}

		list.forEach(System.out::println);
	}

	private static void searchByName() {

		System.out.print("Nhập tên: ");
		String name = sc.nextLine();

		List<MenuItem> list = menuService.searchByName(name);

		list.forEach(System.out::println);
	}

	private static void searchByPrice() {

		System.out.print("Giá min: ");
		double min = Double.parseDouble(sc.nextLine());

		System.out.print("Giá max: ");
		double max = Double.parseDouble(sc.nextLine());

		List<MenuItem> list = menuService.searchByPrice(min, max);

		list.forEach(System.out::println);
	}

	private static void createOrder() {

		System.out.print("Order ID: ");
		String id = sc.nextLine();

		Order order = new Order(id);

		orderService.createOrder(order);

		System.out.println("Đã tạo order");
	}

	private static void addItemToOrder() {

		try {

			System.out.print("Order ID: ");
			String orderId = sc.nextLine();

			System.out.print("Menu ID: ");
			String itemId = sc.nextLine();

			System.out.print("Số lượng: ");
			int qty = Integer.parseInt(sc.nextLine());

			MenuItem item = menuService.getAll()
					                .stream()
					                .filter(m -> m.getId().equals(itemId))
					                .findFirst()
					                .orElseThrow(() -> new RuntimeException("Không tìm thấy món"));

			orderService.addItem(orderId, item, qty);

			System.out.println("Đã thêm món");

		} catch (Exception e) {

			System.out.println("Lỗi: " + e.getMessage());
		}
	}
	private static void calculateOrderTotal() {

		try {

			System.out.print("Order ID: ");
			String id = sc.nextLine();

			double total = orderService.calculateTotal(id);

			System.out.println("Tổng tiền: " + total);

		} catch (Exception e) {

			System.out.println("Lỗi: " + e.getMessage());
		}
	}

	private static void showOrders() {

		orderService.getAllOrders()
				.forEach(o -> System.out.println(
						o.getOrderId() + " | " + o.calculateTotal()
				));
	}
}