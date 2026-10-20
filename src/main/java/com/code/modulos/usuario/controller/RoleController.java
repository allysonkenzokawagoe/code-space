package com.code.modulos.usuario.controller;

import com.code.modulos.usuario.dto.RoleRequest;
import com.code.modulos.usuario.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/role")
public class RoleController {

    private final RoleService service;

    @PostMapping
    public void save(@RequestBody @Valid RoleRequest request) {
        service.salvar(request);
    }
}
