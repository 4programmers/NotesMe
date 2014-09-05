package pl.programmers.example;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import pl.programmers.BaseIntegrationTest;
import pl.programmers.model.Operator;
import pl.programmers.repo.OperatorRepository;

public class OperatorRepositoryTest extends BaseIntegrationTest {
	@Inject
	OperatorRepository repo;

	@Test
	public void shouldAddOperator() throws Exception {
		// given
		Operator operator = createOperator();

		long currentCount = repo.count();

		// when
		repo.save(operator);

		// then
		assertThat(repo.count()).isEqualTo(currentCount + 1);
	}

	@Test
	public void shouldFindCarByName() throws Exception {
		// given
		String operatorFName = "Mike";
		String operatorLName = "Smith";

		Operator operator = createOperator(operatorFName, operatorLName);
		repo.save(operator);

		// when
		List<Operator> operators = repo.find(operatorFName);

		// then
		assertThat(operators).hasSize(1);
	}

	private Operator createOperator(String firstName, String lastName) {
		Operator operator = new Operator();
		operator.setEmail(firstName + "@gmail.com");
		operator.setFirstName(firstName);
		operator.setLastName(lastName);
		return operator;
	}

	private Operator createOperator() {
		return createOperator("John", "Smith");
	}

}
