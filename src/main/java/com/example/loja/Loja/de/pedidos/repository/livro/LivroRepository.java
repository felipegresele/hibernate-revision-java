package com.example.loja.Loja.de.pedidos.repository.livro;

import com.example.loja.Loja.de.pedidos.model.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
