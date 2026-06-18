package com.example.loja.Loja.de.pedidos.service;

import com.example.loja.Loja.de.pedidos.model.Aluno;
import com.example.loja.Loja.de.pedidos.model.Curso;
import com.example.loja.Loja.de.pedidos.model.Item;
import com.example.loja.Loja.de.pedidos.model.Pedido;
import com.example.loja.Loja.de.pedidos.repository.AlunoRepository;
import com.example.loja.Loja.de.pedidos.repository.CursoRepository;
import com.example.loja.Loja.de.pedidos.repository.ItemRepository;
import com.example.loja.Loja.de.pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public Aluno save(Aluno alunoSaved) {
        if (alunoSaved.getCursos() == null || alunoSaved.getCursos().isEmpty()) throw new RuntimeException("ID curso invalido");
        List<Curso> cursosSearch = this.cursoRepository.findAllById(alunoSaved.getCursos()
            .stream().map(Curso::getId).filter(Objects::nonNull).toList());
        alunoSaved.setCursos(cursosSearch);
        return alunoRepository.save(alunoSaved);
    }

    public Aluno getById(Long id) {
        return this.alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("ID aluno invalido"));
    }

    public List<Aluno> getAll() {
        return this.alunoRepository.findAll();
    }

}
