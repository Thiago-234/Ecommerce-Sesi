package com.revisao.ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoService service;
	

	@GetMapping
	public List<PedidoDTO> findAll(){
		return service.findAll();
	}

	@GetMapping(value = "/pagina")
	public Page<PedidoDTO> findAll(Pageable pagina){
		return service.findPagina(pagina);
	}
	
	
	
	
}

