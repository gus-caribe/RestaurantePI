package com.example.projetorestaurante.modelsParaCarregamento;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Pedido {
    private Integer codigo;
    private Date data;
    private Integer mesaComanda;
    private BigDecimal total;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
