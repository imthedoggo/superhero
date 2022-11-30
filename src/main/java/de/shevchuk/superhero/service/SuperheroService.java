package de.shevchuk.superhero.service;

import de.shevchuk.superhero.dto.AssociationDto;
import de.shevchuk.superhero.dto.AssociationResponseDto;
import de.shevchuk.superhero.dto.PowerDto;
import de.shevchuk.superhero.dto.PowerResponseDto;
import de.shevchuk.superhero.dto.SuperheroDto;
import de.shevchuk.superhero.dto.SuperheroResponseDto;
import de.shevchuk.superhero.dto.WeaponDto;
import de.shevchuk.superhero.dto.WeaponResponseDto;
import de.shevchuk.superhero.entity.Association;
import de.shevchuk.superhero.entity.Power;
import de.shevchuk.superhero.entity.Superhero;
import de.shevchuk.superhero.entity.SuperheroAssociation;
import de.shevchuk.superhero.entity.SuperheroPower;
import de.shevchuk.superhero.entity.SuperheroWeapon;
import de.shevchuk.superhero.entity.Weapon;
import de.shevchuk.superhero.exceptions.AssociationNotFoundException;
import de.shevchuk.superhero.exceptions.PowerNotFoundException;
import de.shevchuk.superhero.exceptions.WeaponNotFoundException;
import de.shevchuk.superhero.model.AssociationRepository;
import de.shevchuk.superhero.model.PowerRepository;
import de.shevchuk.superhero.model.SuperheroAssociationRepository;
import de.shevchuk.superhero.model.SuperheroPowerRepository;
import de.shevchuk.superhero.model.SuperheroRepository;
import de.shevchuk.superhero.model.SuperheroWeaponRepository;
import de.shevchuk.superhero.model.WeaponRepository;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SuperheroService {

    private final SuperheroRepository superheroRepository;
    private final WeaponRepository weaponRepository;
    private final SuperheroWeaponRepository superheroWeaponRepository;
    private final PowerRepository powerRepository;
    private final SuperheroPowerRepository superheroPowerRepository;
    private final AssociationRepository associationRepository;
    private final SuperheroAssociationRepository superheroAssociationRepository;

    public SuperheroResponseDto createSuperhero(SuperheroDto superhero)
        throws WeaponNotFoundException, PowerNotFoundException, AssociationNotFoundException {
        validateAssociations(superhero.getAssociations());
        validatePowers(superhero.getPowers());
        validateWeapons(superhero.getWeapons());

        final Superhero entity = Superhero.fromSuperheroDto(superhero);
        final Superhero superheroSaved = superheroRepository.save(entity);
        log.info("Superhero has been created!");
        saveWeapons(superhero.getWeapons(), superheroSaved);
        savePowers(superhero.getPowers(), superheroSaved);
        saveAssociations(superhero.getAssociations(), superheroSaved);
        return SuperheroResponseDto.fromEntity(superheroSaved);
    }

    public SuperheroResponseDto getSuperhero(long id) {
        final Optional<Superhero> superheroOptional = superheroRepository.findById(id);
        return superheroOptional.map(SuperheroResponseDto::fromEntity).orElse(null);
    }

    public WeaponResponseDto createWeapon(WeaponDto weapon) {
        final Weapon entity = Weapon.fromWeaponDto(weapon);
        final Weapon saved = weaponRepository.save(entity);
        log.info("Weapon has been created!");
        return WeaponResponseDto.fromEntity(saved);
    }

    public AssociationResponseDto createAssociation(AssociationDto dto) {
        final Association entity = Association.fromAssociationDto(dto);
        final Association saved = associationRepository.save(entity);
        log.info("Association has been created!");
        return AssociationResponseDto.fromEntity(saved);
    }

    public PowerResponseDto createPower(PowerDto dto) {
        final Power entity = Power.fromPowerDto(dto);
        final Power saved = powerRepository.save(entity);
        log.info("Power has been created!");
        return PowerResponseDto.fromEntity(saved);
    }

    private void validateAssociations(Set<String> associations) throws AssociationNotFoundException {
        for (String association: associations) {
            associationRepository.findById(association).orElseThrow(() -> new AssociationNotFoundException(String.format("The association %s doesn't exist.", association)));
        }
    }

    private void saveAssociations(Set<String> associations, Superhero superheroSaved) throws AssociationNotFoundException {
        for (String association: associations) {
            final SuperheroAssociation associationSaved = superheroAssociationRepository.save(
                SuperheroAssociation.fromIds(superheroSaved.getId(), association));
            superheroSaved.getAssociations().add(associationSaved);
        }
    }

    private void validatePowers(Set<String> powers) throws PowerNotFoundException {
        for (String power: powers) {
            powerRepository.findById(power).orElseThrow(() -> new PowerNotFoundException(String.format("The power %s doesn't exist.", power)));
        }
    }

    private void savePowers(Set<String> powers, Superhero superheroSaved) throws PowerNotFoundException {
        for (String power: powers) {
            final SuperheroPower powerSaved = superheroPowerRepository.save(
                SuperheroPower.fromIds(superheroSaved.getId(), power));
            superheroSaved.getPowers().add(powerSaved);
        }
    }

    private void validateWeapons(Set<String> weapons) throws WeaponNotFoundException {
        for (String weapon: weapons) {
            weaponRepository.findById(weapon).orElseThrow(() -> new WeaponNotFoundException(String.format("The weapon %s doesn't exist.", weapon)));
        }
    }

    private void saveWeapons(Set<String> weapons, Superhero superheroSaved) throws WeaponNotFoundException {
        for (String weapon: weapons) {
            final SuperheroWeapon weaponSaved = superheroWeaponRepository.save(
                SuperheroWeapon.fromIds(superheroSaved.getId(), weapon));
            superheroSaved.getWeapons().add(weaponSaved);
        }
    }

    public void deleteSuperhero(long id) {
        superheroRepository.deleteById(id);
    }
}