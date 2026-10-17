package com.code.modulos.usuario.controller;

import com.code.modulos.usuario.dto.CargoRequest;
import com.code.modulos.usuario.service.CargoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/cargo")
public class CargoController {

    private final CargoService service;

    @PostMapping
    public void salvar(@RequestBody @Valid CargoRequest request) {
        service.salvar(request);
    }
}
