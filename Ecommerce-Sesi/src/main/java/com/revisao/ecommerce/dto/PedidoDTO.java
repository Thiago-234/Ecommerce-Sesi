package com.revisao.ecommerce.dto;

import java.time.Instant;

import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.StatusDoPedido;

public class PedidoDTO {
	
	private Long id;
	private Instant momento;
	private StatusDoPedido status;
	private Long clienteid;
	
	public PedidoDTO() {
		
	}
	
	public PedidoDTO(Long id, Instant momento, StatusDoPedido status, Long clienteid) {
		this.id = id;
		this.momento = momento;
		this.status = status;
		this.clienteid = clienteid;
	}	
	
	public PedidoDTO(Pedido ped){
		id = ped.getId();
		momento = ped.getMomento();
		status = ped.getStatus();
		clienteid = ped.getCliente().getId();	
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

	public StatusDoPedido getStatus() {
		return status;
	}

	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}

	public Long getClienteid() {
		return clienteid;
	}

	public void setClienteid(Long clienteid) {
		this.clienteid = clienteid;
	}
}
