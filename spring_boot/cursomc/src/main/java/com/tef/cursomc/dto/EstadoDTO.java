package com.tef.cursomc.dto;

import java.io.Serializable;

import com.tef.cursomc.domain.Estado;

public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public EstadoDTO() {
	}

	public EstadoDTO(Estado estado) {		
		id = estado.getId();
		name = estado.getName();
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
