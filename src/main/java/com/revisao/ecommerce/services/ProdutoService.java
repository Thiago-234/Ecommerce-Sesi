package com.revisao.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.CategoriaDTO;
import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.entities.Categoria;
import com.revisao.ecommerce.entities.Produto;
import com.revisao.ecommerce.repositories.CategoriaRepository;
import com.revisao.ecommerce.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;
    
    @Autowired
    CategoriaRepository repoCat;

    public List<ProdutoDTO> findAll(){
        List<Produto> lista = produtoRepository.findAll();
        return lista.stream().map(x-> new ProdutoDTO(x)).toList() ;
    }

    public Page<ProdutoDTO> findPagina(Pageable pagina){
        Page<Produto> busca = produtoRepository.findAll(pagina);
        return busca.map(x-> new ProdutoDTO(x));
    }
    
    @Transactional
    public ProdutoDTO insert(ProdutoDTO dto) {
    	Produto entity = new Produto();
    	entity.setNome(dto.getNome());    	
    	entity.setDescricao(dto.getDescricao());    	
    	entity.setPreco(dto.getPreco());    	
    	entity.setImgUrl(dto.getImgUrl());    	
    	
    	for(CategoriaDTO cDto : dto.getCategorias()) {
    		Categoria cat = repoCat.getReferenceById(cDto.getId());
    		entity.getCategorias().add(cat);
    	}
    	
    	entity = produtoRepository.save(entity);
    	return new ProdutoDTO(entity);
    }
    
    public String deletarProduto(Long id) {
		produtoRepository.deleteById(id);
		return "Produto deletado!";
	}
    
    public Produto atualizarProduto(Long id, Produto atualizado) {
    	Produto produto = produtoRepository.findById(id).get();   
		produto.setCategorias(atualizado.getCategorias());
		produto.setDescricao(atualizado.getDescricao());
		produto.setImgUrl(atualizado.getImgUrl());
		produto.setNome(atualizado.getNome());
		produto.setPreco(atualizado.getPreco());
		produto.setItems(atualizado.getItems());
		return produtoRepository.save(produto);
	}
      
}
