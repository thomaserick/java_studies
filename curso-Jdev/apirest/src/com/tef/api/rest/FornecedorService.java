package com.tef.api.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tef.api.dao.FornecedorDAO;
import com.tef.api.entity.Fornecedor;

@Path("/fornecedor")
public class FornecedorService {

	private FornecedorDAO fornecedorDAO;

	@PostConstruct
	private void init() {

		fornecedorDAO = new FornecedorDAO();

	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fornecedor> listFornecedor() {
		List<Fornecedor> lista = null;
		try {
			lista = fornecedorDAO.listFornecedor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addFornecedor(Fornecedor fornecedor) {

		String msg = "";

		try {

			fornecedorDAO.saveFornecedor(fornecedor);
			msg = "Fornecedo incluido com Sucesso";

		} catch (Exception e) {
			msg = "Erro ao incluido Fornecedor";
			e.printStackTrace();
		}

		return msg;

	}

}
