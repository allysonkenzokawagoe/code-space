package com.code.modulos.usuario.service;

import com.code.modulos.comum.exceptions.NotFoundException;
import com.code.modulos.comum.exceptions.ValidacaoException;
import com.code.modulos.usuario.dto.UsuarioRequest;
import com.code.modulos.usuario.dto.UsuarioResponse;
import com.code.modulos.usuario.enums.EAlteracao;
import com.code.modulos.usuario.enums.ESituacao;
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
        usuario.setarDadosCadastro(passwordEncoder.encode(request.senha()));

        var salvo = repository.save(usuario);
        historicoService.salvar(salvo, EAlteracao.CRIACAO);
    }

    public UsuarioResponse buscarPorId(Integer id) {
        return UsuarioResponse.of(getById(id));
    }

    public Usuario getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    public void ativar(Integer id) {
        var usuario = getById(id);
        validarSituacao(usuario, ESituacao.ATIVO);
        repository.save(usuario);
        historicoService.salvar(usuario, EAlteracao.ATIVACAO);
    }

    public void inativar(Integer id) {
        var usuario = getById(id);
        validarSituacao(usuario, ESituacao.INATIVO);
        repository.save(usuario);
        historicoService.salvar(usuario, EAlteracao.INATIVACAO);
    }

    private void validarUsuario(UsuarioRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new ValidacaoException("Já existe um usuário cadastrado com este email.");
        }
    }

    private void validarSituacao(Usuario usuario, ESituacao situacao) {
        if (usuario.getSituacao() == situacao) {
            throw new ValidacaoException("Usuário ja está com a situação " + situacao.name());
        }
        usuario.setSituacao(situacao);
    }
}
