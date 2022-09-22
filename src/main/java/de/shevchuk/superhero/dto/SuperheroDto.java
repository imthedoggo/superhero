package de.shevchuk.superhero.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SuperheroDto {

    private String alias;
    private String name;
    private Set<String> powers;
    private Set<String> weapons;
    private String origin;
    private Set<String> associations;
}
