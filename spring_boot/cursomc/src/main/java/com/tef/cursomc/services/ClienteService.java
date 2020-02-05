package com.tef.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tef.cursomc.domain.Categoria;
import com.tef.cursomc.domain.Cliente;
import com.tef.cursomc.dto.CategoriaDTO;
import com.tef.cursomc.dto.ClienteDTO;
import com.tef.cursomc.repositories.ClienteRepository;
import com.tef.cursomc.services.exceptions.DataIntegrityException;
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

	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		return clienteRepository.save(cliente);
	}

	public Cliente update(Cliente cliente) {
		Cliente newCliente = find(cliente.getId());
		UpdateData(newCliente,cliente);
		return clienteRepository.save(newCliente);
	}

	public void delete(Integer id) {
		find(id);

		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o cliente que possui pedido");

		}
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPage, String orderBy, String direction ) {
		PageRequest pageRequest = PageRequest.of( page,linesPage,Direction.valueOf(direction),orderBy);
		return clienteRepository.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO clienteDTO) {
		//Não esta feito
		//throw new UnsupportedOperationException();
		return new Cliente(clienteDTO.getId(), clienteDTO.getName(), clienteDTO.getEmail(), null, null);
	}
	
	private void UpdateData(Cliente newCliente, Cliente cliente) {		
		newCliente.setName(cliente.getName());
		newCliente.setEmail(cliente.getEmail());	
	}

}
