package pl.programmers.examples.operator.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.programmers.examples.operator.model.Operator;

public interface OperatorRepository extends JpaRepository<Operator, Long> {

	Operator findByEmail(String email);

	@Query("FROM Operator WHERE lower(firstName) like lower(:query) or lower(lastName) like lower(:query)")
	List<Operator> find(@Param("query") String query);

}
