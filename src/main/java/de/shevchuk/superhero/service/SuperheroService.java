package de.shevchuk.superhero.service;

import de.shevchuk.superhero.entity.Superhero;
import de.shevchuk.superhero.model.SuperheroDto;
import de.shevchuk.superhero.model.SuperheroRepository;
import de.shevchuk.superhero.model.SuperheroResponseDto;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SuperheroService {

    private final SuperheroRepository superheroRepository;

    public SuperheroResponseDto createSuperhero(SuperheroDto superhero) {
        final Superhero entity = Superhero.fromSuperheroDto(superhero);
        final Superhero saved = superheroRepository.save(entity);
        log.info("Superhero has been created!");
        return SuperheroResponseDto.fromEntity(saved);
    }

    public SuperheroResponseDto getSuperhero(long id) {
        final Optional<Superhero> superheroOptional = superheroRepository.findById(id);
        return superheroOptional.map(SuperheroResponseDto::fromEntity).orElse(null);
    }
}
