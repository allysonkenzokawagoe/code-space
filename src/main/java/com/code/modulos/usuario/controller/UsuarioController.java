package com.code.modulos.usuario.controller;

import com.code.modulos.usuario.dto.LoginRequest;
import com.code.modulos.usuario.dto.UsuarioRequest;
import com.code.modulos.usuario.dto.UsuarioResponse;
import com.code.modulos.usuario.service.AutenticacaoService;
import com.code.modulos.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private final UsuarioService service;
    private final AutenticacaoService autenticacaoService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid UsuarioRequest request) {
        service.cadastrar(request);
    }

    @GetMapping("{id}")
    public UsuarioResponse buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PutMapping("{id}/ativar")
    public void ativar(@PathVariable Integer id) {
        service.ativar(id);
    }

    @PutMapping("{id}/inativar")
    public void inativar(@PathVariable Integer id) {
        service.inativar(id);
    }

    @PostMapping("login")
    public String login(@RequestBody @Valid LoginRequest request) {
        return autenticacaoService.login(request);
    }
}
