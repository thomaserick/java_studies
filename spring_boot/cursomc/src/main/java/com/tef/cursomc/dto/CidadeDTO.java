package com.tef.cursomc.dto;

import com.tef.cursomc.domain.Cidade;

public class CidadeDTO {
	
	private Integer id;
	private String name;
	
	public CidadeDTO() {	
	}
	
	
	public CidadeDTO(Cidade cidade) {		
		id = cidade.getId();
		name = cidade.getName();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
