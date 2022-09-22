package de.shevchuk.superhero.entity;

import de.shevchuk.superhero.dto.SuperheroDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "superheroId", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
    CascadeType.REMOVE})
    @Builder.Default
    private List<SuperheroPower> powers = new ArrayList<>();
    @OneToMany(mappedBy = "superheroId", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
    CascadeType.REMOVE})
    @Builder.Default
    private List<SuperheroWeapon> weapons = new ArrayList<>();
    private String origin;
    @OneToMany(mappedBy = "superheroId", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REMOVE})
    @Builder.Default
    private List<SuperheroAssociation> associations = new ArrayList<>();

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