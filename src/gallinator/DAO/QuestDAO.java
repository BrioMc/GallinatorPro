package gallinator.DAO;

import gallinator.modelo.Quest;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class QuestDAO extends ConexionDB {
	public void ingresarQuest(Quest quest) {
		getConexion();
		String insert = "INSERT INTO quest (Definicion, PosX_init, PosY_init, Respuesta, PosX_finish, PosY_finish, Points) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conexion.prepareStatement(insert);

			pstmt.setString(1, quest.getDefinicion());
			pstmt.setInt(2, quest.getPosX_init());
			pstmt.setInt(3, quest.getPosY_init());
			pstmt.setString(4, quest.getRespuesta());
			pstmt.setInt(5, quest.getPosX_finish());
			pstmt.setInt(6, quest.getPosY_finish());
			pstmt.setInt(7, quest.getPoints());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

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
