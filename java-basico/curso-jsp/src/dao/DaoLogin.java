package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {

	/* Objeto do connection */
	private Connection connection;

	public DaoLogin() {

		/* Recebe o objeto de conexão do banco de dados */
		connection = SingleConnection.getConnection();
	}

	public boolean validarLogin(String login, String passwd) throws Exception {

		String sql = "select * from usuario where login ='" + login + "' and passwd = '" + passwd + "'";

		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet resultSet = stm.executeQuery();

		if (resultSet.next()) {
			return true;

		} else {
			return false;
		}

	}

}
