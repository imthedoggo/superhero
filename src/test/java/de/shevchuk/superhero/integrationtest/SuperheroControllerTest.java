package de.shevchuk.superhero.integrationtest;

import static de.shevchuk.superhero.TestConstants.ASSOCIATION;
import static de.shevchuk.superhero.TestConstants.HERO;
import static de.shevchuk.superhero.TestConstants.POWER;
import static de.shevchuk.superhero.TestConstants.WEAPON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import de.shevchuk.superhero.dto.AssociationDto;
import de.shevchuk.superhero.dto.PowerDto;
import de.shevchuk.superhero.dto.SuperheroDto;
import de.shevchuk.superhero.dto.WeaponDto;
import de.shevchuk.superhero.model.SuperheroRepository;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class SuperheroControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SuperheroRepository superheroRepository;

    @BeforeEach
    public void resetDb() {
        superheroRepository.deleteAll();
    }

    @Test
    public void testPowerCreation() throws Exception {
        createAndAssertPower(POWER);
    }

    @Test
    public void testWeaponCreation() throws Exception {
        createAndAssertWeapon(WEAPON);
    }

    @Test
    public void testAssociationCreation() throws Exception {
        createAndAssertAssociation(ASSOCIATION);
    }

    @Test
    public void testSuperheroCreation() throws Exception {
        createAndAssertSuperhero(HERO);
    }

    @Test
    public void testFetchSuperhero() throws Exception {
        final int heroId = createAndAssertSuperhero(HERO);

        mvc.perform(get("/v1/super-heroes/" + heroId)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    public int createAndAssertSuperhero(SuperheroDto hero) throws Exception {
        createAndAssertPower(POWER);
        createAndAssertWeapon(WEAPON);
        createAndAssertAssociation(ASSOCIATION);

        final MvcResult createSuperhero = mvc.perform(post("/v1/super-heroes")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hero)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("id").isNotEmpty())
            .andExpect(jsonPath("name").isNotEmpty())
            .andExpect(jsonPath("alias").isNotEmpty())
            .andExpect(jsonPath("powers").isNotEmpty())
            .andExpect(jsonPath("weapons").isNotEmpty())
            .andExpect(jsonPath("origin").isNotEmpty())
            .andExpect(jsonPath("associations").isNotEmpty())
            .andReturn();
        return JsonPath.read(createSuperhero.getResponse().getContentAsString(), "$.id");
    }

    public String createAndAssertPower(PowerDto power) throws Exception {
        final MvcResult createPower = mvc.perform(post("/v1/super-heroes/powers")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(power)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("id").isNotEmpty())
            .andReturn();
        return JsonPath.read(createPower.getResponse().getContentAsString(), "$.id");
    }

    public String createAndAssertWeapon(WeaponDto weapon) throws Exception {
        final MvcResult createWeapon = mvc.perform(post("/v1/super-heroes/weapons")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(weapon)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("id").isNotEmpty())
            .andReturn();
        return JsonPath.read(createWeapon.getResponse().getContentAsString(), "$.id");
    }


    public String createAndAssertAssociation(AssociationDto association) throws Exception {
        final MvcResult createAssociation = mvc.perform(post("/v1/super-heroes/weapons")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(association)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("id").isNotEmpty())
            .andReturn();
        return JsonPath.read(createAssociation.getResponse().getContentAsString(), "$.id");
    }
}