package com.code.modulos.vagas.service;

import com.code.modulos.comum.exceptions.NotFoundException;
import com.code.modulos.projeto.dto.ProjetoRequest;
import com.code.modulos.vagas.dtos.VagasRequest;
import com.code.modulos.vagas.dtos.VagasResponse;
import com.code.modulos.vagas.model.Vagas;
import com.code.modulos.vagas.repository.VagasRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VagasService {

    private final VagasRepository repository;

    public void cadastrar(VagasRequest request){

        var vagas = Vagas.of(request);

        repository.save(vagas);
    }

    public List<VagasResponse> listar(){
        return repository.findAll().stream().map(VagasResponse::of).toList();
    }

}
