package de.shevchuk.superhero.model;

import de.shevchuk.superhero.dto.SuperheroWeaponId;
import de.shevchuk.superhero.entity.SuperheroWeapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroWeaponRepository extends CrudRepository<SuperheroWeapon, SuperheroWeaponId> {
}