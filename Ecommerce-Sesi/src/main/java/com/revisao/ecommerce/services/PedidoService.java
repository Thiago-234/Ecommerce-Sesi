package com.revisao.ecommerce.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.StatusDoPedido;
import com.revisao.ecommerce.entities.Usuario;
import com.revisao.ecommerce.repositories.PedidoRepository;
import com.revisao.ecommerce.repositories.UsuarioRepository;

@Service
public class PedidoService {
	
	@Autowired
    PedidoRepository pedidoRepository;
	
	@Autowired
	UsuarioRepository repoUsu;
    
    public PedidoDTO inserir(PedidoDTO dto){    
    	Pedido pedido = new Pedido();
    	pedido.setMomento(Instant.now());
    	pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
    	
    	Usuario user = repoUsu.getReferenceById(dto.getClienteid());
    	
    	pedido.setCliente(user);
    	
		pedido = pedidoRepository.save(pedido);
		
    	return new PedidoDTO(pedido);
    }    
    
    public List<Pedido> listarTodos(){
		return pedidoRepository.findAll();
	}
    
    public String deletarPedido(Long id) {
    	pedidoRepository.deleteById(id);
		return "Pedido deletado!";
	}
    
    public Pedido atualizarPedido(Long id, Pedido atualizado) {
		Pedido pedido = pedidoRepository.findById(id).get();   
		pedido.setCliente(atualizado.getCliente());
		pedido.setMomento(atualizado.getMomento());;
		pedido.setStatus(atualizado.getStatus());
		return pedidoRepository.save(pedido);
	}
}
