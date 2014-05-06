package gallinator.servlet;

import gallinator.DAO.UsuarioDAO;
import gallinator.modelo.Personaje;
import gallinator.modelo.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorRegistro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Registro de un Usuario
		User user = new User();
		user.setUser(request.getParameter("user"));
		user.setPass(request.getParameter("pass"));
		user.setEmail(request.getParameter("email"));
		Personaje player = new Personaje();
		player.setAlias(request.getParameter("alias"));
		player.setClase(request.getParameter("clase"));
		player.setUsuariofk(request.getParameter("user"));
		UsuarioDAO udao = new UsuarioDAO();
		udao.RegisterUser(user);
		udao.RegisterPlayer(player);
		response.sendRedirect("index.jsp");

	}

}