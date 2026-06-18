package com.example.loja.Loja.de.pedidos.controller;

import com.example.loja.Loja.de.pedidos.model.Aluno;
import com.example.loja.Loja.de.pedidos.model.Curso;
import com.example.loja.Loja.de.pedidos.service.AlunoService;
import com.example.loja.Loja.de.pedidos.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAluno() {
        List<Aluno> lista = this.alunoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        Aluno aluno = this.alunoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno requestBody) {
        Aluno aluno = this.alunoService.save(requestBody);
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }
}
