package de.shevchuk.superhero.model;

import de.shevchuk.superhero.entity.Superhero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroRepository  extends CrudRepository<Superhero, Long> {
}
