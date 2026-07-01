package com.example.loja.Loja.de.pedidos.controller.livro;

import com.example.loja.Loja.de.pedidos.dto.request.livro.LivroDto;
import com.example.loja.Loja.de.pedidos.model.livro.Livro;
import com.example.loja.Loja.de.pedidos.service.livro.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivro() {
        List<Livro> lista = this.livroService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
        Livro livro = this.livroService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @PostMapping
    public ResponseEntity<Livro> saveLivro(@RequestBody LivroDto requestBody) {
        Livro livro = this.livroService.save(requestBody);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

}
