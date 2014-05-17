package gallinator.modelo;

import gallinator.DAO.UsuarioDAO;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtilsBean;

public class ModelFackade {

	// Registro de Usuario
	public static void crearUsuario(User UsuBean) throws IOException {
		User usuario = new User();
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
		Personaje player = new Personaje();
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
}
