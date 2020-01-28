package project.spring.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.data.model.UserSpringData;

@Repository
public interface InterfaceSpringData extends CrudRepository<UserSpringData, Long> {

	// ? Parametro
	@Query(value = "select p from UserSpringData p where p.name like %?1%")
	public List<UserSpringData> buscaPorNome(String name);

	@Query(value = "select p from UserSpringData p where p.name = :paramname")
	public UserSpringData buscaPorNomeParam(@Param("paramname") String paramname);

	@Modifying
	@Transactional
	@Query("delete from UserSpringData d where d.name = ?1")
	public void deletePorNome(String name);

}
