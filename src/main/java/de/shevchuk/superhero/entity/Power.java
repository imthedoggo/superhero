package de.shevchuk.superhero.entity;

import de.shevchuk.superhero.dto.PowerDto;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "power")
public class Power {

    @Id
    private String id;

    public static Power fromPowerDto(PowerDto dto) {
        if (dto == null) {
            return null;
        }
        return Power.builder()
            .id(dto.getId())
            .build();
    }
}
