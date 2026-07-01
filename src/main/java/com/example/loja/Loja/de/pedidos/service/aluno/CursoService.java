package com.example.loja.Loja.de.pedidos.service.aluno;

import com.example.loja.Loja.de.pedidos.model.aluno.Aluno;
import com.example.loja.Loja.de.pedidos.model.aluno.Curso;
import com.example.loja.Loja.de.pedidos.repository.aluno.AlunoRepository;
import com.example.loja.Loja.de.pedidos.repository.aluno.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CursoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public CursoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public Curso save(Curso cursoSaved) {
        if (cursoSaved.getAlunos() == null || cursoSaved.getAlunos().isEmpty()) throw new RuntimeException("ID aluno invalido");
        List<Aluno> alunosSearch = this.alunoRepository.findAllById(cursoSaved.getAlunos()
            .stream().map(Aluno::getId).filter(Objects::nonNull).toList());
        cursoSaved.setAlunos(alunosSearch);
        return cursoRepository.save(cursoSaved);
    }

    public Curso getById(Long id) {
        return this.cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("ID aluno invalido"));
    }

    public List<Curso> getAll() {
        return this.cursoRepository.findAll();
    }

}
