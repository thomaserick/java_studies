package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanTelefone;
import connection.SingleConnection;

public class DaoTelefones {

	private Connection connection;

	public DaoTelefones() {

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

	/* Listar */

	public List<BeanTelefone> listar(Long userId) throws Exception {
		/* Lista de Objetos */
		List<BeanTelefone> listar = new ArrayList<BeanTelefone>();

		String sql = "SELECT * FROM telefone where userid = " + userId;

		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();

		while (result.next()) {

			BeanTelefone telefones = new BeanTelefone();

			telefones.setId(result.getLong("id"));
			telefones.setTelefone(result.getString("telefone"));
			telefones.setTipo(result.getString("tipo"));
			telefones.setUserId(result.getLong("userid"));

			listar.add(telefones);

		}
		return listar;

	}

	public void delete(Long id) {

		try {
			String sql = "DELETE FROM telefone where id=" + id;
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.execute();

			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public boolean validarTelefone(String telefone) throws Exception {

		String sql = "SELECT COUNT(1) AS qtd_fone from telefone where telefone = '" + telefone + "'";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();

		if (result.next()) {

			return result.getInt("qtd_fone") <= 0;

		}

		return false;
	}
}