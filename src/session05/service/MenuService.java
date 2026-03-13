package session05.service;

import session05.modle.MenuItem;
import session05.repository.MenuRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MenuService {

	private MenuRepository repo;

	public MenuService(MenuRepository repo) {
		this.repo = repo;
	}

	public void addItem(MenuItem item) {
		repo.add(item);
	}

	public List<MenuItem> searchByName(String name) {
		return repo.getAll()
				       .stream()
				       .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase()))
				       .collect(Collectors.toList());
	}

	public List<MenuItem> searchByPrice(double min, double max) {
		return repo.getAll()
				       .stream()
				       .filter(m -> m.calculatePrice() >= min && m.calculatePrice() <= max)
				       .collect(Collectors.toList());
	}

	public List<MenuItem> getAll() {
		return repo.getAll();
	}
}