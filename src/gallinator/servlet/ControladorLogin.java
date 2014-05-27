package gallinator.servlet;

import gallinator.DAO.PersonajeDAO;
import gallinator.bean.SesionPlayer;
import gallinator.bean.UsuarioBean;
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
				UsuarioBean usuario = new UsuarioBean();
				if (rs.getString("Privilegio").equals("Admin")) {
					usuario.setId(rs.getInt("id"));
					usuario.setUser(rs.getString("User"));
					usuario.setPrivilegio(rs.getString("Privilegio"));
					request.getSession().setAttribute("SesionAdmin", true);
					request.getSession().setAttribute("SesionAdmin", usuario);
					response.sendRedirect("admin/admin_index.jsp");

				} else {
					request.getSession().setAttribute("SesionPlayer", true);
					PersonajeDAO pdao = new PersonajeDAO();
					SesionPlayer SesionLogin = pdao.PlayerSesion(user);
					request.getSession().setAttribute("SesionPlayer",
							SesionLogin);
					response.sendRedirect("index.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			consul.cerrar();
		}
	}
}
