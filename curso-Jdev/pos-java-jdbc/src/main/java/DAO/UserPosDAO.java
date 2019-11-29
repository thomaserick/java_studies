package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class UserPosDAO {

	private Connection connection;

	public UserPosDAO() {

		connection = SingleConnection.getConnection();

	}

	public void salvar(Userposjava userposjava) {

		try {

			String sql = "insert into userposjava(nome, email) values (?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
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

	// Update
	public void atualizar(Userposjava userposjava) {

		try {

			String sql = "update userposjava set nome = ? where id =" + userposjava.getId();

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, userposjava.getNome());
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

	public void deletar(Long id) {

		try {

			String sql = "delete from userposjava where id=" + id;
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
	}

	/*----------------------------------------------*/
	public void salvarTelefone(Telefone telefone) {

		try {

			String sql = "INSERT INTO telefoneuser (numero, tipo, usuariopessoa) values (?, ?, ?)";
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(1, telefone.getNumero());
			stm.setString(2, telefone.getTipo());
			stm.setLong(3, telefone.getUsertel());

			stm.execute();

			connection.commit();

			stm.execute();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public List<BeanUserFone> listaUserFone(Long id) {

		List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();

		String sql = "select nome, numero, email from telefoneuser f ";
		sql += "inner join userposjava u ";
		sql += "on f.usuariopessoa = u.id where u.id = " + id;

		try {

			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet result = stm.executeQuery();

			while (result.next()) {

				BeanUserFone userFone = new BeanUserFone();
				userFone.setNome(result.getString("nome"));
				userFone.setEmail(result.getString("email"));
				userFone.setNumero(result.getString("numero"));

				beanUserFones.add(userFone);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return beanUserFones;

	}

	public void deleteUserTel(Long idUser) {

		try {

			String sqlFone = "delete from telefoneuser where usuariopessoa=" + idUser;
			String sqlUser = "Delete from userposjava where id= " + idUser;

			PreparedStatement stm = connection.prepareStatement(sqlFone);
			stm.executeUpdate();
			connection.commit();

			PreparedStatement stm1 = connection.prepareStatement(sqlUser);
			stm1.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public void deletarTel(Long id) {

		try {

			String sql = "delete from telefoneuser where id=" + id;
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

}