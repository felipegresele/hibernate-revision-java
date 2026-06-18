package com.example.loja.Loja.de.pedidos.controller;

import com.example.loja.Loja.de.pedidos.model.Pedido;
import com.example.loja.Loja.de.pedidos.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedido() {
        List<Pedido> lista = this.pedidoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Pedido pedido = this.pedidoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> savePedido(@RequestBody Pedido requestBody) {
        Pedido pedido = this.pedidoService.save(requestBody);
        return ResponseEntity.status(HttpStatus.OK).body(pedido);
    }
}
