package de.shevchuk.superhero.entity;

import de.shevchuk.superhero.dto.SuperheroWeaponId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "superhero_weapon")
@IdClass(SuperheroWeaponId.class)
public class SuperheroWeapon {

    @Id
    private long superheroId;
    @Id
    private String weaponId;

    public static SuperheroWeapon fromIds(long superheroId, String weaponId) {
        if (superheroId == 0 || weaponId == null) {
            return null;
        }
        return SuperheroWeapon.builder()
            .superheroId(superheroId)
            .weaponId(weaponId)
            .build();
    }
}