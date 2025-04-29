package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.entities.ItemDoPedidoPK;

public class ItemDoPedidoDTO {
	private Integer quantidade;
	private Double preco;
	private ItemDoPedidoPK idItemPedido;
	
	public ItemDoPedidoPK getIdItemPedido() {
		return idItemPedido;
	}


	public ItemDoPedidoDTO(ItemDoPedido entity) {
		this.preco = entity.getPreco();
		this.quantidade = entity.getQuantidade();
		this.idItemPedido = entity.getId();
	}
	
	public ItemDoPedidoDTO() {
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public void setIdItemPedido(ItemDoPedidoPK idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	
	public ItemDoPedidoDTO(Integer quantidade, Double preco) {
		this.quantidade = quantidade;
		this.preco = preco;
	}
}
