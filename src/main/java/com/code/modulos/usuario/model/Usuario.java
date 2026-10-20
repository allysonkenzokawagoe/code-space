package com.code.modulos.usuario.model;

import com.code.modulos.usuario.dto.UsuarioRequest;
import com.code.modulos.usuario.enums.ESituacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario implements UserDetails {

    @Id
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "SITUACAO")
    private ESituacao situacao;

    @ManyToOne
    @JoinColumn(name = "FK_CARGO", foreignKey = @ForeignKey(name = "FK_CARGO"), referencedColumnName = "id")
    private Cargo cargo;

    public static Usuario of(UsuarioRequest request) {
        return Usuario.builder()
                .nome(request.nome())
                .email(request.email())
                .build();
    }

    public void setarDadosCadastro(String senha, Cargo cargo) {
        this.senha = senha;
        this.situacao = ESituacao.ATIVO;
        this.cargo = cargo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return cargo.getRoles().stream().map(Role::getNome).map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
