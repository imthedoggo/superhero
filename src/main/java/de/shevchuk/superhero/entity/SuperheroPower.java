package de.shevchuk.superhero.entity;

import de.shevchuk.superhero.dto.SuperheroPowerId;
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
@Table(name = "superhero_power")
@IdClass(SuperheroPowerId.class)
public class SuperheroPower {

    @Id
    private long superheroId;
    @Id
    private String powerId;

    public static SuperheroPower fromIds(long superheroId, String powerId) {
        if (superheroId == 0 || powerId == null) {
            return null;
        }
        return SuperheroPower.builder()
            .superheroId(superheroId)
            .powerId(powerId)
            .build();
    }
}