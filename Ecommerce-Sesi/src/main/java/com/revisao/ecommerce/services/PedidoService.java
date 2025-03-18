package com.revisao.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.repositories.PedidoRepository;
import com.revisao.ecommerce.repositories.UsuarioRepository;

@Service
public class PedidoService {
	
	@Autowired
    PedidoRepository repo;
    
    @Autowired
    UsuarioRepository repoUsu;

    public List<PedidoDTO> findAll(){
        List<Pedido> lista = repo.findAll();
        return lista.stream().map(x-> new PedidoDTO(x)).toList() ;
    }

    public Page<PedidoDTO> findPagina(Pageable pagina){
        Page<Pedido> busca = repo.findAll(pagina);
        return busca.map(x-> new PedidoDTO(x));
    }
    
}
