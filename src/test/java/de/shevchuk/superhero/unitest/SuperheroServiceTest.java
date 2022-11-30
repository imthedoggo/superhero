package de.shevchuk.superhero.unitest;

import static de.shevchuk.superhero.TestConstants.HERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.shevchuk.superhero.TestConstants;
import de.shevchuk.superhero.dto.AssociationDto;
import de.shevchuk.superhero.dto.AssociationResponseDto;
import de.shevchuk.superhero.dto.PowerDto;
import de.shevchuk.superhero.dto.PowerResponseDto;
import de.shevchuk.superhero.dto.SuperheroResponseDto;
import de.shevchuk.superhero.dto.WeaponDto;
import de.shevchuk.superhero.dto.WeaponResponseDto;
import de.shevchuk.superhero.entity.Association;
import de.shevchuk.superhero.entity.Power;
import de.shevchuk.superhero.entity.Weapon;
import de.shevchuk.superhero.exceptions.AssociationNotFoundException;
import de.shevchuk.superhero.exceptions.PowerNotFoundException;
import de.shevchuk.superhero.exceptions.WeaponNotFoundException;
import de.shevchuk.superhero.model.AssociationRepository;
import de.shevchuk.superhero.model.PowerRepository;
import de.shevchuk.superhero.model.WeaponRepository;
import de.shevchuk.superhero.service.SuperheroService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SuperheroServiceTest {

    @Autowired
    private SuperheroService superheroService;
    @Autowired
    private PowerRepository powerRepository;
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private AssociationRepository associationRepository;


    @Test
    public void testSuperheroCreation()
        throws AssociationNotFoundException, PowerNotFoundException, WeaponNotFoundException {
        final SuperheroResponseDto savedSuperhero = superheroService.createSuperhero(HERO);
        assertEquals(HERO.getAlias(), savedSuperhero.getAlias());
        assertEquals(HERO.getName(), savedSuperhero.getName());
        assertEquals(HERO.getPowers(), savedSuperhero.getPowers());
        assertEquals(HERO.getWeapons(), savedSuperhero.getWeapons());
        assertEquals(HERO.getOrigin(), savedSuperhero.getOrigin());
        assertEquals(HERO.getAssociations(), savedSuperhero.getAssociations());
    }

    @Test
    @Transactional
    public void testSuperheroFetching()
        throws AssociationNotFoundException, PowerNotFoundException, WeaponNotFoundException {
        final SuperheroResponseDto savedSuperhero = superheroService.createSuperhero(HERO);
        final SuperheroResponseDto fetchedSuperhero = superheroService.getSuperhero(savedSuperhero.getId());
        assertEquals(savedSuperhero.getId(), fetchedSuperhero.getId());
        assertEquals(savedSuperhero.getAlias(), fetchedSuperhero.getAlias());
        assertEquals(savedSuperhero.getName(), fetchedSuperhero.getName());
        assertEquals(savedSuperhero.getOrigin(), fetchedSuperhero.getOrigin());
        assertEquals(savedSuperhero.getPowers(), fetchedSuperhero.getPowers());
        assertEquals(savedSuperhero.getWeapons(), fetchedSuperhero.getWeapons());
        assertEquals(savedSuperhero.getAssociations(), fetchedSuperhero.getAssociations());
    }

    @Test
    void testPowerCreation() {
        PowerResponseDto power = createPower(TestConstants.POWER);
        final Optional<Power> powerOptional = powerRepository.findById(power.getId());

        assertTrue(powerOptional.isPresent());
        assertEquals(power.getId(), powerOptional.get().getId());
    }

    private PowerResponseDto createPower(PowerDto power) {
        return superheroService.createPower(power);
    }

    @Test
    void testWeaponCreation() {
        WeaponResponseDto weapon = createWeapon(TestConstants.WEAPON);
        final Optional<Weapon> weaponOptional = weaponRepository.findById(weapon.getId());

        assertTrue(weaponOptional.isPresent());
        assertEquals(weapon.getId(), weaponOptional.get().getId());
    }

    private WeaponResponseDto createWeapon(WeaponDto weapon) {
        return superheroService.createWeapon(weapon);
    }

    @Test
    void testAssociationCreation() {
        AssociationResponseDto association = createAssociation(TestConstants.ASSOCIATION);
        final Optional<Association> associationOptional = associationRepository.findById(association.getId());

        assertTrue(associationOptional.isPresent());
        assertEquals(association.getId(), associationOptional.get().getId());
    }

    private AssociationResponseDto createAssociation(AssociationDto association) {
        return superheroService.createAssociation(association);
    }
}