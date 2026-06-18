package com.example.loja.Loja.de.pedidos.repository;

import com.example.loja.Loja.de.pedidos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
