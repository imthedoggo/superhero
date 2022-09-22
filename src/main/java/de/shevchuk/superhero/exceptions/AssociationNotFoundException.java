package de.shevchuk.superhero.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssociationNotFoundException extends Exception{
    public AssociationNotFoundException(String message){
        super(message);
    }
}