package com.code.modulos.autenticacao.dto;

import com.code.modulos.usuario.model.Usuario;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioAutenticado {

    private Integer usuarioId;
    private String nome;
    private String email;
    private String cargo;

    public static UsuarioAutenticado of(Usuario usuario) {
        return UsuarioAutenticado.builder()
                .usuarioId(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .cargo(usuario.getCargo().getNome())
                .build();
    }
}
