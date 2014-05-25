package gallinator.DAO;

import gallinator.modelo.Quest;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class QuestDAO extends ConexionDB {

	public Collection<Quest> leerQuest(String clausulaWhere) {

		Collection<Quest> lista = new ArrayList<Quest>();

		try {
			getConexion();
			String insert = "select * from quest" + clausulaWhere;
			pstmt = conexion.prepareStatement(insert);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				Quest quest = new Quest();
				quest.setId(resultado.getInt("idQuest"));
				quest.setDefinicion(resultado.getString("Definicion"));
				quest.setPosX_init(resultado.getInt("PosX_init"));
				quest.setPosY_init(resultado.getInt("PosY_init"));
				quest.setRespuesta(resultado.getString("Respuesta"));
				quest.setPosY_finish(resultado.getInt("PosY_finish"));
				quest.setPosX_finish(resultado.getInt("PosX_finish"));
				quest.setPoints(resultado.getInt("Points"));
				lista.add(quest);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return lista;
	}
}
