package com.code.modulos.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record RoleRequest(
        @NotBlank
        String nome,
        @NotBlank
        String descricao
) {
}
