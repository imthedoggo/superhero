package de.shevchuk.superhero.entity;

import de.shevchuk.superhero.dto.WeaponDto;
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
@Table(name = "weapon")
public class Weapon {

    @Id
    private String id;

    public static Weapon fromWeaponDto(WeaponDto dto) {
        if (dto == null) {
            return null;
        }
        return Weapon.builder()
            .id(dto.getId())
            .build();
    }
}
