package com.unaerp.restaurantepi.dto;

import com.unaerp.restaurantepi.model.Item;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoDTO {
    private Integer codigo;
    private LocalDateTime data;
    private Integer mesaComanda;
    private BigDecimal total;
    private List<Item> itens;
}
