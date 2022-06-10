package com.example.projetorestaurante.modelsParaCarregamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    private Integer codigo;
    private LocalDateTime data;
    private Integer mesaComanda;
    private BigDecimal total;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getMesaComanda() {
        return mesaComanda;
    }

    public void setMesaComanda(Integer mesaComanda) {
        this.mesaComanda = mesaComanda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
