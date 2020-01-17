package posjavamavenhibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UserPerson;

public class TesteHibernate {

	/*
	 * @Test public void testeHibernate() {
	 * 
	 * DaoGeneric<UserPerson> daoGeneric = new DaoGeneric<UserPerson>(); UserPerson
	 * user = new UserPerson();
	 * 
	 * user.setName("Thomas4"); user.setLastname("Oliveira");
	 * user.setEmail("thomas@gmail.com"); user.setLogin("thomas");
	 * user.setPasswd("123"); user.setIdade(30);
	 * 
	 * daoGeneric.salvar(user);
	 * 
	 * }
	 */

	/*
	 * @Test public void testeConsultar() {
	 * 
	 * DaoGeneric<UserPerson> daoGeneric = new DaoGeneric<UserPerson>(); UserPerson
	 * user = new UserPerson(); user.setId(1L);
	 * 
	 * user = daoGeneric.consultar(user);
	 * 
	 * System.out.println(user); }
	 */

	/*
	 * @Test public void testeConsultarId() {
	 * 
	 * DaoGeneric<UserPerson> daoGeneric = new DaoGeneric<UserPerson>();
	 * 
	 * UserPerson user = daoGeneric.consultarId(1L, UserPerson.class);
	 * 
	 * System.out.println(user); }
	 */

	/*
	 * @Test public void testeUpdate() {
	 * 
	 * DaoGeneric<UserPerson> daoGeneric = new DaoGeneric<UserPerson>(); UserPerson
	 * user = daoGeneric.consultarId(3L, UserPerson.class); user.setIdade(24);
	 * 
	 * user = daoGeneric.updateMerge(user);
	 * 
	 * System.out.println(user); }
	 */

	@Test
	public void testeDelete() {

		DaoGeneric<UserPerson> daoGeneric = new DaoGeneric<UserPerson>();
		UserPerson user = daoGeneric.consultarId(1L, UserPerson.class);

		daoGeneric.delete(user);

	}

}
