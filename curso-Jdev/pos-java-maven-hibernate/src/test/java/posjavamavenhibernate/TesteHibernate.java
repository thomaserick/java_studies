package posjavamavenhibernate;

import java.util.List;

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

	/*
	 * @Test public void testeDelete() {
	 * 
	 * DaoGeneric<UserPerson> daoGeneric = new DaoGeneric<UserPerson>(); UserPerson
	 * user = daoGeneric.consultarId(1L, UserPerson.class);
	 * 
	 * daoGeneric.delete(user);
	 * 
	 * }
	 */

	/*
	 * @Test public void testeConsultaAll() {
	 * 
	 * DaoGeneric<UserPerson> daoGeneric = new DaoGeneric<UserPerson>();
	 * List<UserPerson> list = daoGeneric.listar(UserPerson.class);
	 * 
	 * for (UserPerson userPerson : list) { System.out.println(userPerson);
	 * System.out.println("--------------------------------------"); }
	 * 
	 * }
	 */

	/*
	 * @Test public void testeQuery() {
	 * 
	 * DaoGeneric<UserPerson> daoGeneric = new DaoGeneric<UserPerson>();
	 * List<UserPerson> list =
	 * daoGeneric.getEntityManager().createQuery("from UserPerson where id = 3")
	 * .getResultList();
	 * 
	 * for (UserPerson userPerson : list) {
	 * 
	 * System.out.println(userPerson);
	 * System.out.println("-------------------------------");
	 * 
	 * }
	 * 
	 * }
	 */

	@Test
	public void testeQueryMaxResult() {

		DaoGeneric<UserPerson> daoGeneric = new DaoGeneric<UserPerson>();
		List<UserPerson> list = daoGeneric.getEntityManager().createQuery(" from UserPerson order by id")
				.setMaxResults(2).getResultList();

		for (UserPerson userPerson : list) {

			System.out.println(userPerson);
			System.out.println("-------------------------------");

		}

	}

}
