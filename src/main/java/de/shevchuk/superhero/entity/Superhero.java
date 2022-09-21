package de.shevchuk.superhero.entity;

import de.shevchuk.superhero.model.SuperheroDto;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name = "superhero")
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "superhero_generator")
    @SequenceGenerator(name = "superhero_generator", sequenceName = "superhero_id_seq", allocationSize = 1)
    private long id;

    private String alias;
    private String name;
//    private Set<Power> powers;
//    private Set<Weapon> weapons;
    private String origin;
//    private Set<Association> associations;


    public static Superhero fromSuperheroDto(SuperheroDto dto) {
        if (dto == null) {
            return null;
        }
        return Superhero.builder()
            .alias(dto.getAlias())
            .name(dto.getName())
            .origin(dto.getOrigin())
            .build();
    }
}
