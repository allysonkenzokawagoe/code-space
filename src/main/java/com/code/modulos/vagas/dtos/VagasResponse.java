package com.code.modulos.vagas.dtos;

import com.code.modulos.projeto.model.Projeto;
import com.code.modulos.usuario.enums.ECargo;
import com.code.modulos.vagas.model.Vagas;
import lombok.Builder;

@Builder
public record VagasResponse(
        Integer id,
        ECargo cargo,
        Integer quantidadeVagasCargo,
        Projeto projeto
) {
    public static VagasResponse of(Vagas vagas){
        return VagasResponse.builder()
                .id(vagas.getId())
                .cargo(vagas.getCargo())
                .quantidadeVagasCargo(vagas.getQuantidadeVagasCargo())
                .projeto(vagas.getProjeto())
                .build();
    }
}
