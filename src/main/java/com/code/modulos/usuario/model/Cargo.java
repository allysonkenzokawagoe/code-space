package com.code.modulos.usuario.model;

import com.code.modulos.usuario.dto.CargoRequest;
import com.code.modulos.usuario.enums.ESituacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CARGO")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARGO")
    @SequenceGenerator(name = "SEQ_CARGO", sequenceName = "SEQ_CARGO", allocationSize = 1)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "SITUACAO")
    private ESituacao situacao;

    @ManyToMany
    @JoinTable(
            name = "CARGO_ROLE",
            schema = "public",
            joinColumns = @JoinColumn(name = "FK_CARGO", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_ROLE", referencedColumnName = "ID"))
    private List<Role> roles;

    public static Cargo of(CargoRequest request) {
        var cargo = new Cargo();
        BeanUtils.copyProperties(request, cargo);
        return cargo;
    }
}
