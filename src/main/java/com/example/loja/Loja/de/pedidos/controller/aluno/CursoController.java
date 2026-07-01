package com.example.loja.Loja.de.pedidos.controller.aluno;

import com.example.loja.Loja.de.pedidos.model.aluno.Curso;
import com.example.loja.Loja.de.pedidos.service.aluno.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @ApiResponse(responseCode = "200")
    @Operation(summary = "Endpoint para buscar todos os cursos")
    @GetMapping
    public ResponseEntity<List<Curso>> getAllCurso() {
        List<Curso> lista = this.cursoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @ApiResponse(responseCode = "200")
    @Operation(summary = "Endpoint para buscar curso por Id")
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Curso curso = this.cursoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    @ApiResponse(responseCode = "201")
    @Operation(summary = "Endpoint para salvar curso novo")
    @PostMapping
    public ResponseEntity<Curso> saveCurso(@RequestBody Curso requestBody) {
        Curso curso = this.cursoService.save(requestBody);
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

}
