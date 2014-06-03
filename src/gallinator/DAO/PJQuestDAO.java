package gallinator.DAO;

import gallinator.modelo.Enemigo;
import gallinator.modelo.PJQuest;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class PJQuestDAO extends ConexionDB {
	private String UPDATE_STATEMENT = "update enemigo set Nombre=?, Imagen=?, Dmg=?, Sangre=?, Exp=?, Points=? where idEnemigo=?";
	private String INSERT_STATEMENT = "INSERT INTO enemigo (Nombre, Imagen, Dmg, Sangre, Exp, Points) VALUES (?,?,?,?,?,?)";

	public ArrayList<PJQuest> leerPJQuest(String clausulaWhere) {

		ArrayList<PJQuest> lista = new ArrayList<PJQuest>();

		try {
			getConexion();
			String insert = "select * from quest_personaje" + clausulaWhere;
			pstmt = conexion.prepareStatement(insert);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				PJQuest pjquest = new PJQuest();
				pjquest.setIdquest_personaje(resultado
						.getInt("idquest_personaje"));
				pjquest.setQuest(resultado.getInt("Quest"));
				pjquest.setPersonaje(resultado.getInt("Personaje"));
				pjquest.setInit(resultado.getString("Init"));
				pjquest.setDone(resultado.getString("Done"));
				lista.add(pjquest);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return lista;
	}

}
