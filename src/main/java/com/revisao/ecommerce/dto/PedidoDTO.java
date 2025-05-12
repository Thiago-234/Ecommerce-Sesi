package com.revisao.ecommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.StatusDoPedido;

public class PedidoDTO {

    private Long id;
    private Instant momento;
    private StatusDoPedido status;
    private Long clienteid;

    private List<ItemDoPedidoDTO> items = new ArrayList<>();

    private PagamentoDTO pagamento;

    public PedidoDTO() {
    }

    public PedidoDTO(Long id, Instant momento, StatusDoPedido status, Long clienteid) {
        this.id = id;
        this.momento = momento;
        this.status = status;
        this.clienteid = clienteid;
    }

    public PedidoDTO(Pedido ped) {
        id = ped.getId();
        momento = ped.getMomento();
        status = ped.getStatus();
        clienteid = ped.getCliente().getId();
        
        if (ped.getPagamento() != null) {
            this.pagamento = new PagamentoDTO(ped.getPagamento());
        }
    }

    // Getters e setters
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

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    public Long getClienteId() {
        return clienteid;
    }

    public void setClienteId(Long clienteId) {
        this.clienteid = clienteId;
    }

    public List<ItemDoPedidoDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDoPedidoDTO> items) {
        this.items = items;
    }

    public PagamentoDTO getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoDTO pagamento) {
        this.pagamento = pagamento;
    }
}