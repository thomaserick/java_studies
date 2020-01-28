package project.spring.data.dao;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.data.model.UserSpringData;

@Repository
public interface InterfaceSpringData extends CrudRepository<UserSpringData, Long> {

	// ? Parametros
	@Query(value = "select p from UserSpringData p where p.name like %?1%")
	public List<UserSpringData> buscaPorNome(String name);

	@Lock(LockModeType.READ)
	@Query(value = "select p from UserSpringData p where p.name = :paramname")
	public UserSpringData buscaPorNomeParam(@Param("paramname") String paramname);

	@Modifying
	@Transactional
	@Query("delete from UserSpringData d where d.name = ?1")
	public void deletePorNome(String name);

	@Modifying
	@Transactional
	@Query("update UserSpringData u set u.email = ?1 where u.name = ?2")
	public void updateEmailPorNome(String email, String name);

}
