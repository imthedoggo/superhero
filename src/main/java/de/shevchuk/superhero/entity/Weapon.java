package de.shevchuk.superhero.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weapon {

    @Id
    private String weapon;
}
