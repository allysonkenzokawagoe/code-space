package com.code.modulos.comum.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({ValidacaoException.class})
    public ErrorResponse handleValidacaoException(ValidacaoException ex) {
        return new ErrorResponse(HttpStatus.FORBIDDEN.value(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ErrorResponse handleException(NotFoundException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
