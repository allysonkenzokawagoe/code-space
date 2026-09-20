package com.code.modulos.projeto.controller;

import com.code.modulos.projeto.dto.ProjetoRequest;
import com.code.modulos.projeto.dto.ProjetoResponse;
import com.code.modulos.projeto.service.ProjetoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/projeto")
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public void cadastrar(@Valid @RequestBody ProjetoRequest request){
        service.cadastrar(request);
    }

    @GetMapping
    public List<ProjetoResponse> listar(){
        return service.listarProjetos();
    }

    @PutMapping("{id}")
    public void editar( @PathVariable Integer id, @Valid @RequestBody ProjetoRequest request){
        service.editar(id, request);
    }

    @PatchMapping("{id}/em-andamento")
    public void emAndamento(@PathVariable Integer id){
        service.emAndamento(id);
    }

    @PatchMapping("{id}/cancelar")
    public void cancelar(@PathVariable Integer id){
        service.cancelar(id);
    }

    @PatchMapping("{id}/concluir")
    public void concluir(@PathVariable Integer id){
        service.concluir(id);
    }
}