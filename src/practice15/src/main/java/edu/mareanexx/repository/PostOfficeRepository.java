package edu.mareanexx.repository;

import edu.mareanexx.models.PostOffice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostOfficeRepository extends CrudRepository<PostOffice, Long> {
}
