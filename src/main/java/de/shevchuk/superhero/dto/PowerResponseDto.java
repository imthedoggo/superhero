package de.shevchuk.superhero.dto;

import de.shevchuk.superhero.entity.Power;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PowerResponseDto {

    private String id;

    public static PowerResponseDto fromEntity(Power entity) {
        return PowerResponseDto.builder()
            .id(entity.getId())
            .build();
    }
}