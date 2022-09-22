package de.shevchuk.superhero.dto;

import de.shevchuk.superhero.entity.Weapon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class WeaponResponseDto {

    private String id;

    public static WeaponResponseDto fromEntity(Weapon entity) {
        return WeaponResponseDto.builder()
            .id(entity.getId())
            .build();
    }
}