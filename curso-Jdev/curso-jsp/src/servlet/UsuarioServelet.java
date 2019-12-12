package servlet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.codec.binary.Base64;

import beans.BeanCursoJsp;
import dao.DaoUsuario;

/**
 * Servlet implementation class Usuário
 */

@WebServlet("/salvarUsuario")
@MultipartConfig
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

			} else if (acao.equalsIgnoreCase("download")) {

				try {

					BeanCursoJsp usuario = daousuario.consultar(id);

					if (usuario != null) {
						response.setHeader("Content-Disposition", "attachment; filename=arquivo."
								+ usuario.getContentType().split("\\/")[1]); /* Spli -> */

						byte[] imagemFotoBytes = Base64.decodeBase64(usuario.getFotoBase64());
						OutputStream os = response.getOutputStream();
						os.write(imagemFotoBytes);

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (acao.equalsIgnoreCase("downloadCv")) {

				try {

					BeanCursoJsp usuario = daousuario.consultar(id);

					if (usuario != null) {
						response.setHeader("Content-Disposition", "attachment; filename=arquivo."
								+ usuario.getContentTypeCv().split("\\/")[1]); /* Split -> */

						byte[] imagemCvBytes = Base64.decodeBase64(usuario.getCvBase64());
						OutputStream os = response.getOutputStream();
						os.write(imagemCvBytes);

					}

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

		String cep = request.getParameter("cep");
		String endereco = request.getParameter("endereco");
		String endnum = request.getParameter("endNum");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String sexo = request.getParameter("sexo");
		String perfil = request.getParameter("perfil");

		BeanCursoJsp usuario = new BeanCursoJsp();

		usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);

		usuario.setLogin(login);
		usuario.setPasswd(passwd);
		usuario.setUser(user);
		usuario.setFone(fone);

		usuario.setCep(cep);
		usuario.setEndereco(endereco);
		usuario.setEndNum(endnum);

		usuario.setCidade(cidade);
		usuario.setBairro(bairro);
		usuario.setUf(uf);
		usuario.setSexo(sexo);
		usuario.setPerfil(perfil);

		if (request.getParameter("ativo") != null && request.getParameter("ativo").equalsIgnoreCase("on")) {
			usuario.setAtivo(true);
		} else {
			usuario.setAtivo(false);
		}

		try {

			/*
			 * if (ServletFileUpload.isMultipartContent(request)) {
			 * 
			 * List<FileItem> fileItems = new ServletFileUpload(new
			 * DiskFileItemFactory()).parseRequest(request);
			 * 
			 * for (FileItem fileItem : fileItems) {
			 * 
			 * if (fileItem.getFieldName().equals("imgUser")) {
			 * 
			 * String fotoBase64 = new Base64().encodeBase64String(fileItem.get()); String
			 * contentType = fileItem.getContentType();
			 * 
			 * usuario.setFotoBase64(fotoBase64); usuario.setContentType(contentType);
			 * 
			 * } }
			 * 
			 * }
			 */

			if (ServletFileUpload.isMultipartContent(request)) {

				Part imgFoto = request.getPart("imgUser");

				if (imgFoto != null && imgFoto.getInputStream().available() > 0) {

					byte[] byteImg = StremParaByte(imgFoto.getInputStream());

					String fotoBase64 = new Base64().encodeBase64String(byteImg);
					usuario.setFotoBase64(fotoBase64);
					usuario.setContentType(imgFoto.getContentType());

					/* Miniatura Imagem */

					byte[] imgByteDecode = new Base64().decodeBase64(fotoBase64);

					BufferedImage bfImage = ImageIO.read(new ByteArrayInputStream(byteImg));

					/* Pega o tipo da imagem */
					int type = bfImage.getType() == 0 ? bfImage.TYPE_INT_ARGB : bfImage.getType();

					/* Cria imagem em miniatura */
					BufferedImage resizedImage = new BufferedImage(100, 100, type);

					Graphics2D g2d = resizedImage.createGraphics();
					g2d.drawImage(bfImage, 0, 0, 100, 100, null);
					g2d.dispose(); // Finaliza o processo

					/* Escrever a imagem novamente */
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(resizedImage, "png", baos);

					String fotoBase64Min = "data:image/png;base64,"
							+ DatatypeConverter.printBase64Binary(baos.toByteArray());

					usuario.setFotoBase64Min(fotoBase64Min);

					/* Miniatura */

				} else {
					usuario.setAtualizarImg(false);
				}

				Part cv = request.getPart("cvUser");
				if (cv != null && cv.getInputStream().available() > 0) {
					String cvBase64 = new Base64().encodeBase64String(StremParaByte(cv.getInputStream()));
					usuario.setCvBase64(cvBase64);
					usuario.setContentTypeCv(cv.getContentType());
				} else {
					usuario.setAtualizarCv(false);

				}

			}

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

			if (sexo == null || sexo.isEmpty()) {
				msg = "Sexo deve ser Informado!";
				checkField = false;
			}
			if (perfil == null || perfil.isEmpty()) {
				msg = "PErfil deve ser Informado!";
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

	/* Converte fluxo de dados para Array de Bytes */
	private byte[] StremParaByte(InputStream img) throws Exception {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int reads = img.read();

		while (reads != -1) {

			baos.write(reads);
			reads = img.read();

		}

		return baos.toByteArray();

	}

}
