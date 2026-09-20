package com.code.modulos.projeto.dto;

import com.code.modulos.projeto.enums.EProjetoStatus;
import com.code.modulos.projeto.model.Projeto;
import lombok.Builder;

@Builder
public record ProjetoResponse(
        Integer id,
        String nome,
        String descricao,
        Integer quantidadeVaga,
        EProjetoStatus eProjetoStatus
) {

    public static ProjetoResponse of(Projeto projeto){
        return ProjetoResponse.builder()
                .id(projeto.getId())
                .nome(projeto.getNome())
                .descricao(projeto.getDescricao())
                .quantidadeVaga(projeto.getQuantidadeVaga())
                .eProjetoStatus(projeto.getEProjetoStatus())
                .build();
    }
}