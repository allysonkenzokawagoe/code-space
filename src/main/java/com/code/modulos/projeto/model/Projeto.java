package com.code.modulos.projeto.model;

import com.code.modulos.projeto.dto.ProjetoRequest;
import com.code.modulos.projeto.enums.EProjetoStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PROJETO")
    @SequenceGenerator(sequenceName = "SEQUENCE_PROJETO", name = "SEQUENCE_PROJETO", allocationSize = 1)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "quantidade_vagas")
    private Integer quantidadeVaga;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EProjetoStatus eProjetoStatus;

    public static Projeto of(ProjetoRequest request){
        return Projeto.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .quantidadeVaga(request.quantidadeVaga())
                .eProjetoStatus(EProjetoStatus.EM_PLANEJAMENTO)
                .build();
    }
}