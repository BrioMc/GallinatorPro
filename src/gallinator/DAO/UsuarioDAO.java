package gallinator.DAO;

import gallinator.bean.SesionPlayer;
import gallinator.modelo.Personaje;
import gallinator.modelo.User;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;

public class UsuarioDAO extends ConexionDB {

	public void RegisterUser(User usuario) {
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

	public SesionPlayer PlayerSesion(String user) {
		SesionPlayer SesionLogin = new SesionPlayer();
		String sql = "select * from personaje where UsuarioFK=?";
		try {
			getConexion();
			pstmt = conexion.prepareStatement(sql);
			pstmt.setString(1, user);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				SesionLogin.setId(resultado.getInt("idPersonaje"));
				SesionLogin.setAlias(resultado.getString("Alias"));
				SesionLogin.setClase(resultado.getString("Clase"));
				SesionLogin.setUsuario(resultado.getString("UsuarioFK"));
				SesionLogin.setSangre(resultado.getInt("Sangre"));
				SesionLogin.setMana(resultado.getInt("Mana"));
				SesionLogin.setMaxSangre(resultado.getInt("MaxSangre"));
				SesionLogin.setMaxMana(resultado.getInt("MaxMana"));
				SesionLogin.setDmgF(resultado.getInt("DmgF"));
				SesionLogin.setDmgH(resultado.getInt("DmgH"));
				SesionLogin.setExp(resultado.getInt("Exp"));
				SesionLogin.setLv(resultado.getInt("Lv"));
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SesionLogin;
	}

	public void RegisterPlayer(Personaje player) {
		try {
			getConexion();
			String insert = "insert into personaje(UsuarioFK, Alias, Clase) values(?,?,?)";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setString(1, player.getUsuariofk());
			pstmt.setString(2, player.getAlias());
			pstmt.setString(3, player.getClase());
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

	public void EliminarProducto(String value) {
		getConexion();
		try {
			String where = value;
			pstmt = conexion.prepareStatement(where);
			pstmt.setString(1, where);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
