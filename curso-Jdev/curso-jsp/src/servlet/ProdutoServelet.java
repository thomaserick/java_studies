package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanProduto;
import dao.DaoProduto;

@WebServlet("/salvarProduto")
public class ProdutoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoProduto daoproduto = new DaoProduto();

	public ProdutoServelet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		Long id = Long.parseLong(request.getParameter("id") != null ? request.getParameter("id") : "0");

		try {

			RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");

			if (acao.equalsIgnoreCase("listarproduto")) {

				try {
					request.setAttribute("produto", daoproduto.listar());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (acao.contentEquals("editar")) {

				BeanProduto produto = daoproduto.consultar(id);
				request.setAttribute("edit", "readonly");

				try {
					request.setAttribute("prod", produto);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (acao.equalsIgnoreCase("delete")) {

				daoproduto.deleteProduto(id);

				try {
					request.setAttribute("produto", daoproduto.listar());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			request.setAttribute("categorias", daoproduto.listarCategoria());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Recebe os dados via post Request.getParameter */

		String id = request.getParameter("id");
		String descricao = request.getParameter("descricao");
		String quantidade = request.getParameter("quantidade");
		String valor = request.getParameter("valor");
		String categoria_id = request.getParameter("categoria_id");

		BeanProduto produto = new BeanProduto();

		produto.setId(!id.isEmpty() ? Long.parseLong(id) : 0);

		try {

			String msg = null;
			boolean checkFields = true;

			if (valor == null || valor.isEmpty()) {
				msg = "Valor deve ser informado!";
				checkFields = false;
			}

			if (quantidade == null || quantidade.isEmpty()) {
				msg = "Quantidade deve ser informada!";
				checkFields = false;
			}

			if (descricao == null || descricao.isEmpty()) {
				msg = "Descrição deve ser informada!";
				checkFields = false;
			}

			if (categoria_id == null || categoria_id.isEmpty()) {
				msg = "Categoria deve ser informada!";
				checkFields = false;

			}

			if (checkFields) {

				produto.setDescricao(descricao);

				produto.setQuantidade(!quantidade.isEmpty() ? Double.parseDouble(quantidade) : 0);

				String valorParse = valor.replaceAll("\\.", "");
				produto.setValor(!valor.isEmpty() ? Double.parseDouble(valorParse.replaceAll("\\,", ".")) : 0);

				produto.setCategoria_id(Long.parseLong(categoria_id));

				if (id == null || id.isEmpty() || produto.getId() == 0) {

					if (daoproduto.validarProduto(descricao)) {

						daoproduto.salvarProduto(produto);

					} else {

						request.setAttribute("produto", produto);
						msg = "Produto já existe com a mesma descrição!";

					}
				} else {

					daoproduto.atualizarProduto(produto);

				}
			}

			request.setAttribute("msg", msg);

			RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
			request.setAttribute("produto", daoproduto.listar());
			request.setAttribute("categorias", daoproduto.listarCategoria());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
