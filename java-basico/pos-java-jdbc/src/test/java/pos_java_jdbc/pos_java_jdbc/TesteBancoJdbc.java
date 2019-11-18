package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import DAO.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {

		UserPosDAO userPosDao = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setId(5L);
		userposjava.setNome("Paulo");
		userposjava.setEmail("paulo@gmail.com");

		userPosDao.salvar(userposjava);

	}

}
