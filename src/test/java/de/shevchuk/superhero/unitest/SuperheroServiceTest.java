package de.shevchuk.superhero.unitest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.shevchuk.superhero.dto.SuperheroDto;
import de.shevchuk.superhero.dto.SuperheroResponseDto;
import de.shevchuk.superhero.service.SuperheroService;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SuperheroServiceTest {

    @Autowired
    private SuperheroService superheroService;

    @Test
    public void testSuperheroCreation() {
        final SuperheroDto inputSuperhero = new SuperheroDto("a", "b", Set.of(), Set.of(), "a", Set.of());
        final SuperheroResponseDto savedSuperhero = superheroService.createSuperhero(inputSuperhero);
        assertEquals(inputSuperhero.getAlias(), savedSuperhero.getAlias());
        assertEquals(inputSuperhero.getName(), savedSuperhero.getName());
        assertEquals(inputSuperhero.getPowers(), savedSuperhero.getPowers());
        assertEquals(inputSuperhero.getWeapons(), savedSuperhero.getWeapons());
        assertEquals(inputSuperhero.getOrigin(), savedSuperhero.getOrigin());
        assertEquals(inputSuperhero.getAssociations(), savedSuperhero.getAssociations());
    }

    @Test
    public void testSuperheroFetching() {
        final SuperheroDto inputSuperhero = new SuperheroDto("a", "b", Set.of(), Set.of(), "a", Set.of());
        final SuperheroResponseDto savedSuperhero = superheroService.createSuperhero(inputSuperhero);
        final SuperheroResponseDto fetchedSuperhero = superheroService.getSuperhero(savedSuperhero.getId());
        assertEquals(savedSuperhero.getId(), fetchedSuperhero.getId());
        assertEquals(savedSuperhero.getAlias(), fetchedSuperhero.getAlias());
        assertEquals(savedSuperhero.getName(), fetchedSuperhero.getName());
        assertEquals(savedSuperhero.getPowers(), fetchedSuperhero.getPowers());
        assertEquals(savedSuperhero.getWeapons(), fetchedSuperhero.getWeapons());
        assertEquals(savedSuperhero.getOrigin(), fetchedSuperhero.getOrigin());
        assertEquals(savedSuperhero.getAssociations(), fetchedSuperhero.getAssociations());
    }
}
