package com.tef.cursomc.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tef.cursomc.domain.Cliente;
import com.tef.cursomc.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	//Reduz o lock
	@Transactional(readOnly = true)
	Page<Pedido> findByCliente(Cliente cliente,Pageable pageRequest);

}
