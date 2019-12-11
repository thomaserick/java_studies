package dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanProduto;
import connection.SingleConnection;

public class DaoProduto {
	/* Objeto do connection */
	private Connection connection;

	public DaoProduto() {
		/* Recebe o objeto de conexão do banco de dados */
		connection = SingleConnection.getConnection();

	}

	public void salvarProduto(BeanProduto produto) {

		String sql = "insert into produto (descricao, quantidade, valor) values (?, ?, ?)";

		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getDescricao());
			stm.setDouble(2, BigDecimal.valueOf(produto.getQuantidade()).setScale(4, RoundingMode.DOWN).doubleValue());
			stm.setDouble(3, produto.getValor());
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

	public List<BeanProduto> listar() throws Exception {

		String sql = "select * from produto";

		/* Lista de Objetos */
		List<BeanProduto> listar = new ArrayList<BeanProduto>();

		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();

		while (result.next()) {

			BeanProduto produto = new BeanProduto();

			produto.setId(result.getLong("id"));
			produto.setDescricao(result.getString("descricao"));
			produto.setQuantidade(result.getDouble("quantidade"));
			produto.setValor(result.getDouble("valor"));

			listar.add(produto);
		}

		return listar;

	}

	public boolean validarProduto(String descricao) throws Exception {

		String sql = "select count(1) as qtd_produto from produto where descricao= '" + descricao + "'";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();

		if (result.next()) {
			return result.getInt("qtd_produto") <= 0;
		}

		return false;
	}

	public BeanProduto consultar(Long id) throws Exception {

		String sql = "SELECT * FROM produto WHERE id =" + id;
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();

		if (result.next()) {
			BeanProduto produto = new BeanProduto();
			produto.setId(result.getLong("id"));
			produto.setDescricao(result.getString("descricao"));
			produto.setQuantidade(result.getDouble("quantidade"));
			produto.setValor(result.getDouble("valor"));

			return produto;
		}

		return null;

	}

	public void deleteProduto(Long id) {

		String sql = "delete from produto where id = " + id;

		try {
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

	public void atualizarProduto(BeanProduto produto) {

		String sql = "update produto set descricao = ?, quantidade = ?, valor = ? where id= " + produto.getId();
		try {

			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(1, produto.getDescricao());
			stm.setDouble(2, produto.getQuantidade());
			stm.setDouble(3, produto.getValor());

			stm.executeUpdate();
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
