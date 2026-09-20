package com.code.modulos.vagas.model;

import com.code.modulos.projeto.model.Projeto;
import com.code.modulos.usuario.enums.ECargo;
import com.code.modulos.vagas.dtos.VagasRequest;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Vagas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VAGAS")
    @SequenceGenerator(name = "SEQ_VAGAS", allocationSize = 1, sequenceName = "SEQ_VAGAS")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo")
    private ECargo cargo;

    @Column(name = "quantidade_vagas_cargo")
    private Integer quantidadeVagasCargo;

    @ManyToOne
    @JoinColumn(name = "FK_PROJETO", foreignKey = @ForeignKey(name = "FK_PROJETO"), nullable = false)
    private Projeto projeto;

    public static Vagas of(VagasRequest request){
        return Vagas.builder()
                .cargo(request.cargo())
                .quantidadeVagasCargo(request.quantidadeVagasCargo())
                .projeto(request.projeto())
                .build();
    }
}