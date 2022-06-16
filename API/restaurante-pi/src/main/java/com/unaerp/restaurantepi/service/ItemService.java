package com.unaerp.restaurantepi.service;

import com.unaerp.restaurantepi.dto.ItemDTO;
import com.unaerp.restaurantepi.model.Item;
import com.unaerp.restaurantepi.model.Pedido;
import com.unaerp.restaurantepi.model.Produto;
import com.unaerp.restaurantepi.dao.ItemDao;
import com.unaerp.restaurantepi.dao.PedidoDao;
import com.unaerp.restaurantepi.dao.ProdutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private PedidoDao pedidoDao;
    @Autowired
    private ProdutoDao produtoDao;

    public List<Item> adicionarItens(Integer idPedido, List<ItemDTO> itensDTO) {
        Optional<Pedido> pedido = pedidoDao.findById(idPedido);

        if (pedido.isEmpty()) {
            return Collections.emptyList();
        }

        return itemDao.saveAll(itensDTO.stream().map(itemDTO -> {
            Optional<Produto> produto = produtoDao.findById(itemDTO.getIdProduto());

            if (produto.isEmpty())
                return null;

            return new Item(pedido.get(), produto.get(), itemDTO.getQuantidade());
        }).collect(Collectors.toList()));
    }

    public List<Item> listarItens(Integer idPedido) {
        Optional<Pedido> pedido = pedidoDao.findById(idPedido);

        if (pedido.isEmpty()) {
            return Collections.emptyList();
        }

        return itemDao.findByPedido(pedido.get());
    }

    public void removeItem(List<Integer> idsItem) {
        itemDao.deleteAllById(idsItem);
    }

    public Item alterarItem(Item item) {
        return itemDao.save(item);
    }
}
