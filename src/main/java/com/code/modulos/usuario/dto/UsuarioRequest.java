package com.code.modulos.usuario.dto;

import com.code.modulos.usuario.enums.ECargo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String senha,
        @NotNull
        ECargo cargo
) {
}
