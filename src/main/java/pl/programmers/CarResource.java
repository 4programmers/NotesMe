package pl.programmers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarResource {
	@Inject
	CarRepository repo;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Car find(@PathVariable Long id) {
		return repo.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Car> all(@RequestParam(required = false) String query) {
		if (query == null) {
			return repo.findAll();
		}
		return repo.findByNameContainingIgnoringCase(query);

	}

	@RequestMapping(method = RequestMethod.POST)
	public Long save(@RequestBody Car car) {
		repo.save(car);
		return car.getId();

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Long id) {
		repo.delete(id);

	}
}
