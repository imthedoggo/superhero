package de.shevchuk.superhero;

import de.shevchuk.superhero.dto.AssociationDto;
import de.shevchuk.superhero.dto.PowerDto;
import de.shevchuk.superhero.dto.SuperheroDto;
import de.shevchuk.superhero.dto.WeaponDto;
import java.util.Set;

public final class TestConstants {

    public static final WeaponDto WEAPON = new WeaponDto("bite");
    public static final PowerDto POWER = new PowerDto("bark");
    public static final AssociationDto ASSOCIATION = new AssociationDto("avangers");
    public static final SuperheroDto HERO = new SuperheroDto(
        "superdoge", "dog", Set.of(POWER.getId()), Set.of(WEAPON.getId()), "earth", Set.of(ASSOCIATION.getId()));
}