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
 * Servlet implementation class Usuário
 */

@WebServlet("/salvarUsuario")
public class UsuarioServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daousuario = new DaoUsuario();

	public UsuarioServelet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		Long id = Long.parseLong(request.getParameter("id") != null ? request.getParameter("id") : "0");

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
				request.setAttribute("edit", "readonly");

				try {
					RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
					request.setAttribute("user", usuario);
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (acao.equalsIgnoreCase("listaruser")) {

				try {
					RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
					request.setAttribute("usuarios", daousuario.listar());
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
		String fone = request.getParameter("fone");

		BeanCursoJsp usuario = new BeanCursoJsp();
		usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);

		usuario.setLogin(login);
		usuario.setPasswd(passwd);
		usuario.setUser(user);
		usuario.setFone(fone);

		try {

			String msg = null;
			boolean checkField = true;

			if (login == null || login.isEmpty()) {
				msg = "Login deve ser Informado!";
				checkField = false;
			}

			if (passwd == null || passwd.isEmpty()) {
				msg = "Senha deve ser Informada!";
				checkField = false;
			}
			if (user == null || user.isEmpty()) {
				msg = "Usuário deve ser Informado!";
				checkField = false;
			}
			if (fone == null || fone.isEmpty()) {
				msg = "Telefone deve ser Informado!";
				checkField = false;
			}

			if (checkField) {

				if (id == null || id.isEmpty() || usuario.getId() == 0) {
					if (daousuario.validarLogin(login)) {
						daousuario.salvarUsuario(usuario);
					} else {

						request.setAttribute("user", usuario);

						msg = "Usuário já existe com o mesmo login!";
					}
				} else {
					daousuario.atualizarUser(usuario);
				}
			}
			request.setAttribute("msg", msg);

			RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("usuarios", daousuario.listar());
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
