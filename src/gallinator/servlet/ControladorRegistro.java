package gallinator.servlet;

import gallinator.bean.UsuarioBean;
import gallinator.modelo.ModelFackade;
import gallinator.modelo.Personaje;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet que controla el registro de usuario y a la vez de personaje
 */
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
		UsuarioBean user = new UsuarioBean();
		user.setUser(request.getParameter("user"));
		user.setPass(request.getParameter("pass"));
		user.setEmail(request.getParameter("email"));
		Personaje player = new Personaje();
		player.setAlias(request.getParameter("alias"));
		player.setClase(request.getParameter("clase"));
		player.setUsuario(request.getParameter("user"));
		ModelFackade.crearUsuario(user);
		ModelFackade.crearPersonaje(player);

		response.sendRedirect("index.jsp");

	}

}
