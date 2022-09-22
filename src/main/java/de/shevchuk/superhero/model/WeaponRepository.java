package de.shevchuk.superhero.model;

import de.shevchuk.superhero.entity.Weapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, String> {
}