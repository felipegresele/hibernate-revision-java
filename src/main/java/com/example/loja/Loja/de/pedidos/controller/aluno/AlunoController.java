package com.example.loja.Loja.de.pedidos.controller.aluno;

import com.example.loja.Loja.de.pedidos.model.aluno.Aluno;
import com.example.loja.Loja.de.pedidos.service.aluno.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @ApiResponse(responseCode = "200")
    @Operation(summary = "Endpoint para buscar todos os alunos")
    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAluno() {
        List<Aluno> lista = this.alunoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @ApiResponse(responseCode = "200")
    @Operation(summary = "Endpoint para buscar aluno por Id")
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        Aluno aluno = this.alunoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @ApiResponse(responseCode = "200")
    @Operation(summary = "Endpoint para salvar aluno novo")
    @PostMapping
    public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno requestBody) {
        Aluno aluno = this.alunoService.save(requestBody);
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }
}
