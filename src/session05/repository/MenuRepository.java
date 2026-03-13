package session05.repository;

import session05.modle.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuRepository {

	private List<MenuItem> menu = new ArrayList<>();

	public void add(MenuItem item) {
		menu.add(item);
	}

	public List<MenuItem> getAll() {
		return menu;
	}

	public Optional<MenuItem> findById(String id) {
		return menu.stream()
				       .filter(m -> m.getId().equals(id))
				       .findFirst();
	}

	public void delete(String id) {
		menu.removeIf(m -> m.getId().equals(id));
	}
}