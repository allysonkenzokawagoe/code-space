package com.code.modulos.usuario.dto;

public record LoginRequest(
        String email,
        String senha
) {
}
