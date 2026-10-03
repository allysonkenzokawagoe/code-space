package com.code.modulos.autenticacao.service;

import com.code.modulos.comum.exceptions.ValidacaoException;
import com.code.modulos.autenticacao.dto.LoginRequest;
import com.code.modulos.usuario.model.Usuario;
import com.code.modulos.autenticacao.dto.UsuarioAutenticado;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AutenticacaoService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    public String login(LoginRequest request) {
        var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customUserDetailsService.loadUserByUsername(request.email()), request.senha()));
        return jwtService.gerarToken((Usuario) auth.getPrincipal());
    }

    public UsuarioAutenticado getUsuarioAutenticado() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof Usuario usuario)) {
            throw new ValidacaoException("Usuário não autenticado");
        }

        return UsuarioAutenticado.of(usuario);
    }
}
