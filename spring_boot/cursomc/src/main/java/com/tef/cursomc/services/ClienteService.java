package com.tef.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tef.cursomc.domain.Cliente;
import com.tef.cursomc.repositories.ClienteRepository;
import com.tef.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);		
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
	
		
	}
	

}
