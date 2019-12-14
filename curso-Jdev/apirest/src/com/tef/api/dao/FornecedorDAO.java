package com.tef.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tef.api.connection.SingleConnection;
import com.tef.api.entity.Fornecedor;

public class FornecedorDAO {

	private Connection connection;

	public FornecedorDAO() {
		connection = SingleConnection.getConnection();
	}

	public void saveFornecedor(Fornecedor fornecedor) {

		String sql = "INSERT INTO fornecedor(razsoc, email, cnpj, endereco, endnum, bairro, cidade, uf, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			int index = 1;
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(index++, fornecedor.getRazsoc());
			stm.setString(index++, fornecedor.getEmail());
			stm.setString(index++, fornecedor.getCnpj());
			stm.setString(index++, fornecedor.getEndereco());
			stm.setString(index++, fornecedor.getEndnum());
			stm.setString(index++, fornecedor.getBairro());
			stm.setString(index++, fornecedor.getCidade());
			stm.setString(index++, fornecedor.getUf());
			stm.setString(index++, fornecedor.getCep());

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

	public void updateFornecedor(Fornecedor fornecedor, Long id) {

		String sql = "UPDATE fornecedor SET razsoc = ?, email = ?, cnpj = ?, endereco = ?, endnum = ?, bairro = ?,"
				+ "cidade = ?, uf = ?, cep = ?  WHERE id =" + id;

		try {
			int index = 1;
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(index++, fornecedor.getRazsoc());
			stm.setString(index++, fornecedor.getEmail());
			stm.setString(index++, fornecedor.getCnpj());
			stm.setString(index++, fornecedor.getEndereco());
			stm.setString(index++, fornecedor.getEndnum());
			stm.setString(index++, fornecedor.getBairro());
			stm.setString(index++, fornecedor.getCidade());
			stm.setString(index++, fornecedor.getUf());
			stm.setString(index++, fornecedor.getCep());

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

	public void deletFornecedor(Long id) {

		String sql = "DELETE FROM fornecedor WHERE id =" + id;

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

	public List<Fornecedor> listFornecedor() {

		List<Fornecedor> listar = new ArrayList<Fornecedor>();
		String sql = "SELECT * FROM fornecedor";

		try {

			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet result = stm.executeQuery();

			while (result.next()) {

				Fornecedor fornecedor = new Fornecedor();

				fornecedor.setId(result.getLong("id"));
				fornecedor.setRazsoc(result.getString("razsoc"));
				fornecedor.setEmail(result.getString("email"));
				fornecedor.setCnpj(result.getString("cnpj"));
				fornecedor.setEndereco(result.getString("endereco"));
				fornecedor.setEndnum(result.getString("endnum"));
				fornecedor.setBairro(result.getString("bairro"));
				fornecedor.setCidade(result.getString("cidade"));
				fornecedor.setUf(result.getString("uf"));
				fornecedor.setCep(result.getString("cep"));

				listar.add(fornecedor);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return listar;

	}

	public Fornecedor consultId(Long id) throws Exception {

		String sql = "SELECT * FROM FORNECEDOR WHERE id =" + id;
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet result = stm.executeQuery();

		while (result.next()) {

			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setId(result.getLong("id"));
			fornecedor.setRazsoc(result.getString("razsoc"));
			fornecedor.setEmail(result.getString("email"));
			fornecedor.setCnpj(result.getString("cnpj"));
			fornecedor.setEndereco(result.getString("endereco"));
			fornecedor.setEndnum(result.getString("endnum"));
			fornecedor.setBairro(result.getString("bairro"));
			fornecedor.setCidade(result.getString("cidade"));
			fornecedor.setUf(result.getString("uf"));
			fornecedor.setCep(result.getString("cep"));

			return fornecedor;

		}

		return null;

	}

}
