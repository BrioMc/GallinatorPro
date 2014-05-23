package gallinator.modelo;

import gallinator.DAO.EnemigoDAO;
import gallinator.DAO.UsuarioDAO;
import gallinator.bean.SesionPlayer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.apache.commons.beanutils.PropertyUtilsBean;

public class ModelFackade {
	/****************************************** Registros ******************************************/
	// Registro de Usuario
	public static void crearUsuario(Usuario UsuBean) throws IOException {
		Usuario usuario = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
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
		UsuarioDAO udao = new UsuarioDAO();
		try {
			PropertyUtilsBean pubu = new PropertyUtilsBean();
			pubu.copyProperties(player, UsuBean);

		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		udao.RegisterPlayer(player);
	}

	/****************************************** Listas ******************************************/
	// *********Usuario
	public static Collection<Enemigo> getUsuario(String clausulaWhere) {
		EnemigoDAO edao = new EnemigoDAO();

		Collection<Enemigo> enemigo = edao.leerEnemigo(clausulaWhere);
		return enemigo;
	}

	// *********Personaje
	public static Collection<Enemigo> getPersonaje(String clausulaWhere) {
		EnemigoDAO edao = new EnemigoDAO();

		Collection<Enemigo> enemigo = edao.leerEnemigo(clausulaWhere);
		return enemigo;
	}

	// *********Enemigos
	public static Collection<Enemigo> getEnemigo(String clausulaWhere) {
		EnemigoDAO edao = new EnemigoDAO();

		Collection<Enemigo> enemigo = edao.leerEnemigo(clausulaWhere);
		return enemigo;
	}

	// *********Quests
	public static Collection<Enemigo> getQuest(String clausulaWhere) {
		EnemigoDAO edao = new EnemigoDAO();

		Collection<Enemigo> enemigo = edao.leerEnemigo(clausulaWhere);
		return enemigo;
	}
}
