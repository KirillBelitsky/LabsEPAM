package com.errorPages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestError extends RuntimeException {

    public BadRequestError(){
        super("You wrote the wrong datas!");
    }
}