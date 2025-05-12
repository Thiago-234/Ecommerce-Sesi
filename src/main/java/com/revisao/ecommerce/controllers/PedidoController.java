package com.revisao.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	@PostMapping(value = "/pedido")
	public ResponseEntity<PedidoDTO> insert(@RequestBody PedidoDTO dto){
		dto = pedidoService.inserir(dto);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(value ="/todos")
    public ResponseEntity<List<Pedido>> listarTodos(){
        return ResponseEntity.ok(pedidoService.listarTodos());
    }
	
	@DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id){
		pedidoService.deletarPedido(id);
        return ResponseEntity.ok("Pedido deletado");
    }
	
	@PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido atualizado ){
        Pedido pedido = pedidoService.atualizarPedido(id, atualizado);
        return ResponseEntity.ok(pedido); 
    }
}

