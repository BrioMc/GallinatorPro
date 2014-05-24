package gallinator.modelo;

import gallinator.DAO.EnemigoDAO;
import gallinator.DAO.PersonajeDAO;
import gallinator.DAO.QuestDAO;
import gallinator.DAO.UsuarioDAO;
import gallinator.bean.SesionPlayer;
import gallinator.bean.UsuarioBean;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.apache.commons.beanutils.PropertyUtilsBean;

public class ModelFackade {
	private static UsuarioDAO udao = new UsuarioDAO();
	private static PersonajeDAO perdao = new PersonajeDAO();
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
		perdao.RegisterPlayer(player);
	}

	/****************************************** Listas ******************************************/
	// *********Usuario
	public static Collection<Usuario> getUsuario(String clausulaWhere) {
		UsuarioDAO udao = new UsuarioDAO();

		Collection<Usuario> usuario = udao.leerUsuario(clausulaWhere);
		return usuario;
	}

	// *********Personaje
	public static Collection<Personaje> getPersonaje(String clausulaWhere) {
		PersonajeDAO pdao = new PersonajeDAO();

		Collection<Personaje> personaje = pdao.leerPersonaje(clausulaWhere);
		return personaje;
	}

	// *********Enemigos
	public static Collection<Enemigo> getEnemigo(String clausulaWhere) {
		EnemigoDAO edao = new EnemigoDAO();
		Collection<Enemigo> enemigo = edao.leerEnemigo(clausulaWhere);
		return enemigo;
	}

	// *********Quests
	public static Collection<Quest> getQuest(String clausulaWhere) {
		QuestDAO qdao = new QuestDAO();

		Collection<Quest> quest = qdao.leerQuest(clausulaWhere);
		return quest;
	}
}
