package com.unaerp.restaurantepi.service;

import com.unaerp.restaurantepi.model.Pedido;
import com.unaerp.restaurantepi.dao.PedidoDao;
import com.unaerp.restaurantepi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    public Pedido gerarPedido(Pedido pedido) {
        return pedidoDao.save(pedido);
    }

    public List<Pedido> listarPedido() {
        return pedidoDao.findAll();
    }
}
