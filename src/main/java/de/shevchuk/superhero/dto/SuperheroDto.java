package de.shevchuk.superhero.dto;

import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SuperheroDto {

    @NotNull
    private String alias;
    @NotNull
    private String name;
    @NotNull
    private Set<String> powers;
    @NotNull
    private Set<String> weapons;
    @NotNull
    private String origin;
    @NotNull
    private Set<String> associations;
}
