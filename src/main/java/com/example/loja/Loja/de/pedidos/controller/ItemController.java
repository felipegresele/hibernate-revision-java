package com.example.loja.Loja.de.pedidos.controller;

import com.example.loja.Loja.de.pedidos.model.Item;
import com.example.loja.Loja.de.pedidos.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItem() {
        List<Item> lista = this.itemService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = this.itemService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item requestBody) {
        Item item = this.itemService.save(requestBody);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
}
