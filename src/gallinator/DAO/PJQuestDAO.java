package gallinator.DAO;

import gallinator.modelo.Enemigo;
import gallinator.modelo.PJQuest;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class PJQuestDAO extends ConexionDB {
	private String UPDATE_STATEMENT = "update enemigo set Nombre=?, Imagen=?, Dmg=?, Sangre=?, Exp=?, Points=? where idEnemigo=?";
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
	public boolean existPJQuest(int pj, int quest){
		boolean existe = false;
		try {
			getConexion();
			pstmt = conexion.prepareStatement(FOUND_STATEMENT);
			pstmt.setInt(1, quest);
			pstmt.setInt(2, pj);
			resultado=pstmt.executeQuery();
			if(resultado.getRow()!=0){
				existe=true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return existe;
	}
}
