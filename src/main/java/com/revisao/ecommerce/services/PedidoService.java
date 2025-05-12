package com.revisao.ecommerce.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.ItemDoPedidoDTO;
import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.entities.Pagamento;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.Produto;
import com.revisao.ecommerce.entities.StatusDoPedido;
import com.revisao.ecommerce.entities.Usuario;
import com.revisao.ecommerce.repositories.ItemDoPedidoRepository;
import com.revisao.ecommerce.repositories.PagamentoRepository;
import com.revisao.ecommerce.repositories.PedidoRepository;
import com.revisao.ecommerce.repositories.ProdutoRepository;
import com.revisao.ecommerce.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {
    
    @Autowired
    PedidoRepository pedidoRepository;
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    ProdutoRepository produtoRepository;
    
    @Autowired
    ItemDoPedidoRepository itemDoPedidoRepository;
    
    @Autowired
    PagamentoRepository pagamentoRepository;

    @Transactional
    public PedidoDTO inserir(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setMomento(Instant.now());
        pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
        
        Usuario cliente = usuarioRepository.getReferenceById(dto.getClienteId());
        pedido.setCliente(cliente);
        
        for (ItemDoPedidoDTO itemDto : dto.getItems()) {
            Produto produto = produtoRepository.getReferenceById(itemDto.getProdutoId());
            ItemDoPedido item = new ItemDoPedido(pedido, produto, itemDto.getQuantidade(), itemDto.getPreco());
            pedido.getItems().add(item);
        }
        
        pedido = pedidoRepository.save(pedido);
        itemDoPedidoRepository.saveAll(new ArrayList<>(pedido.getItems()));
        
        return new PedidoDTO(pedido);
    }

    @Transactional
    public PedidoDTO inserirPagamento(Long pedidoId, Pagamento pagamentoDto) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElse(null);

        if (pedido == null) {
            return null; // Pedido não encontrado
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setMomento(pagamentoDto.getMomento());
        pagamento.setPedido(pedido);

        pagamentoRepository.save(pagamento);

        pedido.setPagamento(pagamento);
        pedido.setStatus(StatusDoPedido.PAGO);

        pedidoRepository.save(pedido);

        return new PedidoDTO(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    
    public String deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
        return "Pedido deletado!";
    }
    
    public Pedido atualizarPedido(Long id, Pedido atualizado) {
        Pedido pedido = pedidoRepository.findById(id).get();   
        pedido.setCliente(atualizado.getCliente());
        pedido.setMomento(atualizado.getMomento());
        pedido.setStatus(atualizado.getStatus());
        return pedidoRepository.save(pedido);
    }
}
