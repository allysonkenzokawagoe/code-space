package com.code.modulos.autenticacao.dto;

public record LoginRequest(
        String email,
        String senha
) {
}
