package com.code.modulos.usuario.service;

import com.code.modulos.comum.exceptions.ValidacaoException;
import com.code.modulos.usuario.dto.UsuarioRequest;
import com.code.modulos.usuario.enums.EAlteracao;
import com.code.modulos.usuario.model.Usuario;
import com.code.modulos.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioHistoricoService historicoService;

    public void cadastrar(UsuarioRequest request) {
        validarUsuario(request);
        var usuario = Usuario.of(request);
        usuario.setSenha(passwordEncoder.encode(request.senha()));

        var salvo = repository.save(usuario);
        historicoService.salvar(salvo, EAlteracao.CRIACAO);
    }

    private void validarUsuario(UsuarioRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new ValidacaoException("Já existe um usuário cadastrado com este email.");
        }
    }
}
