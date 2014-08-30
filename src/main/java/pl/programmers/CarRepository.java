package pl.programmers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car, Long> {
	Car findByName(String carName);

	List<Car> findByNameContainingIgnoringCase(String query);

	@Query(value = "SELECT c FROM Car c where c.name = :name")
	Car findBy(@Param("name") String name);

}
