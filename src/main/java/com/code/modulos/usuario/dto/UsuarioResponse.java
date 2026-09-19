package com.code.modulos.usuario.dto;

import com.code.modulos.usuario.enums.ECargo;
import com.code.modulos.usuario.model.Usuario;

public record UsuarioResponse(
        Integer id,
        String nome,
        String email,
        ECargo cargo
) {
    public static UsuarioResponse of(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCargo()
        );
    }
}
