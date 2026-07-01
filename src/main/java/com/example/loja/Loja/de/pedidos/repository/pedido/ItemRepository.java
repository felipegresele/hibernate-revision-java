package com.example.loja.Loja.de.pedidos.repository.pedido;

import com.example.loja.Loja.de.pedidos.model.pedido.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
