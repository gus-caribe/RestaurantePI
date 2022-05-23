package com.unaerp.restaurantepi.controller;

import com.unaerp.restaurantepi.model.Produto;
import com.unaerp.restaurantepi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produto/listar")
    public List<Produto> listarProdutos() {
        List<Produto> test = produtoService.listarProduto();
        return test;
    }

    @PostMapping("/produto/salvar")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvarProduto(produto));
    }
}