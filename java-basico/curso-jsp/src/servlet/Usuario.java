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

/**
 * Servlet implementation class Usuario
 */

@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daousuario = new DaoUsuario();

	public Usuario() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		Long id = Long.parseLong(request.getParameter("id"));

		try {
			if (acao.equalsIgnoreCase("delete")) {

				daousuario.deleteUser(id);

				try {
					RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
					request.setAttribute("usuarios", daousuario.listar());
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (acao.equalsIgnoreCase("editar")) {

				BeanCursoJsp usuario = daousuario.consultar(id);

				try {
					RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
					request.setAttribute("user", usuario);
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String passwd = request.getParameter("passwd");
		String user = request.getParameter("user");

		BeanCursoJsp usuario = new BeanCursoJsp();
		usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);

		usuario.setLogin(login);
		usuario.setPasswd(passwd);
		usuario.setUser(user);

		if (id == null || id.isEmpty()) {
			daousuario.salvarUsuario(usuario);
		} else {

			daousuario.atualizarUser(usuario);
		}

		try {
			RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("usuarios", daousuario.listar());
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
