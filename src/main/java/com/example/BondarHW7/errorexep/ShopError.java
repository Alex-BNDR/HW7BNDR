package com.example.BondarHW7.errorexep;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ShopError extends RuntimeException {

    public ShopError() {
        super();
    }
}