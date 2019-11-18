package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {

	private Connection connection;

	public UserPosDAO() {

		connection = SingleConnection.getConnection();

	}

	public void salvar(Userposjava userposjava) {

		try {

			String sql = "insert into userposjava(id, nome, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute();

			connection.commit();

		} catch (Exception e) {

			try {
				connection.rollback(); // Volta operação
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	// Lista
	public List<Userposjava> listar() throws Exception {

		// Estancia a Lista
		List<Userposjava> list = new ArrayList<Userposjava>();

		// Monta o SQL
		String sql = "Select * from userposjava";

		// Prepara o SQL
		PreparedStatement statement = connection.prepareStatement(sql);

		// Executa no BD
		ResultSet result = statement.executeQuery();

		// Quando tiver dados True carrega novos objetos e add na lista
		while (result.next()) {
			Userposjava userposjava = new Userposjava();

			userposjava.setId(result.getLong("id"));
			userposjava.setNome(result.getString("nome"));
			userposjava.setEmail(result.getString("email"));

			list.add(userposjava);

		}

		// Retorna Lista
		return list;

	}

	// Lista
	public Userposjava buscar(Long id) throws Exception {

		// Estancia a Lista
		Userposjava retorno = new Userposjava();

		// Monta o SQL
		String sql = "Select * from userposjava where id = " + id;

		// Prepara o SQL
		PreparedStatement statement = connection.prepareStatement(sql);

		// Executa no BD
		ResultSet result = statement.executeQuery();

		// Quando tiver dados True carrega novos objetos e add na lista
		while (result.next()) {

			retorno.setId(result.getLong("id"));
			retorno.setNome(result.getString("nome"));
			retorno.setEmail(result.getString("email"));
		}

		// Retorna Lista
		return retorno;

	}

}