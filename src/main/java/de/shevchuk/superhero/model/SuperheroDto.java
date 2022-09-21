package de.shevchuk.superhero.model;

import de.shevchuk.superhero.Association;
import de.shevchuk.superhero.Power;
import de.shevchuk.superhero.Weapon;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
@AllArgsConstructor
public class SuperheroDto {

    private String alias;
    private String name;
    @Builder.Default
    private Set<Power> powers = new HashSet<>();
    @Builder.Default
    private Set<Weapon> weapons = new HashSet<>();
    private String origin;
    @Builder.Default
    private Set<Association> associations = new HashSet<>();
}
