package com.unaerp.restaurantepi.service;

import com.unaerp.restaurantepi.dao.ProdutoDao;
import com.unaerp.restaurantepi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoDao produtoDao;

    public List<Produto> listarProduto() {
        return produtoDao.findAll();
    }

    public Produto salvarProduto(Produto produto) {
        return produtoDao.save(produto);
    }

    public void deleteProduto(Integer idProduto) {
        produtoDao.deleteById(idProduto);
    }
}
