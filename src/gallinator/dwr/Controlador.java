package gallinator.dwr;

import gallinator.DAO.EnemigoDAO;
import gallinator.DAO.PartidaDAO;
import gallinator.DAO.PersonajeDAO;
import gallinator.DAO.QuestDAO;
import gallinator.DAO.UsuarioDAO;
import gallinator.bean.SesionPlayer;
import gallinator.json.MapaJson;
import gallinator.modelo.Enemigo;
import gallinator.modelo.Quest;
import gallinator.modelo.Usuario;
import gallinator.tileMap.Layers;
import gallinator.tileMap.Mapa;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class Controlador {
	UsuarioDAO udao = new UsuarioDAO();
	PartidaDAO pdao = new PartidaDAO();
	QuestDAO qdao = new QuestDAO();
	SesionPlayer player = new SesionPlayer();
	PersonajeDAO perdao = new PersonajeDAO();
	EnemigoDAO ndao = new EnemigoDAO();

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

	public SesionPlayer load(String user) {
		SesionPlayer load = perdao.PlayerSesion(user);

		// objeto <- BBDD
		return load;
	}

	/**************************** Administración ****************************/
	/**************************** Quest ****************************/
	public void addQuest(Quest quest) {
		qdao.addQuest(quest);
	}

	public Quest seeQuest(int id) {
		Quest quest = qdao.takeQuest(id);
		return quest;
	}

	public void modQuest(Quest quest) {
		qdao.modQuest(quest);
	}

	public void deleteQuest(int id) {
		qdao.delQuest(id);
	}

	public ArrayList<Quest> listQuest() {
		ArrayList<Quest> quest = qdao.leerQuest(";");
		return quest;

	}

	/**************************** Enemy ****************************/

	public Enemigo seeEnemy(int id) {
		Enemigo enemy = ndao.takeEnemy(id);
		return enemy;
	}

	public ArrayList<Enemigo> listEnemy() {
		ArrayList<Enemigo> enemy = ndao.leerEnemigo(";");
		return enemy;
	}

	public void deleteEnemy(int id) {
		ndao.delEnemy(id);
	}

	/**************************** User ****************************/
	public Usuario seeUser(int id) {
		Usuario user = udao.takeUser(id);
		return user;
	}

	public void modUser(Usuario user) {
		udao.modUser(user);
	}

	public void deleteUser(int id) {
		udao.delUser(id);
	}

	public ArrayList<Usuario> listUser() {
		ArrayList<Usuario> quest = udao.leerUsuario("where id!=1;");
		return quest;

	}

	/**************************** Movimientos ****************************/
	public boolean[] calculaFlechas(int x, int y) {
		boolean[] result = { true, true, true, true };
		// Ladrillos -->2,20,21,19,17,11,18,9
		// Piedra -->25,26,27,35,43,42,41,33
		// Objetos -->31,47,40,38,46
		int pos[][] = arrayMapa();
		int posX;
		int posY;
		int[] blockTileds = { 28, 44, 36, 45, 37, 31, 2, 47, 40, 38, 46, 25,
				26, 27, 35, 43, 42, 41, 33, 11, 18, 9, 20, 21, 19, 17 };
		for (int v = 0; v < blockTileds.length; v++) {
			if (x == 0) {
				result[3] = false;
				if (y == 0) {
					result[0] = false;
					// abajo
					posX = x;
					posY = y + 1;
					if (blockTileds[v] == pos[posY][posX]) {
						result[2] = false;
					}
					// derecha
					posX = x + 1;
					posY = y;
					if (blockTileds[v] == pos[posY][posX]) {
						result[1] = false;
					}
				} else if (y == 17) {
					result[2] = false;
					// arriba
					posX = x;
					posY = y - 1;
					if (blockTileds[v] == pos[posY][posX]) {
						result[0] = false;
					}
					// derecha
					posX = x + 1;
					posY = y;
					if (blockTileds[v] == pos[posY][posX]) {
						result[1] = false;
					}
				} else {
					// arriba
					posX = x;
					posY = y - 1;
					if (blockTileds[v] == pos[posY][posX]) {
						result[0] = false;
					}
					// abajo
					posX = x;
					posY = y + 1;
					if (blockTileds[v] == pos[posY][posX]) {
						result[2] = false;
					}
					// derecha
					posX = x + 1;
					posY = y;
					if (blockTileds[v] == pos[posY][posX]) {
						result[1] = false;
					}
				}

			} else {
				if (x == 27) {
					result[1] = false;
					if (y == 0) {
						result[0] = false;
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
					} else if (y == 17) {
						result[2] = false;
						// arriba
						posX = x;
						posY = y - 1;
						if (blockTileds[v] == pos[posY][posX]) {
							result[0] = false;
						}
						// izquierda
						posX = x - 1;
						posY = y;
						if (blockTileds[v] == pos[posY][posX]) {
							result[3] = false;
						}
					} else {
						// arriba
						posX = x;
						posY = y - 1;
						if (blockTileds[v] == pos[posY][posX]) {
							result[0] = false;
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
				} else {
					if (y == 0) {
						result[0] = false;
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
						// derecha
						posX = x + 1;
						posY = y;
						if (blockTileds[v] == pos[posY][posX]) {
							result[1] = false;
						}
					} else if (y == 17) {
						result[2] = false;
						// arriba
						posX = x;
						posY = y - 1;
						if (blockTileds[v] == pos[posY][posX]) {
							result[0] = false;
						}
						// izquierda
						posX = x - 1;
						posY = y;
						if (blockTileds[v] == pos[posY][posX]) {
							result[3] = false;
						}
						// derecha
						posX = x + 1;
						posY = y;
						if (blockTileds[v] == pos[posY][posX]) {
							result[1] = false;
						}
					} else {
						// arriba
						posX = x;
						posY = y - 1;
						if (blockTileds[v] == pos[posY][posX]) {
							result[0] = false;
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
						// derecha
						posX = x + 1;
						posY = y;
						if (blockTileds[v] == pos[posY][posX]) {
							result[1] = false;
						}
					}
				}
			}

		}

		return result;
	}

	public void mueve(int x, int y, int id, String user) {
		player.setPosX(x);
		player.setPosY(y);
		player.setId(id);
		pdao.savePosition(player);
		saveSesion(user);
	}

	/**************************** Guardar y Cargar ****************************/
	public void modSession(SesionPlayer player) {
		SesionPlayer mod = leerSesion();
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		mod.setDmgF(player.getDmgF());
		mod.setDmgH(player.getDmgH());
		mod.setMana(player.getMana());
		mod.setMaxMana(player.getMaxMana());
		mod.setSangre(player.getSangre());
		mod.setMaxSangre(player.getMaxSangre());
		mod.setExp(player.getExp());
		req.getSession().setAttribute("SesionPlayer", mod);
	}

	public SesionPlayer leerSesion() {
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		SesionPlayer na = (SesionPlayer) req.getSession().getAttribute(
				"SesionPlayer");
		return na;
	}

	public void saveSesion(String user) {
		SesionPlayer sesion = perdao.PlayerSesion(user);
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		req.getSession().setAttribute("SesionPlayer", sesion);
	}

	public void closeSession() {
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		HttpSession sesion = req.getSession();
		sesion.invalidate();
	}
}
