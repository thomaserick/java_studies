package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DaoUsuario;

@WebServlet("/salvarTelefones")
public class TelefonesServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daousuario = new DaoUsuario();

	public TelefonesServelet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id") != null ? request.getParameter("id") : "0");

		try {

			BeanCursoJsp usuario = daousuario.consultar(id);

			request.getSession().setAttribute("userId", id);

			RequestDispatcher view = request.getRequestDispatcher("/telefones.jsp");
			/* request.setAttribute("telefones", daoTelefone.listar(id)); */
			request.setAttribute("userName", usuario.getUser());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long userId = (Long) request.getSession().getAttribute("userId");
		String fone = request.getParameter("fone");
		String tipo = request.getParameter("tipo");

	}

}
