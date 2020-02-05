package com.tef.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tef.cursomc.domain.Produto;
import com.tef.cursomc.dto.ProdutoDTO;
import com.tef.cursomc.resources.utils.URL;
import com.tef.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {			
		Produto produto = produtoService.find(id);
		return ResponseEntity.ok().body(produto);			
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "categorias", defaultValue = "") String categorias,
			@RequestParam(value = "linesPage", defaultValue = "24") Integer linesPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
	
		Page<Produto> list = produtoService.search(URL.decodeParam(name), URL.decodeIntList(categorias), page, linesPage, orderBy, direction);
				
		// Converte a lista para ListDto
		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
