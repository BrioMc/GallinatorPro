package ikex.servlet.controlador;

import ikex.bean.LogginBean;
import ikex.pojo.ConexionDB;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("user");
		String pwd = request.getParameter("pass");
		String sql = "select * from usuarios where Usuario=? and password=? and Bloqueado='N'";
		String sqlUpdate = "update usuarios set Usuario='" + user
				+ "' where Usuario='" + user + "'";
		ConexionDB consul = new ConexionDB();
		PreparedStatement con;
		PreparedStatement ultimoAcceso;
		ResultSet rs;
		try {
			con = consul.getConexion().prepareStatement(sql);
			con.setString(1, user);
			con.setString(2, pwd);
			rs = con.executeQuery();
			if (rs.next()) {
				System.out.println(sqlUpdate);
				ultimoAcceso = consul.getConexion().prepareStatement(sqlUpdate);
				ultimoAcceso.execute();
				request.getSession().setAttribute("userLoggedIn", true);
				LogginBean SesionLogin = new LogginBean();
				SesionLogin.setIdUsuario(rs.getString("idUsuario"));
				SesionLogin.setPrivilegio(rs.getString("Privilegio"));
				request.getSession().setAttribute("SesionLogin", SesionLogin);
				System.out.println(SesionLogin.getPrivilegio().toString());
				String Privilegio = SesionLogin.getPrivilegio();
				if (Privilegio.equals("User")) {
					System.out.println("Entra como: "
							+ SesionLogin.getPrivilegio().toString());
					response.sendRedirect("index.jsp");
				}
				if (Privilegio.equals("Admin")) {
					System.out.println("Entra como: "
							+ SesionLogin.getPrivilegio().toString());
					response.sendRedirect("Admin/indexAdmin.jsp");
				}
			} else {
				request.setAttribute("errorloggin", "Error");
				String pagina = "index.jsp?errorloggin=Error";
				System.out.println("Llega aquí");
				System.out.println(request.getAttribute("errorloggin"));
				response.sendRedirect(pagina);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			consul.cerrar();
		}
	}
}
