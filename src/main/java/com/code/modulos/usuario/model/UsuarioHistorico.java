package com.code.modulos.usuario.model;

import com.code.modulos.usuario.enums.EAlteracao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "USUARIO_HIST")
public class UsuarioHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_HIST")
    @SequenceGenerator(sequenceName = "SEQ_USUARIO_HIST", name = "SEQ_USUARIO_HIST", allocationSize = 1)
    private Integer id;

    @Column(name = "DATA_ALTERACAO")
    private LocalDateTime dataAlteracao;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_ALTERACAO")
    private EAlteracao tipoAlteracao;

    @ManyToOne
    @JoinColumn(name = "FK_USUARIO", foreignKey = @ForeignKey(name = "FK_USUARIO"), nullable = false)
    private Usuario usuario;

    public static UsuarioHistorico of(Usuario usuario, EAlteracao tipoAlteracao) {
        return UsuarioHistorico.builder()
                .dataAlteracao(LocalDateTime.now())
                .tipoAlteracao(tipoAlteracao)
                .usuario(usuario)
                .build();
    }
}
