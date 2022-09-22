package de.shevchuk.superhero.model;

import de.shevchuk.superhero.dto.SuperheroAssociationId;
import de.shevchuk.superhero.entity.SuperheroAssociation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroAssociationRepository extends CrudRepository<SuperheroAssociation, SuperheroAssociationId> {
}