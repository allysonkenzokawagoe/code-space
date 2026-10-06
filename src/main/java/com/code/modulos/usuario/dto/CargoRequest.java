package com.code.modulos.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record CargoRequest(
        @NotBlank
        String nome,
        @NotBlank
        String descricao
) {
}
