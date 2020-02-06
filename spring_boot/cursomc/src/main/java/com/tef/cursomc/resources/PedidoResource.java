package com.tef.cursomc.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tef.cursomc.domain.Categoria;
import com.tef.cursomc.domain.Pedido;
import com.tef.cursomc.dto.CategoriaDTO;
import com.tef.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {		
	
		Pedido pedido = pedidoService.find(id);
		return ResponseEntity.ok().body(pedido);	
		
	}
	
	@PostMapping
	// converte para o json para o objeto Java
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {	
		obj = pedidoService.insert(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
