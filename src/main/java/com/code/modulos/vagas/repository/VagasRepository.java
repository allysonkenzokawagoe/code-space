package com.code.modulos.vagas.repository;

import com.code.modulos.vagas.model.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagasRepository extends JpaRepository<Vagas, Integer> {
}