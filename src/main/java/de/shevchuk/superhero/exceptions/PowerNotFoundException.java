package de.shevchuk.superhero.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PowerNotFoundException extends Exception{
    public PowerNotFoundException(String message){
        super(message);
    }
}