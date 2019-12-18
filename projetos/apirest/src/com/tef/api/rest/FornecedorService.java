package com.tef.api.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tef.api.dao.FornecedorDAO;
import com.tef.api.entity.Fornecedor;

@Path("/fornecedor")
public class FornecedorService {

	private static final String CHARSET_UTF8 = ";charset=utf-8";

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
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String addFornecedor(Fornecedor fornecedor) {

		String msg = "";

		try {

			fornecedorDAO.saveFornecedor(fornecedor);
			msg = "Fornecedor incluido com Sucesso";

		} catch (Exception e) {
			msg = "Erro ao incluido Fornecedor";
			e.printStackTrace();
		}

		return msg;

	}

	@GET
	@Path("/get/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)

	public Fornecedor consultId(@PathParam("id") Long id) {

		Fornecedor fornecedor = null;

		try {

			fornecedor = fornecedorDAO.consultId(id);

			return fornecedor;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)

	public String editFornecedor(Fornecedor fornecedor, @PathParam("id") Long id) {

		String msg = "";
		try {

			fornecedorDAO.updateFornecedor(fornecedor, id);
			msg = "Fornecedor editado com Sucesso";
		} catch (Exception e) {
			msg = "Erro ao editar o Fornecedor";
			e.printStackTrace();
		}
		return msg;
	}

	@DELETE
	@Path("/delet/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletFornecedor(@PathParam("id") Long id) {
		String msg = "";

		try {

			fornecedorDAO.deletFornecedor(id);
			msg = "Fornecedor excluido com Sucesso";

		} catch (Exception e) {
			msg = "Erro ao excluir o Fornecedor";
			e.printStackTrace();
		}

		return msg;
	}

}
