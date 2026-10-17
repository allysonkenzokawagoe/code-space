package com.code.modulos.usuario.model;

import com.code.modulos.usuario.dto.RoleRequest;
import com.code.modulos.usuario.enums.ESituacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROLE")
    @SequenceGenerator(name = "SEQ_ROLE", sequenceName = "SEQ_ROLE", allocationSize = 1)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "SITUACAO")
    private ESituacao situacao;

    public static Role of(RoleRequest request) {
        var role  = new Role();
        BeanUtils.copyProperties(request, role);
        role.setSituacao(ESituacao.ATIVO);
        return role;
    }
}
