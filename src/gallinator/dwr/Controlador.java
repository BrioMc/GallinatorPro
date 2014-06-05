package gallinator.dwr;

import gallinator.DAO.EnemigoDAO;
import gallinator.DAO.PJQuestDAO;
import gallinator.DAO.PartidaDAO;
import gallinator.DAO.PersonajeDAO;
import gallinator.DAO.QuestDAO;
import gallinator.DAO.UsuarioDAO;
import gallinator.bean.SesionPlayer;
import gallinator.json.MapaJson;
import gallinator.modelo.Enemigo;
import gallinator.modelo.PJQuest;
import gallinator.modelo.Personaje;
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
	private UsuarioDAO udao = new UsuarioDAO();
	private PartidaDAO pdao = new PartidaDAO();
	private QuestDAO qdao = new QuestDAO();
	private SesionPlayer player = new SesionPlayer();
	private PersonajeDAO perdao = new PersonajeDAO();
	private EnemigoDAO ndao = new EnemigoDAO();
	private PJQuestDAO pjdao = new PJQuestDAO();
	private ArrayList<Personaje> personaje = perdao.leerPersonaje("");
	private ArrayList<Quest> quest = qdao.leerQuest("");
	private ArrayList<PJQuest> pjquest = pjdao.leerPJQuest("");

	/******************************************************** Partida ********************************************************/

	public int initQuestPJ() {
		int inicio = 0;
		// Si devuelve 0 --> No existe quest
		// Si devuelve 1 --> Existe quest pero no se ha iniciado
		// Si devuelve 2 --> Existe quest pero y se ha iniciado
		/************ Comprobar si hay quest en el sitio ************/
		int id = leerSesion().getId();
		int x = leerSesion().getPosX();
		int y = leerSesion().getPosY();
		Quest quest = qdao.initQuest(x, y);
		int idQuest = quest.getIdQuest();
		if (idQuest != 0) {
			PJQuest pjq = pjdao.takePJQuest(id, idQuest);
			if (pjq.getInit().equals("Y")) {
				inicio = 2;
			} else {
				inicio = 1;
				pjdao.updateInit(id, idQuest);
			}
		} else {
			inicio = 0;
		}

		return inicio;
	}

	public int finishQuestPJ() {
		int finish = 0;
		// Si devuelve 0 --> No existe quest
		// Si devuelve 1 --> Existe quest pero no se ha iniciado
		// Si devuelve 2 --> Existe quest pero y se ha iniciado
		int id = leerSesion().getId();
		int x = leerSesion().getPosX();
		int y = leerSesion().getPosY();
		Quest quest = qdao.finishQuest(x, y);
		int idQuest = quest.getIdQuest();
		if (idQuest != 0) {
			PJQuest pjq = pjdao.takePJQuest(id, idQuest);
			if (pjq.getInit().equals("Y")) {
				finish = 2;
				pjdao.updateDone(id, idQuest);
			} else {
				finish = 1;
			}
		} else {
			finish = 0;
		}
		return finish;
	}

	public Quest takeQuest(int option) {
		Quest que = new Quest();
		int x = leerSesion().getPosX();
		int y = leerSesion().getPosY();
		if (option == 1) {
			que = qdao.initQuest(x, y);
		} else {
			que = qdao.finishQuest(x, y);
		}
		return que;
	}

	/**************************** INICIO QUEST ****************************/
	public int[] initXQuest() {
		int[] initX = new int[quest.size()];
		for (int i = 0; i < quest.size(); i++) {
			Quest ques = quest.get(i);
			initX[i] = ques.getPosX_init();
		}
		return initX;
	}

	public int[] initYQuest() {
		int[] initY = new int[quest.size()];
		for (int i = 0; i < quest.size(); i++) {
			Quest ques = quest.get(i);
			initY[i] = ques.getPosY_init();
		}
		return initY;
	}

	/**************************** FINISH QUEST ****************************/
	public int[] finishXQuest() {
		int[] finishX = new int[quest.size()];
		for (int i = 0; i < quest.size(); i++) {
			Quest ques = quest.get(i);
			finishX[i] = ques.getPosX_finish();
		}
		return finishX;
	}

	public int[] finishYQuest() {
		int[] finishY = new int[quest.size()];
		for (int i = 0; i < quest.size(); i++) {
			Quest ques = quest.get(i);
			finishY[i] = ques.getPosY_finish();
		}
		return finishY;
	}

	/**************************** Inicio Quest ****************************/

	/**************************** FINISH QUEST ****************************/
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

	public void comprobarQuests() {
		int personajes = personaje.size();
		int quests = quest.size();
		Personaje pjPlayer = new Personaje();
		Quest pjQuest = new Quest();
		boolean exito = false;
		for (int a = 0; a < personajes; a++) {
			pjPlayer = (Personaje) personaje.get(a);
			int pj = pjPlayer.getId();
			for (int b = 0; b < quests; b++) {
				pjQuest = (Quest) quest.get(b);
				int pjq = pjQuest.getIdQuest();
				exito = pjdao.existPJQuest(pj, pjq);
				if (!exito) {
					pjdao.insertPJQuest(pj, pjq);
				}
			}
		}
	}

	public void deletePJQ(int id) {
		pjdao.delPJQ(id);
	}
	public ArrayList<PJQuest> listPJQ() {
		ArrayList<PJQuest> pjq = pjdao.leerPJQuest(";");
		return pjq;

	}
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
