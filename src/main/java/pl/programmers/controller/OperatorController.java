package pl.programmers.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.programmers.model.Operator;
import pl.programmers.repo.OperatorRepository;
import pl.programmers.util.log.AutowiredLogger;

@RestController
@RequestMapping("/operators")
public class OperatorController {

    @AutowiredLogger
    private Logger logger;

	@Inject
	private OperatorRepository repo;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Operator find(@PathVariable Long id) {
		return repo.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Operator> all(@RequestParam(required = false) String query) {
		if (query == null) {
			return repo.findAll();
		}
		return repo.find(query);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Long save(@RequestBody Operator car) {
		repo.save(car);
		return car.getId();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Long id) {
		repo.delete(id);
	}

	@PostConstruct
	public void addSomeOperators() {
		Operator john = new Operator();
		john.setEmail("john@gmail.com");
		john.setFirstName("John");
		john.setLastName("Kowalski");
		repo.save(john);

		Operator mike = new Operator();
		mike.setEmail("mike@gmail.com");
		mike.setFirstName("Mikre");
		mike.setLastName("Kowalski");
		repo.save(mike);
	}
}
