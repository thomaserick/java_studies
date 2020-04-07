package com.tef.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tef.cursomc.domain.Cliente;
import com.tef.cursomc.repositories.ClienteRepository;
import com.tef.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BCryptPasswordEncoder BCrypt;

	@Autowired
	private EmailService emailService;

	private Random rand = new Random();

	public void sendNewPassword(String email) {

		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}

		String newPassword = newPassword();
		cliente.setSenha(BCrypt.encode(newPassword));
		clienteRepository.save(cliente);
		emailService.senNewPasswordEmail(cliente, newPassword);
		

	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}

		return new String(vet);
	}

	//Gera um caracter com numeros e letras
	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // geraum digito // 48 codigo do caracet 0
			return (char) (rand.nextInt(10) + 48);

		} else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		} else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}

}
