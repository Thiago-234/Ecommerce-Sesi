package com.revisao.ecommerce.services;

import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.entities.Produto;
import com.revisao.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repo;

    public List<ProdutoDTO> findAll(){
        List<Produto> lista = repo.findAll();
        return lista.stream().map(x-> new ProdutoDTO(x)).toList() ;
    }

    public Page<ProdutoDTO> findPagina(Pageable pagina){
        Page<Produto> busca = repo.findAll(pagina);
        return busca.map(x-> new ProdutoDTO(x));
    }
    
}
