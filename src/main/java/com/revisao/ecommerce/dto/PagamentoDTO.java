package com.revisao.ecommerce.dto;

import java.time.Instant;
import com.revisao.ecommerce.entities.Pagamento;

public class PagamentoDTO {
    private Long id;
    private Instant momento;
    private Long pedidoId;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Long id, Instant momento, Long pedidoId) {
        this.id = id;
        this.momento = momento;
        this.pedidoId = pedidoId;
    }

    public PagamentoDTO(Pagamento entity) {
        this.id = entity.getId();
        this.momento = entity.getMomento();
        this.pedidoId = entity.getPedido().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
}