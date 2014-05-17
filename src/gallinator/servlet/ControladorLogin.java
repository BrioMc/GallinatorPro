package gallinator.servlet;

import gallinator.DAO.UsuarioDAO;
import gallinator.bean.SesionPlayer;
import gallinator.pojo.ConexionDB;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlar_Login
 */
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("user");
		String pwd = request.getParameter("pass");
		String sql = "select * from usuario where User=? and Pass=?";
		ConexionDB consul = new ConexionDB();
		PreparedStatement con;
		ResultSet rs;
		try {
			con = consul.getConexion().prepareStatement(sql);
			con.setString(1, user);
			con.setString(2, pwd);
			rs = con.executeQuery();
			if (rs.next()) {
				con = consul.getConexion().prepareStatement(sql);
				request.getSession().setAttribute("SesionPlayer", true);
				UsuarioDAO udao = new UsuarioDAO();
				SesionPlayer SesionLogin = udao.PlayerSesion(user);
				request.getSession().setAttribute("SesionPlayer", SesionLogin);
				System.out.println(SesionLogin.getUsuario().toString());
				response.sendRedirect("index.jsp");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			consul.cerrar();
		}
	}
}
