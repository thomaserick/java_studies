package com.tef.cursomc.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tef.cursomc.domain.Categoria;
import com.tef.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaservice;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria categoria = categoriaservice.find(id);
		
		return ResponseEntity.ok().body(categoria);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	//converte para o json para o objeto Java
	public ResponseEntity<Void> insert(@RequestBody Categoria categoria){
		categoria = categoriaservice.insert(categoria);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getId()).toUri();		
		return ResponseEntity.created(location).build();		
	}
	
	
	
	

}
