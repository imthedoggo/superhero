package de.shevchuk.superhero.dto;

import de.shevchuk.superhero.entity.Superhero;
import de.shevchuk.superhero.entity.SuperheroAssociation;
import de.shevchuk.superhero.entity.SuperheroPower;
import de.shevchuk.superhero.entity.SuperheroWeapon;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
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

        final Set<String> weapons = entity.getWeapons().stream()
            .map(SuperheroWeapon::getWeaponId)
            .collect(Collectors.toSet());
        final Set<String> powers = entity.getPowers().stream()
            .map(SuperheroPower::getPowerId)
            .collect(Collectors.toSet());
        final Set<String> associations = entity.getAssociations().stream()
            .map(SuperheroAssociation::getAssociationId)
            .collect(Collectors.toSet());

        return SuperheroResponseDto.builder()
            .id(entity.getId())
            .alias(entity.getAlias())
            .name(entity.getName())
            .origin(entity.getOrigin())
            .weapons(weapons)
            .powers(powers)
            .associations(associations)
            .build();
    }
}
