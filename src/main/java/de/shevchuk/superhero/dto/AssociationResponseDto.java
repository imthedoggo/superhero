package de.shevchuk.superhero.dto;

import de.shevchuk.superhero.entity.Association;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AssociationResponseDto {

    private String id;

    public static AssociationResponseDto fromEntity(Association entity) {
        return AssociationResponseDto.builder()
            .id(entity.getId())
            .build();
    }
}