package com.code.modulos.projeto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjetoRequest(
        @NotBlank(message = "O campo nome é obrigatório")
         String nome,
        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,
        @NotNull(message = "O campo quantidade vagas é obrigatório")
        Integer quantidadeVaga
) {
}