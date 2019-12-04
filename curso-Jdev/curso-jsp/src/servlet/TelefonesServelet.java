package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import beans.BeanTelefone;
import dao.DaoTelefones;
import dao.DaoUsuario;

@WebServlet("/salvarTelefones")
public class TelefonesServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daousuario = new DaoUsuario();
	private DaoTelefones daotelefones = new DaoTelefones();

	public TelefonesServelet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long userId = Long.parseLong(request.getParameter("userId") != null ? request.getParameter("userId") : "0");

		String acao = request.getParameter("acao");

		try {

			if (acao.endsWith("delete")) {
				Long id = Long.parseLong(request.getParameter("id") != null ? request.getParameter("id") : "0");

				daotelefones.delete(id);
			}

			BeanCursoJsp usuario = daousuario.consultar(userId);
			request.getSession().setAttribute("userId", userId);

			RequestDispatcher view = request.getRequestDispatcher("/telefones.jsp");
			request.setAttribute("telefones", daotelefones.listar(userId));
			request.setAttribute("userName", usuario.getUser());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long userId = (Long) request.getSession().getAttribute("userId");
		String telefone = request.getParameter("fone");
		String tipo = request.getParameter("tipo");

		BeanTelefone fone = new BeanTelefone();

		fone.setTelefone(telefone);
		fone.setTipo(tipo);
		fone.setUserId(userId);

		try {

			String msg = null;
			boolean checkfield = true;

			if (telefone == null || telefone.isEmpty()) {

				msg = "Telegone deve ser Informado!";
				checkfield = false;
			}

			if (tipo == null || tipo.isEmpty()) {

				msg = "Tipo deve ser Informado";
				checkfield = false;
			}

			if (checkfield) {

				if (daotelefones.validarTelefone(telefone)) {
					daotelefones.salvarTelefones(fone);
				} else {

					request.setAttribute("fone", fone);

					msg = "Telefone já existe com esse numero.";
				}

			}

			request.setAttribute("msg", msg);

			BeanCursoJsp usuario = daousuario.consultar(userId);
			request.getSession().setAttribute("userId", userId);

			RequestDispatcher view = request.getRequestDispatcher("/telefones.jsp");
			request.setAttribute("telefones", daotelefones.listar(userId));
			request.setAttribute("userName", usuario.getUser());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
