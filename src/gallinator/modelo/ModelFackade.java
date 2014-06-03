package gallinator.modelo;

import gallinator.DAO.EnemigoDAO;
import gallinator.DAO.PJQuestDAO;
import gallinator.DAO.PersonajeDAO;
import gallinator.DAO.QuestDAO;
import gallinator.DAO.UsuarioDAO;
import gallinator.bean.SesionPlayer;
import gallinator.bean.UsuarioBean;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.apache.commons.beanutils.PropertyUtilsBean;

public class ModelFackade {
	private static UsuarioDAO udao = new UsuarioDAO();
	private static PersonajeDAO pdao = new PersonajeDAO();
	private static EnemigoDAO edao = new EnemigoDAO();
	private static QuestDAO qdao = new QuestDAO();
	private static PJQuestDAO pqdao = new PJQuestDAO();

	/****************************************** Registros ******************************************/
	// Registro de Usuario
	public static void crearUsuario(UsuarioBean UsuBean) throws IOException {
		Usuario usuario = new Usuario();
		try {
			PropertyUtilsBean pubu = new PropertyUtilsBean();
			pubu.copyProperties(usuario, UsuBean);

		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		udao.RegisterUser(usuario);
	}

	// Registro de Usuario
	public static void crearPersonaje(Personaje UsuBean) throws IOException {
		SesionPlayer player = new SesionPlayer();
		try {
			PropertyUtilsBean pubu = new PropertyUtilsBean();
			pubu.copyProperties(player, UsuBean);

		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pdao.RegisterPlayer(player);
	}

	/****************************************** Listas ******************************************/
	// *********Usuario
	public static ArrayList<Usuario> getUsuario(String clausulaWhere) {

		ArrayList<Usuario> usuario = udao.leerUsuario(clausulaWhere);
		return usuario;
	}

	// *********Personaje
	public static ArrayList<Personaje> getPersonaje(String clausulaWhere) {

		ArrayList<Personaje> personaje = pdao.leerPersonaje(clausulaWhere);
		return personaje;
	}

	// *********Personaje
	public static ArrayList<PJQuest> getPJQuest(String clausulaWhere) {
		ArrayList<PJQuest> pjquest = pqdao.leerPJQuest(clausulaWhere);
		return pjquest;
	}

	// *********Enemigos
	public static ArrayList<Enemigo> getEnemigo(String clausulaWhere) {

		ArrayList<Enemigo> enemigo = edao.leerEnemigo(clausulaWhere);
		return enemigo;
	}

	// *********Quests
	public static ArrayList<Quest> getQuest(String clausulaWhere) {

		ArrayList<Quest> quest = qdao.leerQuest(clausulaWhere);
		return quest;
	}
}
