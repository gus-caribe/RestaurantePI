package com.unaerp.restaurantepi.controller;

import com.unaerp.restaurantepi.dto.ItemDTO;
import com.unaerp.restaurantepi.model.Item;
import com.unaerp.restaurantepi.model.Pedido;
import com.unaerp.restaurantepi.model.Produto;
import com.unaerp.restaurantepi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/item/listar/{idPedido}")
    public List<Item> listarProdutos(
            @PathVariable Integer idPedido
    ) {
        return itemService.listarItens(idPedido);
    }

    @PostMapping("/itens/{idPedido}")
    public List<Item> adicionarItens(
            @PathVariable Integer idPedido,
            @RequestBody List<ItemDTO> itensDTO
    ) {
        return itemService.adicionarItens(idPedido, itensDTO);
    }

    @DeleteMapping("/itens")
    public void removeItem(@RequestParam List<Integer> idsItem) {
        itemService.removeItem(idsItem);
    }

    @PatchMapping("/item/alterar")
    public ResponseEntity<Item> alterarItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.alterarItem(item));
    }
}
