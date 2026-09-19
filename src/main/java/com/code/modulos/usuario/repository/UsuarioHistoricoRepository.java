package com.code.modulos.usuario.repository;

import com.code.modulos.usuario.model.UsuarioHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioHistoricoRepository extends JpaRepository<UsuarioHistorico, Integer> {
}
