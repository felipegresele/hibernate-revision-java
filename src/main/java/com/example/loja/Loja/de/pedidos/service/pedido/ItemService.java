package com.example.loja.Loja.de.pedidos.service.pedido;

import com.example.loja.Loja.de.pedidos.model.pedido.Item;
import com.example.loja.Loja.de.pedidos.model.pedido.Pedido;
import com.example.loja.Loja.de.pedidos.repository.pedido.ItemRepository;
import com.example.loja.Loja.de.pedidos.repository.pedido.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final PedidoRepository pedidoRepository;

    public ItemService(ItemRepository itemRepository, PedidoRepository pedidoRepository) {
        this.itemRepository = itemRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Item save(Item itemSaved) {
        if (itemSaved.getPedido() == null || itemSaved.getPedido().getId() == null) throw new RuntimeException("ID pedido invalido");
        Pedido pedidoSearch = this.pedidoRepository.findById(itemSaved.getPedido().getId()).orElseThrow(() -> new RuntimeException("ID pedido invalido"));
        itemSaved.setPedido(pedidoSearch);
        return itemRepository.save(itemSaved);
    }

    public Item getById(Long id) {
        return this.itemRepository.findById(id).orElseThrow(() -> new RuntimeException("ID item invalido"));
    }

    public List<Item> getAll() {
        return this.itemRepository.findAll();
    }

}
