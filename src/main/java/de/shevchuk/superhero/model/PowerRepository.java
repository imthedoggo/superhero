package de.shevchuk.superhero.model;

import de.shevchuk.superhero.entity.Power;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerRepository extends CrudRepository<Power, String> {
}