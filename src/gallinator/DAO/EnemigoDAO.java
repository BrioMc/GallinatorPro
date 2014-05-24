package gallinator.DAO;

import gallinator.modelo.Enemigo;
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

}
