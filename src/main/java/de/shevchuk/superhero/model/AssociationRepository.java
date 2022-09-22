package de.shevchuk.superhero.model;

import de.shevchuk.superhero.entity.Association;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends CrudRepository<Association, String> {
}