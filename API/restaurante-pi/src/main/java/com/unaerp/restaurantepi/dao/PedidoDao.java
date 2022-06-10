package com.unaerp.restaurantepi.dao;

import com.unaerp.restaurantepi.model.Item;
import com.unaerp.restaurantepi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoDao extends JpaRepository<Pedido, Integer> {
}
