package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.Produto;

public record ProdutoDTO(String nome, String descricao, Double preco,String imgUrl) {
	
}
