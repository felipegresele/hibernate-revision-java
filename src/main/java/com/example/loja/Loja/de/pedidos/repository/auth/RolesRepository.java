package com.example.loja.Loja.de.pedidos.repository.auth;

import com.example.loja.Loja.de.pedidos.model.auth.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
