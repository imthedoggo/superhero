package de.shevchuk.superhero.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SuperheroWeaponId implements Serializable {

    private long superheroId;
    private String weaponId;
}