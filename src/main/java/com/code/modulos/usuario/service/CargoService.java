package com.code.modulos.usuario.service;

import com.code.modulos.comum.exceptions.ValidacaoException;
import com.code.modulos.usuario.dto.CargoRequest;
import com.code.modulos.usuario.model.Cargo;
import com.code.modulos.usuario.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CargoService {

    private final CargoRepository repository;

    public void salvar(CargoRequest request) {
        validarCargoExistente(request.nome());
        var cargo = Cargo.of(request);
        repository.save(cargo);
    }

    private void validarCargoExistente(String nome) {
        if (repository.existsByNome(nome)) {
            throw new ValidacaoException("Esse cargo já existe");
        }
    }
}
