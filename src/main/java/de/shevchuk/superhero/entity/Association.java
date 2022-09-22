package de.shevchuk.superhero.entity;

import de.shevchuk.superhero.dto.AssociationDto;
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
@Table(name = "association")
public class Association {

    @Id
    private String id;

    public static Association fromAssociationDto(AssociationDto dto) {
        if (dto == null) {
            return null;
        }
        return Association.builder()
            .id(dto.getId())
            .build();
    }
}
