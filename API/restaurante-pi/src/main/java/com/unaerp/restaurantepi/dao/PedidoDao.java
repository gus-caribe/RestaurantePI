package com.unaerp.restaurantepi.dao;

import com.unaerp.restaurantepi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDao extends JpaRepository<Pedido, Integer> {
}
