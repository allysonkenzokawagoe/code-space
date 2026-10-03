package com.code.modulos.autenticacao.service;

import com.code.modulos.usuario.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;

    public String gerarToken(Usuario usuario) {
        var now = Instant.now();

        var claims = JwtClaimsSet.builder()
                .subject(usuario.getUsername())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(36000))
                .claim("authorities", usuario.getAuthorities())
                .claim("cargo", usuario.getCargo())
                .build();

        var jwsHeader = JwsHeader.with(MacAlgorithm.HS256).build();

        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();
    }
}
