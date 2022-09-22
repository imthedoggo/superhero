package de.shevchuk.superhero.entity;

import de.shevchuk.superhero.dto.SuperheroAssociationId;
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
@Table(name = "superhero_association")
@IdClass(SuperheroAssociationId.class)
public class SuperheroAssociation {

    @Id
    private long superheroId;
    @Id
    private String associationId;

    public static SuperheroAssociation fromIds(long superheroId, String associationId) {
        if (superheroId == 0 || associationId == null) {
            return null;
        }
        return SuperheroAssociation.builder()
            .superheroId(superheroId)
            .associationId(associationId)
            .build();
    }
}