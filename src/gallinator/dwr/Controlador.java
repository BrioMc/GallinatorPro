package gallinator.dwr;

import gallinator.DAO.*;
import gallinator.bean.*;
import gallinator.json.*;
import gallinator.tileMap.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class Controlador {
	UsuarioDAO udao = new UsuarioDAO();
	SesionPlayer player = new SesionPlayer();
	PartidaDAO pdao = new PartidaDAO();

	public int[][] arrayMapa() {
		Mapa mapa = MapaJson.mapa(0);
		Layers[] layerse;
		layerse = mapa.getLayers();
		Layers layer = new Layers();
		layer = layerse[0];
		mapa.getLayers();
		int array[] = layer.getData();
		int c = -1;
		int arrayTiled[][] = new int[18][28];
		for (int y = 0; y < 18; y++) {
			for (int x = 0; x < 28; x++) {
				c++;
				arrayTiled[y][x] = array[c];
			}
		}

		return arrayTiled;
	}

	public static Estado status() {
		Estado estado = new Estado();
		return estado;
	}

	public static void guardaPartida() {

		// ObjectMapper mapper = new ObjectMapper();
		// String json= mapper.writeValueAsString(osesion);

	}

	public SesionPlayer load(String user) {
		SesionPlayer load = udao.PlayerSesion(user);

		// objeto <- BBDD
		return load;
	}

	public void save(SesionPlayer e) {
		// objeto -> BBDD
	}

	/**************************** Movimientos ****************************/
	public boolean[] calculaFlechas(int x, int y) {
		boolean[] result = { true, true, true, true };
		// Ladrillos -->2,11,18,9,20,21,19,17
		// Piedra -->25,26,27,35,43,42,41,33
		// Objetos -->31,47,40,38,46
		int pos[][] = arrayMapa();
		int posX;
		int posY;
		int[] blockTileds = { 31, 47, 40, 38, 46, 25, 26, 27, 35, 43, 42, 41,
				33, 2, 11, 18, 9, 20, 21, 19, 17 };
		for (int v = 0; v < blockTileds.length; v++) {
			// arriba
			posX = x;
			posY = y - 1;
			System.out.println(x+"___"+y);
			if (blockTileds[v] == pos[posY][posX]) {
				result[0] = false;
			}

			// derecha
			posX = x + 1;
			posY = y;
			if (blockTileds[v] == pos[posY][posX]) {

				result[1] = false;
			}

			// abajo
			posX = x;
			posY = y + 1;
			if (blockTileds[v] == pos[posY][posX]) {
				result[2] = false;
			}
			// izquierda
			posX = x - 1;
			posY = y;
			if (blockTileds[v] == pos[posY][posX]) {
				result[3] = false;
			}
		}

		return result;
	}

	public SesionPlayer leerSesion() {
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		SesionPlayer na = (SesionPlayer) req.getSession().getAttribute(
				"SesionPlayer");
		return na;
	}

	public void saveSesion(String user) {
		SesionPlayer sesion = udao.PlayerSesion(user);
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		HttpServletResponse res = ctx.getHttpServletResponse();
		req.getSession().setAttribute("SesionPlayer", sesion);
		try {
			res.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeSession(){
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		HttpSession sesion = req.getSession();
		sesion.invalidate();
	}
	public void mueve(int x, int y, int id, String user) {
		player.setPosX(x);
		player.setPosY(y);
		player.setId(id);
		pdao.savePosition(player);
		saveSesion(user);
	}
}
