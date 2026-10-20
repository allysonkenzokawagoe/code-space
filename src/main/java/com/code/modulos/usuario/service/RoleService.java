package com.code.modulos.usuario.service;

import com.code.modulos.comum.exceptions.ValidacaoException;
import com.code.modulos.usuario.dto.RoleRequest;
import com.code.modulos.usuario.model.Role;
import com.code.modulos.usuario.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleRepository repository;

    public void salvar(RoleRequest request) {
        validarRoleExistente(request.nome());
        var role = Role.of(request);
        repository.save(role);
    }

    private void validarRoleExistente(String nome) {
        if (repository.existsByNome(nome)) {
            throw new ValidacaoException("Essa role já existe");
        }
    }
}
