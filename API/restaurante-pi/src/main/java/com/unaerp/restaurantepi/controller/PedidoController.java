package com.unaerp.restaurantepi.controller;

import com.unaerp.restaurantepi.model.Pedido;
import com.unaerp.restaurantepi.model.Produto;
import com.unaerp.restaurantepi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/pedido/salvar")
    public ResponseEntity<Pedido> gerarPedido(@RequestBody Pedido pedido) {
        System.out.println("Se pah deu certo");
        return ResponseEntity.ok(pedidoService.gerarPedido(pedido));
    }

    @GetMapping("/pedido/listar")
    public List<Pedido> listarPedidos(Integer idPedido) {
        return pedidoService.listarPedido(idPedido);
    }

    @PatchMapping("/pedido/alterar")
    public ResponseEntity<Pedido> alterarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.alterarPedido(pedido));
    }
}
