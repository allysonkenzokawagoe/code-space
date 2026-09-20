package com.code.modulos.vagas.dtos;

import com.code.modulos.projeto.model.Projeto;
import com.code.modulos.usuario.enums.ECargo;

public record VagasRequest(
        ECargo cargo,
        Integer quantidadeVagasCargo,
        Projeto projeto) {
}