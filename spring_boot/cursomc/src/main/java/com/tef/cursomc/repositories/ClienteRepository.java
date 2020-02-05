package com.tef.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tef.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	//Ela não necessita como sendo transaçao no BD diminuindo o Lock;
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);
}
