package gallinator.DAO;

import gallinator.bean.SesionPlayer;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;

/**
 * Clase DAO de los metodos que interactuan con la sesion del jugador
 */
public class PartidaDAO extends ConexionDB {
	/**
	 * Metodo que guarda la posicion actual del jugador
	 */
	public void savePosition(SesionPlayer usuario) {
		try {
			System.out.println("Entra a guardar");
			getConexion();
			String insert = "update personaje set PosX=?,PosY=? where idPersonaje=?";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, usuario.getPosX());
			pstmt.setInt(2, usuario.getPosY());
			pstmt.setInt(3, usuario.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} catch (Exception e) {

			System.out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	/**
	 * Carga un Objeto SesionPlayer para introducirlo como bean de sesion tras
	 * un loggin correcto
	 */
	public SesionPlayer load(String user) {
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
				SesionLogin.setPosX(resultado.getInt("PosX"));
				SesionLogin.setPosY(resultado.getInt("PosY"));
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SesionLogin;
	}
	/**
	 * Registra un personaje asignandole la clase, el usuario, y un alias, el resto se encarga la base de datos
	 */
	public void RegisterPlayer(SesionPlayer player) {
		try {
			getConexion();
			String insert = "insert into personaje(UsuarioFK, Alias, Clase) values(?,?,?)";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setString(1, player.getUsuario());
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

	}
