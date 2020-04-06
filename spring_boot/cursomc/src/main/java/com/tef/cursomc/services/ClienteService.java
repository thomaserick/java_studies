package com.tef.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tef.cursomc.domain.Cidade;
import com.tef.cursomc.domain.Cliente;
import com.tef.cursomc.domain.Endereco;
import com.tef.cursomc.domain.enums.Perfil;
import com.tef.cursomc.domain.enums.TipoCliente;
import com.tef.cursomc.dto.ClienteDTO;
import com.tef.cursomc.dto.ClienteEnderecoDTO;
import com.tef.cursomc.repositories.ClienteRepository;
import com.tef.cursomc.repositories.EnderecoRepository;
import com.tef.cursomc.security.UserSS;
import com.tef.cursomc.services.exceptions.AuthorizationException;
import com.tef.cursomc.services.exceptions.DataIntegrityException;
import com.tef.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private BCryptPasswordEncoder bCrypt;

	public Cliente find(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

	}

	@Transactional
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		enderecoRepository.saveAll(cliente.getEnderecos());
		return clienteRepository.save(cliente);
	}

	public Cliente update(Cliente cliente) {
		Cliente newCliente = find(cliente.getId());
		UpdateData(newCliente, cliente);
		return clienteRepository.save(newCliente);
	}

	public void delete(Integer id) {
		find(id);

		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o cliente  poruqe há pedidos relacionados");

		}
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(), clienteDTO.getName(), clienteDTO.getEmail(), null, null, null);
	}

	public Cliente fromDTO(ClienteEnderecoDTO clienteEnderecoDTO) {
		// Não esta feito
		// throw new UnsupportedOperationException();
		Cliente cli = new Cliente(null, clienteEnderecoDTO.getName(), clienteEnderecoDTO.getEmail(),
				clienteEnderecoDTO.getCpfCnpj(), TipoCliente.toEnum(clienteEnderecoDTO.getTipo()),
				bCrypt.encode(clienteEnderecoDTO.getSenha()));
		Cidade cid = new Cidade(clienteEnderecoDTO.getCidadeId(), null, null);
		Endereco end = new Endereco(null, clienteEnderecoDTO.getLogradouro(), clienteEnderecoDTO.getNumend(),
				clienteEnderecoDTO.getComplemento(), clienteEnderecoDTO.getBairro(), clienteEnderecoDTO.getCep(), cli,
				cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(clienteEnderecoDTO.getTelefone1());
		if (clienteEnderecoDTO.getTelefone2() != null) {
			cli.getTelefones().add(clienteEnderecoDTO.getTelefone2());
		}

		return cli;

	}

	private void UpdateData(Cliente newCliente, Cliente cliente) {
		newCliente.setName(cliente.getName());
		newCliente.setEmail(cliente.getEmail());
	}

}
