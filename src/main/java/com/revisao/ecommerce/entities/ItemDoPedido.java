package com.revisao.ecommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemDoPedido {

	@EmbeddedId
	private ItemDoPedidoPK id = new ItemDoPedidoPK();

	private Integer quantidade;
	
	public ItemDoPedidoPK getId() {
		return id;
	}

	public void setId(ItemDoPedidoPK id) {
		this.id = id;
	}

	private Double preco;

	public ItemDoPedido() {

	}

	public ItemDoPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
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
	
	public double getSubtotal() {
		return preco * quantidade;
	}
	
	public void setSubtotal(Double preco) {
		this.preco = preco;
	}
}