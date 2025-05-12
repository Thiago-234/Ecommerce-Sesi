package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.ItemDoPedido;

public class ItemDoPedidoDTO {
	
	private Integer quantidade;
	private Double preco;
	private Long produtoId;
	private String nome;
	private String urlImg;
	
	public ItemDoPedidoDTO() {
		
	}

	public ItemDoPedidoDTO(Integer quantidade, Double preco, Long produtoId, String nome, String urlImg) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produtoId = produtoId;
		this.nome = nome;
		this.urlImg = urlImg;
	}
	
	public ItemDoPedidoDTO(ItemDoPedido entity) {
		this.quantidade = entity.getQuantidade();
		this.preco = entity.getPreco();
		this.produtoId = entity.getProduto().getId();
		this.nome = entity.getProduto().getNome();
		this.urlImg = entity.getProduto().getImgUrl();
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

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
}
