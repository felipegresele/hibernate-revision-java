package com.example.loja.Loja.de.pedidos.repository;

import com.example.loja.Loja.de.pedidos.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
