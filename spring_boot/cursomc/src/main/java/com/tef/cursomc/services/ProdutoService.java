package com.tef.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tef.cursomc.domain.Categoria;
import com.tef.cursomc.domain.Produto;
import com.tef.cursomc.repositories.CategoriaRepository;
import com.tef.cursomc.repositories.ProdutoRepository;
import com.tef.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));

	}

	
	public Page<Produto> search(String name,List<Integer> ids,Integer page, Integer linesPage, String orderBy, String direction ) {
		PageRequest pageRequest = PageRequest.of( page,linesPage,Direction.valueOf(direction),orderBy);
		
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		
		return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(name, categorias, pageRequest);

	}
	
}
