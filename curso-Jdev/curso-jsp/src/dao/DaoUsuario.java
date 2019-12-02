package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {

		connection = SingleConnection.getConnection();

	}

	public void salvarUsuario(BeanCursoJsp usuario) {
		String sql = "insert into usuario (login, passwd, username, fone, cep, endereco, endnum, bairro, cidade, uf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getPasswd());
			stm.setString(3, usuario.getUser());
			stm.setString(4, usuario.getFone());
			stm.setString(5, usuario.getCep());
			stm.setString(6, usuario.getEndereco());
			stm.setString(7, usuario.getEndNum());
			stm.setString(8, usuario.getBairro());
			stm.setString(9, usuario.getCidade());
			stm.setString(10, usuario.getUf());

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

	public List<BeanCursoJsp> listar() throws Exception {

		/* Lista de Objetos */
		List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp>();

		String sql = "select * from usuario";

		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();

		while (result.next()) {

			BeanCursoJsp usuario = new BeanCursoJsp();

			usuario.setId(result.getLong("id"));
			usuario.setLogin(result.getString("login"));
			usuario.setPasswd(result.getString("passwd"));
			usuario.setUser(result.getString("username"));
			usuario.setFone(result.getString("fone"));
			usuario.setCep(result.getString("cep"));
			usuario.setEndereco(result.getString("endereco"));
			usuario.setEndNum(result.getString("endnum"));
			usuario.setCidade(result.getString("cidade"));
			usuario.setBairro(result.getString("bairro"));
			usuario.setUf(result.getString("uf"));

			listar.add(usuario);
		}

		return listar;

	}

	public void deleteUser(Long id) {

		try {

			String sql = "delete from usuario where id=" + id;
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

	public BeanCursoJsp consultar(Long id) throws Exception {

		String sql = "select * from usuario where id = " + id;
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();

		if (result.next()) {

			BeanCursoJsp usuario = new BeanCursoJsp();

			usuario.setId(result.getLong("id"));
			usuario.setLogin(result.getString("login"));
			usuario.setPasswd(result.getString("passwd"));
			usuario.setUser(result.getString("username"));
			usuario.setFone(result.getString("fone"));
			usuario.setCep(result.getString("cep"));
			usuario.setEndereco(result.getString("endereco"));
			usuario.setEndNum(result.getString("endnum"));
			usuario.setCidade(result.getString("cidade"));
			usuario.setBairro(result.getString("bairro"));
			usuario.setUf(result.getString("uf"));

			return usuario;

		}
		return null;

	}

	public void atualizarUser(BeanCursoJsp usuario) {

		try {
			String sql = "update usuario set login = ?, passwd = ?, username = ? , fone = ?, cep = ?, endereco = ?, endnum = ?, bairro = ?, cidade = ?, uf = ? where id="
					+ usuario.getId();
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getPasswd());
			stm.setString(3, usuario.getUser());
			stm.setString(4, usuario.getFone());
			stm.setString(5, usuario.getCep());
			stm.setString(6, usuario.getEndereco());
			stm.setString(7, usuario.getEndNum());
			stm.setString(8, usuario.getBairro());
			stm.setString(9, usuario.getCidade());
			stm.setString(10, usuario.getUf());

			stm.executeUpdate();
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

	public boolean validarLogin(String login) throws Exception {

		String sql = "select count(1) as qt_user from usuario where login ='" + login + "'";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();

		if (result.next()) {
			return result.getInt("qt_user") <= 0;
		}
		return false;

	}

}
