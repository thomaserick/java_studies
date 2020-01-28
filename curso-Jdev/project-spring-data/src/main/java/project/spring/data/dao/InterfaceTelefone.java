package project.spring.data.dao;

import org.springframework.data.repository.CrudRepository;

import project.spring.data.model.Telefone;

public interface InterfaceTelefone extends CrudRepository<Telefone, Long> {

}
