package com.example.loja.Loja.de.pedidos.service.pedido;

import com.example.loja.Loja.de.pedidos.model.pedido.Pedido;
import com.example.loja.Loja.de.pedidos.repository.pedido.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido save(Pedido pedido) {
        return this.pedidoRepository.save(pedido);
    }

    public Pedido getById(Long id) {
        return this.pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("ID pedido invalido"));
    }

    public List<Pedido> getAll() {
        return this.pedidoRepository.findAll();
    }

}
