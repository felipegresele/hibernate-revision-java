package com.example.loja.Loja.de.pedidos.controller;

import com.example.loja.Loja.de.pedidos.model.Curso;
import com.example.loja.Loja.de.pedidos.model.Item;
import com.example.loja.Loja.de.pedidos.service.CursoService;
import com.example.loja.Loja.de.pedidos.service.ItemService;
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

    @GetMapping
    public ResponseEntity<List<Curso>> getAllCurso() {
        List<Curso> lista = this.cursoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Curso curso = this.cursoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> saveCurso(@RequestBody Curso requestBody) {
        Curso curso = this.cursoService.save(requestBody);
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

}
