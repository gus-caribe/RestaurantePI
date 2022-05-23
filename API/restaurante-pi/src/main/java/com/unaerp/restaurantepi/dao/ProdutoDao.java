package com.unaerp.restaurantepi.dao;

import com.unaerp.restaurantepi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDao extends JpaRepository<Produto, Integer> {
}