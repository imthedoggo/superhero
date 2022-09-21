package de.shevchuk.superhero.controller;

import de.shevchuk.superhero.model.SuperheroDto;
import de.shevchuk.superhero.model.SuperheroResponseDto;
import de.shevchuk.superhero.service.SuperheroService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
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
    public SuperheroResponseDto createSuperhero(@RequestBody SuperheroDto dto) {
        return superheroService.createSuperhero(dto);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SuperheroResponseDto getSuperhero(@PathVariable("id") long id) {
        return superheroService.getSuperhero(id);
    }

//    @PostMapping(value = "/weapons", produces = MediaType.APPLICATION_JSON_VALUE)
//    public void addWeapon(@RequestBody WeaponDto dto) {
//        superheroService.createWeapon(dto);
//    }
}
