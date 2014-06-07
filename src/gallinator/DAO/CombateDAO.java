package gallinator.DAO;

import gallinator.modelo.Enemigo;
import gallinator.modelo.Personaje;
import gallinator.modelo.Quest;
import gallinator.pojo.ConexionDB;

import java.sql.SQLException;

public class CombateDAO extends ConexionDB {
	private String UPDATE_BATTLE = "update personaje set Score=Score+?, Exp=Exp+?, Sangre=?,Mana=? where idPersonaje=?";
	private String UPDATE_SCORE_QUEST = "update personaje set Score=Score+?, where idPersonaje=?";

	public void actStatusBattle(Enemigo enemy, Personaje pj) {
		try {
			getConexion();
			pstmt = conexion.prepareStatement(UPDATE_BATTLE);
			pstmt.setInt(1, enemy.getPoints());
			pstmt.setInt(2, enemy.getExp());
			pstmt.setInt(3, pj.getSangre());
			pstmt.setInt(4, pj.getMana());
			pstmt.setInt(5, pj.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void scoreQuest(int score, int pj) {
		try {
			getConexion();
			pstmt = conexion.prepareStatement(UPDATE_SCORE_QUEST);
			pstmt.setInt(1, score);
			pstmt.setInt(2, pj);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sentenciaQuest(Quest quest, int pj) {
		try {
			getConexion();
			pstmt = conexion.prepareStatement(quest.getSentenciaSQL());
			pstmt.setInt(1, pj);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
