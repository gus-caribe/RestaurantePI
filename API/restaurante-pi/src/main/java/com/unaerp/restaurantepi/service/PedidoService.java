package com.unaerp.restaurantepi.service;

import com.unaerp.restaurantepi.model.Pedido;
import com.unaerp.restaurantepi.dao.PedidoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoDao pedidoRespository;

    public Pedido gerarPedido(Pedido pedido) {
        return pedidoRespository.save(pedido);
    }
}
