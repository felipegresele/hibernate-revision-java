package com.example.loja.Loja.de.pedidos.controller.usuario;

import com.example.loja.Loja.de.pedidos.model.auth.User;
import com.example.loja.Loja.de.pedidos.repository.auth.UserRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> lista = this.userRepository.findAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(lista);
    }

}
