package com.code.modulos.usuario.service;

import com.code.modulos.usuario.enums.EAlteracao;
import com.code.modulos.usuario.model.Usuario;
import com.code.modulos.usuario.model.UsuarioHistorico;
import com.code.modulos.usuario.repository.UsuarioHistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioHistoricoService {

    private final UsuarioHistoricoRepository repository;

    public void salvar(Usuario usuario, EAlteracao tipoAlteracao) {
        var historico = UsuarioHistorico.of(usuario, tipoAlteracao);
        repository.save(historico);
    }
}
