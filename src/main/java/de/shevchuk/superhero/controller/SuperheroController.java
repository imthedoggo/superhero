package de.shevchuk.superhero.controller;

import de.shevchuk.superhero.dto.AssociationDto;
import de.shevchuk.superhero.dto.AssociationResponseDto;
import de.shevchuk.superhero.dto.PowerDto;
import de.shevchuk.superhero.dto.PowerResponseDto;
import de.shevchuk.superhero.dto.SuperheroDto;
import de.shevchuk.superhero.dto.SuperheroResponseDto;
import de.shevchuk.superhero.dto.WeaponDto;
import de.shevchuk.superhero.dto.WeaponResponseDto;
import de.shevchuk.superhero.exceptions.AssociationNotFoundException;
import de.shevchuk.superhero.exceptions.PowerNotFoundException;
import de.shevchuk.superhero.exceptions.WeaponNotFoundException;
import de.shevchuk.superhero.service.SuperheroService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/super-heroes")
public class SuperheroController {

    private final SuperheroService superheroService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SuperheroResponseDto createSuperhero(@Valid @RequestBody SuperheroDto dto)
        throws WeaponNotFoundException, AssociationNotFoundException, PowerNotFoundException {
        return superheroService.createSuperhero(dto);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SuperheroResponseDto getSuperhero(@PathVariable("id") long id) {
        return superheroService.getSuperhero(id);
    }

    @PostMapping(value = "/weapons", produces = MediaType.APPLICATION_JSON_VALUE)
    public WeaponResponseDto createWeapon(@RequestBody WeaponDto dto) {
        return superheroService.createWeapon(dto);
    }

    @PostMapping(value = "/associations", produces = MediaType.APPLICATION_JSON_VALUE)
    public AssociationResponseDto createAssociation(@RequestBody AssociationDto dto) {
        return superheroService.createAssociation(dto);
    }

    @PostMapping(value = "/powers", produces = MediaType.APPLICATION_JSON_VALUE)
    public PowerResponseDto createPower(@RequestBody PowerDto dto) {
        return superheroService.createPower(dto);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSuperhero(@PathVariable("id") long id) {
        superheroService.deleteSuperhero(id);
    }
}
