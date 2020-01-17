package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.UserLogado;

/*@WebFilter(urlPatterns = { "/pages/filterAutenticacao.jsp" })  //apenas a página*/
@WebFilter(urlPatterns = { "/pages/*" })
public class FilterAutenticacao implements Filter {

	// faz algo quando api e derrubada
	@Override
	public void destroy() {

	}

	// intercepta todas as requisições
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String urlAutenticar = req.getServletPath();

		UserLogado userlogado = (UserLogado) session.getAttribute("usuario");

		if (userlogado == null && !urlAutenticar.equalsIgnoreCase("/pages/ServletAutenticacao")) { // usuario nao
																									// logado
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp?url=" + urlAutenticar); // redirecionamento
			dispatcher.forward(request, response);
			return;
		}

		// executa a ações do request e response
		chain.doFilter(request, response);
		// System.out.println("interceptar");

	}

	// executa quando a aplicaçao é iniciada
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
