package de.shevchuk.superhero.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SuperheroPowerId implements Serializable {

    private long superheroId;
    private String powerId;
}