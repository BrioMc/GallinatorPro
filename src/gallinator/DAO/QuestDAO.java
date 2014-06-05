package gallinator.DAO;

import gallinator.modelo.Quest;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuestDAO extends ConexionDB {
	public void addQuest(Quest quest) {
		getConexion();
		String insert = "INSERT INTO quest (Definicion, PosX_init, PosY_init, Respuesta, PosX_finish, PosY_finish, Points,Battle,Enemigo,Mejora,SentenciaSQL) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conexion.prepareStatement(insert);

			pstmt.setString(1, quest.getDefinicion());
			pstmt.setInt(2, quest.getPosX_init());
			pstmt.setInt(3, quest.getPosY_init());
			pstmt.setString(4, quest.getRespuesta());
			pstmt.setInt(5, quest.getPosX_finish());
			pstmt.setInt(6, quest.getPosY_finish());
			pstmt.setInt(7, quest.getPoints());
			pstmt.setString(8, quest.getBattle());
			pstmt.setInt(9, quest.getEnemy());
			pstmt.setString(10, quest.getMejora());
			pstmt.setString(11, quest.getSentenciaSQL());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void delQuest(int id) {
		getConexion();
		String insert = "delete from quest where idQuest=?";
		try {
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void modQuest(Quest quest) {

		String insert = "update quest set Definicion=?, PosX_init=?, PosY_init=?, Respuesta=?, PosX_finish=?, PosY_finish=?, Points=?, Battle=?,Enemigo=?,Mejora=?,SentenciaSQL=? where idQuest=?";
		try {
			getConexion();
			pstmt = conexion.prepareStatement(insert);
			pstmt.setString(1, quest.getDefinicion());
			pstmt.setInt(2, quest.getPosX_init());
			pstmt.setInt(3, quest.getPosY_init());
			pstmt.setString(4, quest.getRespuesta());
			pstmt.setInt(5, quest.getPosX_finish());
			pstmt.setInt(6, quest.getPosY_finish());
			pstmt.setInt(7, quest.getPoints());
			pstmt.setString(8, quest.getBattle());
			pstmt.setInt(9, quest.getEnemy());
			pstmt.setString(10, quest.getMejora());
			pstmt.setString(11, quest.getSentenciaSQL());
			pstmt.setInt(12, quest.getIdQuest());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public Quest takeQuest(int id) {
		Quest quest = new Quest();
		try {
			getConexion();
			String insert = "select * from quest where idQuest=?";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, id);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				quest.setIdQuest(resultado.getInt("idQuest"));
				quest.setDefinicion(resultado.getString("Definicion"));
				quest.setPosX_init(resultado.getInt("PosX_init"));
				quest.setPosY_init(resultado.getInt("PosY_init"));
				quest.setRespuesta(resultado.getString("Respuesta"));
				quest.setPosY_finish(resultado.getInt("PosY_finish"));
				quest.setPosX_finish(resultado.getInt("PosX_finish"));
				quest.setBattle(resultado.getString("Battle"));
				quest.setEnemy(resultado.getInt("Enemigo"));
				quest.setMejora(resultado.getString("Mejora"));
				quest.setSentenciaSQL(resultado.getString("SentenciaSQL"));
				quest.setPoints(resultado.getInt("Points"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return quest;
	}

	public Quest initQuest(int x, int y) {
		Quest quest = new Quest();
		try {
			getConexion();
			String insert = "select * from quest where PosX_init=? and PosY_init=?";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, x);
			pstmt.setInt(2, y);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				quest.setIdQuest(resultado.getInt("idQuest"));
				quest.setDefinicion(resultado.getString("Definicion"));
				quest.setPosX_init(resultado.getInt("PosX_init"));
				quest.setPosY_init(resultado.getInt("PosY_init"));
				quest.setRespuesta(resultado.getString("Respuesta"));
				quest.setPosY_finish(resultado.getInt("PosY_finish"));
				quest.setPosX_finish(resultado.getInt("PosX_finish"));
				quest.setBattle(resultado.getString("Battle"));
				quest.setEnemy(resultado.getInt("Enemigo"));
				quest.setMejora(resultado.getString("Mejora"));
				quest.setSentenciaSQL(resultado.getString("SentenciaSQL"));
				quest.setPoints(resultado.getInt("Points"));
			} else {
				quest.setIdQuest(0);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return quest;
	}

	public Quest finishQuest(int x, int y) {
		Quest quest = new Quest();
		try {
			getConexion();
			String insert = "select * from quest where PosX_finish=? and PosY_finish=?";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, x);
			pstmt.setInt(2, y);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				quest.setIdQuest(resultado.getInt("idQuest"));
				quest.setDefinicion(resultado.getString("Definicion"));
				quest.setPosX_init(resultado.getInt("PosX_init"));
				quest.setPosY_init(resultado.getInt("PosY_init"));
				quest.setRespuesta(resultado.getString("Respuesta"));
				quest.setPosY_finish(resultado.getInt("PosY_finish"));
				quest.setPosX_finish(resultado.getInt("PosX_finish"));
				quest.setBattle(resultado.getString("Battle"));
				quest.setEnemy(resultado.getInt("Enemigo"));
				quest.setMejora(resultado.getString("Mejora"));
				quest.setSentenciaSQL(resultado.getString("SentenciaSQL"));
				quest.setPoints(resultado.getInt("Points"));
			} else {
				quest.setIdQuest(0);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return quest;
	}

	public ArrayList<Quest> leerQuest(String clausulaWhere) {

		ArrayList<Quest> lista = new ArrayList<Quest>();

		try {
			getConexion();
			String insert = "select * from quest" + clausulaWhere;
			pstmt = conexion.prepareStatement(insert);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				Quest quest = new Quest();
				quest.setIdQuest(resultado.getInt("idQuest"));
				quest.setDefinicion(resultado.getString("Definicion"));
				quest.setPosX_init(resultado.getInt("PosX_init"));
				quest.setPosY_init(resultado.getInt("PosY_init"));
				quest.setRespuesta(resultado.getString("Respuesta"));
				quest.setPosY_finish(resultado.getInt("PosY_finish"));
				quest.setPosX_finish(resultado.getInt("PosX_finish"));
				quest.setBattle(resultado.getString("Battle"));
				quest.setEnemy(resultado.getInt("Enemigo"));
				quest.setMejora(resultado.getString("Mejora"));
				quest.setSentenciaSQL(resultado.getString("SentenciaSQL"));
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
