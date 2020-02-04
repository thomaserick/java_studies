package com.tef.cursomc.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tef.cursomc.domain.Categoria;
import com.tef.cursomc.dto.CategoriaDTO;
import com.tef.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaservice;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria categoria = categoriaservice.find(id);
		
		return ResponseEntity.ok().body(categoria);
	}
	
	
	@PostMapping
	//converte para o json para o objeto Java
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO categoriaDTO){
		Categoria categoria = categoriaservice.fromDTO(categoriaDTO);
		categoria = categoriaservice.insert(categoria);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getId()).toUri();		
		return ResponseEntity.created(location).build();		
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id){
	categoria.setId(id);
	categoria = categoriaservice.update(categoria);
	return ResponseEntity.noContent().build();		
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		 categoriaservice.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = categoriaservice.findAll();			
		
		//Converte a lista para ListDto
		List<CategoriaDTO> listDto = list.stream()
				.map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value="page",defaultValue = "0")Integer page, 
			@RequestParam(value="linesPage",defaultValue = "24")Integer linesPage,
			@RequestParam(value="orderBy",defaultValue = "name")String orderBy,
			@RequestParam(value="direction",defaultValue = "ASC")String direction) {		
		
		
		Page<Categoria> list = categoriaservice.findPage(page, linesPage, orderBy, direction);
		//Converte a lista para ListDto
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));				
		return ResponseEntity.ok().body(listDto);
	}
	

}
