package de.shevchuk.superhero.model;

import de.shevchuk.superhero.dto.SuperheroPowerId;
import de.shevchuk.superhero.entity.SuperheroPower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroPowerRepository extends CrudRepository<SuperheroPower, SuperheroPowerId> {
}