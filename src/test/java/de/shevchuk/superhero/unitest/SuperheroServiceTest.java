package de.shevchuk.superhero.unitest;

import static de.shevchuk.superhero.Weapon.GENIUS_INTELLIGENCE;
import static org.junit.jupiter.api.Assertions.assertFalse;

import de.shevchuk.superhero.model.SuperheroDto;
import de.shevchuk.superhero.service.SuperheroService;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SuperheroServiceTest {

    @InjectMocks
    private SuperheroService superheroService;

    private final SuperheroDto hero1 = new SuperheroDto("doggo", "dog", Set.of(), Set.of(GENIUS_INTELLIGENCE), "Israel", Set.of());

    @Test
    public void testHeroCreation() {
        superheroService.createSuperhero(hero1);
        assertFalse(superheroService.superheroesMap.isEmpty());
    }
}
