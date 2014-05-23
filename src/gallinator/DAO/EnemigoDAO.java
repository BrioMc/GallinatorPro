package gallinator.DAO;

import gallinator.bean.SesionPlayer;
import gallinator.modelo.Enemigo;
import gallinator.modelo.Usuario;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class EnemigoDAO extends ConexionDB {
	public Collection<Enemigo> leerEnemigo(String clausulaWhere) {

		Collection<Enemigo> lista = new ArrayList<Enemigo>();

		try {
			getConexion();
			String insert = "select * from enemigo"+ clausulaWhere;
			pstmt = conexion.prepareStatement(insert);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				Enemigo enemy = new Enemigo();
				enemy.setId(resultado.getInt("idPersonaje"));
				enemy.setNombre(resultado.getString("Nombre"));	
				enemy.setImagen(resultado.getString("Imagen"));
				enemy.setDmg(resultado.getInt("Dmg"));
				enemy.setSangre(resultado.getInt("Sangre"));
				enemy.setExp(resultado.getInt("Exp"));
				enemy.setPoints(resultado.getInt("Points"));
				lista.add(enemy);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return lista;
	}

	public void savePJ(SesionPlayer player) {
		try {
			getConexion();
			String insert = "UPDATE personaje SET Sangre=?, Mana=?, MaxSangre=?, MaxMana=?, DmgF=?, DmgH=?, WHERE idPersonaje=?";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, player.getSangre());
			pstmt.setInt(2, player.getMana());
			pstmt.setInt(3, player.getMaxSangre());
			pstmt.setInt(4, player.getMaxMana());
			pstmt.setInt(5, player.getDmgF());
			pstmt.setInt(6, player.getDmgH());
			pstmt.setInt(7, player.getId());
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

	public void Mueve(int id, int posX, int posY) {
		try {
			getConexion();
			String insert = "update Personaje SET PosX=?, PosY=? where idPersonaje=?";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, posX);
			pstmt.setInt(2, posY);
			pstmt.setInt(3, id);
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
				SesionLogin.setPosY(resultado.getInt("PosY"));
				SesionLogin.setPosX(resultado.getInt("PosX"));
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrar();
		}

		return SesionLogin;
	}

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
