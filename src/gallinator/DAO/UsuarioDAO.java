package gallinator.DAO;

import gallinator.modelo.Usuario;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UsuarioDAO extends ConexionDB {
	public Collection<Usuario> leerUsuario(String clausulaWhere) {

		Collection<Usuario> lista = new ArrayList<Usuario>();

		try {
			getConexion();
			String insert = "select * from usuario " + clausulaWhere;
			pstmt = conexion.prepareStatement(insert);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setUser(resultado.getString("User"));
				usuario.setPass(resultado.getString("Pass"));
				usuario.setEmail(resultado.getString("Email"));
				usuario.setPrivilegio(resultado.getString("Privilegio"));
				lista.add(usuario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return lista;
	}

	public Usuario Usuario(String clausulaWhere) {
		Usuario usuario = new Usuario();
		try {
			getConexion();
			String insert = "select * from usuario" + clausulaWhere;
			pstmt = conexion.prepareStatement(insert);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				usuario.setId(resultado.getInt("id"));
				usuario.setUser(resultado.getString("User"));
				usuario.setPass(resultado.getString("Pass"));
				usuario.setEmail(resultado.getString("Email"));
				usuario.setPrivilegio(resultado.getString("Privilegio"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return usuario;
	}

	public void RegisterUser(Usuario usuario) {
		try {
			getConexion();
			String insert = "insert into usuario(User, Pass, Email) values(?,?,?)";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setString(1, usuario.getUser());
			pstmt.setString(2, usuario.getPass());
			pstmt.setString(3, usuario.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}
}
