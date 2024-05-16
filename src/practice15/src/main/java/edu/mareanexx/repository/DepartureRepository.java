package edu.mareanexx.repository;

import edu.mareanexx.models.Departure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartureRepository extends CrudRepository<Departure, Long> {
}
