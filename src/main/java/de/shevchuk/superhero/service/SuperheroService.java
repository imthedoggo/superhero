package de.shevchuk.superhero.service;

import de.shevchuk.superhero.model.SuperheroDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuperheroService {

    public Map<String, SuperheroDto> superheroesMap = new HashMap<>();
    public List<SuperheroDto> superheroes;

    public void createSuperhero(SuperheroDto superhero) {
        superheroesMap.put(superhero.getAlias(), superhero);
    }

    public SuperheroDto getSuperhero(String alias) {
        final SuperheroDto superheroDto = superheroesMap.get(alias);
        return superheroDto;
    }
}
