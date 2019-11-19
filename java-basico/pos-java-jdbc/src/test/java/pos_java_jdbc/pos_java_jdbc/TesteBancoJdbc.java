package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import DAO.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {

		UserPosDAO userPosDao = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

//		userposjava.setId(5L);
		userposjava.setNome("Paulo");
		userposjava.setEmail("paulo@gmail.com");

		userPosDao.salvar(userposjava);

	}

	@Test
	public void initListar() {

		UserPosDAO dao = new UserPosDAO();

		try {

			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava); // ToString
				System.out.println("------------------------------");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initBuscar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(5L);
			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {

		try {

			UserPosDAO dao = new UserPosDAO();

			Userposjava obj = dao.buscar(5L);

			obj.setNome("Nome Alterado");

			dao.atualizar(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(8L);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*--------------Telefone --------------------*/

	@Test
	public void initInsertTel() {

		Telefone telefone = new Telefone();
		telefone.setNumero("(14)-981050203");
		telefone.setTipo("Celular");
		telefone.setUsertel(5L);

		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);

	}

	@Test
	public void testeFoneUser() {

		UserPosDAO dao = new UserPosDAO();

		List<BeanUserFone> beanUserFones = dao.listaUserFone(5L);

		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
		}

	}

}
