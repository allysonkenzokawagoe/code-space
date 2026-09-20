package com.code.modulos.projeto.service;

import com.code.modulos.comum.exceptions.NotFoundException;
import com.code.modulos.projeto.dto.ProjetoRequest;
import com.code.modulos.projeto.dto.ProjetoResponse;
import com.code.modulos.projeto.enums.EProjetoStatus;
import com.code.modulos.projeto.model.Projeto;
import com.code.modulos.projeto.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoResponse cadastrar(ProjetoRequest request){
        var projeto = Projeto.of(request);

        var projetoCadastrado = projetoRepository.save(projeto);

        return ProjetoResponse.of(projetoCadastrado);
    }

    public void editar(Integer id, ProjetoRequest request){

        var projeto = projetoRepository.findById(id).orElseThrow(() -> new NotFoundException("Projeto não encontrado"));
        projeto.setNome(request.nome());
        projeto.setDescricao(request.descricao());
        projeto.setQuantidadeVaga(request.quantidadeVaga());
        projetoRepository.save(projeto);

    }

    public List<ProjetoResponse> listarProjetos(){
       return projetoRepository.findAll().stream().map(ProjetoResponse::of).toList();
    }

    public void emAndamento(Integer id){
        var projeto = projetoRepository.findById(id).orElseThrow(() -> new NotFoundException("Projeto não encontrado"));
        projeto.setEProjetoStatus(EProjetoStatus.EM_ANDAMENTO);
        projetoRepository.save(projeto);
    }

    public void cancelar(Integer id){
        var projeto = projetoRepository.findById(id).orElseThrow(() -> new NotFoundException(("Projeto não localizado")));
        projeto.setEProjetoStatus(EProjetoStatus.CANCELADO);
        projetoRepository.save(projeto);
    }

    public void concluir(Integer id){
        var projeto = projetoRepository.findById(id).orElseThrow(() -> new NotFoundException(("Projeto não localizado")));
        projeto.setEProjetoStatus(EProjetoStatus.CONCLUIDO);
        projetoRepository.save(projeto);
    }
}