package com.example.loja.Loja.de.pedidos.repository.aluno;

import com.example.loja.Loja.de.pedidos.model.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
