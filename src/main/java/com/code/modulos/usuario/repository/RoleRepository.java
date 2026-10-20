package com.code.modulos.usuario.repository;

import com.code.modulos.usuario.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    boolean existsByNome(String nome);
}
