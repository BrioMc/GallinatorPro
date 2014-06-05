package gallinator.DAO;

import gallinator.modelo.PJQuest;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class PJQuestDAO extends ConexionDB {
	private String INSERT_STATEMENT = "INSERT INTO quest_personaje (Quest, Personaje) VALUES (?,?)";
	private String FOUND_STATEMENT = "select * from quest_personaje where Quest=? and Personaje=?";

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

	public void delPJQ(int id) {
		String insert = "delete from quest_personaje where idquest_personaje=?";
		try {
			getConexion();
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void insertPJQuest(int pj, int quest) {
		try {
			getConexion();
			pstmt = conexion.prepareStatement(INSERT_STATEMENT);
			pstmt.setInt(1, quest);
			pstmt.setInt(2, pj);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public PJQuest takePJQuest(int id, int quest) {
		PJQuest pjq = new PJQuest();
		try {
			getConexion();
			String Select = "select * from quest_personaje where Personaje=? and Quest=?";
			pstmt = conexion.prepareStatement(Select);
			pstmt.setInt(1, id);
			pstmt.setInt(2, quest);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				pjq.setIdquest_personaje(resultado.getInt("idquest_personaje"));
				pjq.setQuest(resultado.getInt("Quest"));
				pjq.setPersonaje(resultado.getInt("Personaje"));
				pjq.setInit(resultado.getString("Init"));
				pjq.setDone(resultado.getString("Done"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return pjq;
	}

	public void updateInit(int id, int quest) {
		try {
			getConexion();
			String Select = "update quest_personaje set Init='Y' where Personaje=? and Quest=?";
			pstmt = conexion.prepareStatement(Select);
			pstmt.setInt(1, id);
			pstmt.setInt(2, quest);
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void updateDone(int id, int quest) {
		try {
			getConexion();
			String Select = "update quest_personaje set Done='Y' where Personaje=? and Quest=?";
			pstmt = conexion.prepareStatement(Select);
			pstmt.setInt(1, id);
			pstmt.setInt(2, quest);
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public boolean existPJQuest(int pj, int quest) {
		boolean existe = false;
		try {
			getConexion();
			pstmt = conexion.prepareStatement(FOUND_STATEMENT);
			pstmt.setInt(1, quest);
			pstmt.setInt(2, pj);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				existe = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return existe;
	}
}
