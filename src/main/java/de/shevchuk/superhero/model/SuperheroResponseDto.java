package de.shevchuk.superhero.model;

import de.shevchuk.superhero.entity.Superhero;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SuperheroResponseDto {

    private long id;
    private String alias;
    private String name;
    @Builder.Default
    private Set<String> powers = new HashSet<>();
    @Builder.Default
    private Set<String> weapons = new HashSet<>();
    private String origin;
    @Builder.Default
    private Set<String> associations = new HashSet<>();

    public static SuperheroResponseDto fromEntity(Superhero entity) {
        return SuperheroResponseDto.builder()
            .id(entity.getId())
            .alias(entity.getAlias())
            .name(entity.getName())
            .origin(entity.getOrigin())
            .build();
    }
}
