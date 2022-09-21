package de.shevchuk.superhero.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Association {

    @Id
    private String association;
}
