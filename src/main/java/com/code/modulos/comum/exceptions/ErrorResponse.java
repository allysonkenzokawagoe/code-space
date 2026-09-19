package com.code.modulos.comum.exceptions;

public record ErrorResponse(
        Integer value,
        String message
) {
}
