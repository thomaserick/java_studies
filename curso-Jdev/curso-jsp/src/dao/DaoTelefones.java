package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.BeanTelefone;
import connection.SingleConnection;

public class DaoTelefones {

	private Connection connection;

	private DaoTelefones() {

		connection = SingleConnection.getConnection();

	}

	/* Salvar/Listar/Deletar */

	public void salvarTelefones(BeanTelefone telefone) {

		String sql = "INSERT INTO telefone (telefone, tipo, userid) values(?, ?, ?)";

		try {
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(1, telefone.getTelefone());
			stm.setString(2, telefone.getTipo());
			stm.setLong(3, telefone.getUserId());
			stm.execute();

			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
