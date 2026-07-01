package com.example.loja.Loja.de.pedidos.service.livro;

import com.example.loja.Loja.de.pedidos.dto.request.livro.LivroDto;
import com.example.loja.Loja.de.pedidos.model.livro.Livro;
import com.example.loja.Loja.de.pedidos.repository.livro.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> getAll() {
        return this.livroRepository.findAll();
    }

    public Livro getById(Long id) {
        return this.livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro ID: " + id + " não encontrado!"));
    }

    public Livro save(LivroDto dto) {
        Livro livro = new Livro();
        livro.setNome(dto.getNome());
        livro.setAutor(dto.getAutor());
        return this.livroRepository.save(livro);
    }

}
