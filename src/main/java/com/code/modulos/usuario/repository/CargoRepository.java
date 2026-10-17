package com.code.modulos.usuario.repository;

import com.code.modulos.usuario.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    boolean existsByNome(String nome);
}
