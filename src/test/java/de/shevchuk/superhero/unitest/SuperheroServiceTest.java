package de.shevchuk.superhero.unitest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.shevchuk.superhero.dto.SuperheroDto;
import de.shevchuk.superhero.dto.SuperheroResponseDto;
import de.shevchuk.superhero.exceptions.AssociationNotFoundException;
import de.shevchuk.superhero.exceptions.PowerNotFoundException;
import de.shevchuk.superhero.exceptions.WeaponNotFoundException;
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

    @Test
    public void testSuperheroCreation()
        throws AssociationNotFoundException, PowerNotFoundException, WeaponNotFoundException {
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
    public void testSuperheroFetching()
        throws AssociationNotFoundException, PowerNotFoundException, WeaponNotFoundException {
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