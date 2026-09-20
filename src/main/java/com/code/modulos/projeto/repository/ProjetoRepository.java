package com.code.modulos.projeto.repository;

import com.code.modulos.projeto.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
}
