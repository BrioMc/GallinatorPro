package gallinator.dwr;

import gallinator.DAO.CombateDAO;
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

/**
 * Clase principal que controla todos los metodos AJAX DWR
 */
public class Controlador {
	private UsuarioDAO udao = new UsuarioDAO();
	private CombateDAO cdao = new CombateDAO();
	private PartidaDAO pdao = new PartidaDAO();
	private QuestDAO qdao = new QuestDAO();
	private SesionPlayer player = new SesionPlayer();
	private PersonajeDAO perdao = new PersonajeDAO();
	private EnemigoDAO ndao = new EnemigoDAO();
	private PJQuestDAO pjdao = new PJQuestDAO();
	private ArrayList<Personaje> personaje = perdao.leerPersonaje("");
	private ArrayList<Quest> quest = qdao.leerQuest("");
	private ArrayList<PJQuest> pjquest = pjdao.leerPJQuest("");

	/**** Devuelve mediante una matriz el valor de cada casilla del mapa */
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

	/********************************************************** Partida ********************************************************/
	/*** Comprueba si alguna quest inicia en la casilla del personaje */
	public int initQuestPJ() {
		int inicio = 0;
		/***
		 * Si devuelve 0 --> No existe quest Si devuelve 1 --> Existe quest pero
		 * no se ha iniciado Si devuelve 2 --> Existe quest pero y se ha
		 * iniciado
		 */
		/************** Comprobar si hay quest en el sitio ************/
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

	/*** Comprueba si alguna quest finaliza en la casilla del personaje */
	public int finishQuestPJ() {
		int finish = 0;
		/***
		 * Si devuelve 0 --> No existe quest Si devuelve 1 --> Existe quest pero
		 * no se ha iniciado // Si devuelve 2 --> Existe quest pero y se ha
		 * iniciado Si devuelve 3 --> Existe quest, se ha iniciado y ha
		 * finalizado
		 */
		int id = leerSesion().getId();
		int x = leerSesion().getPosX();
		int y = leerSesion().getPosY();
		Quest quest = qdao.finishQuest(x, y);
		int idQuest = quest.getIdQuest();
		if (idQuest != 0) {
			PJQuest pjq = pjdao.takePJQuest(id, idQuest);
			if (pjq.getDone().equals("N")) {
				if (pjq.getInit().equals("Y")) {
					finish = 2;
					pjdao.updateDone(id, idQuest);
				} else {
					finish = 1;
				}
			} else {
				finish = 3;
			}
		} else {
			finish = 0;
		}
		return finish;
	}

	/***
	 * Teniendo en cuenta que exista quest, dependiendo de la opcion tomada
	 * iniciará o finalizará la quest que corresponda
	 */
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

	/****************************** INICIO QUEST ****************************/
	/****
	 * Devuelve un array con la posicion de inicio de la quest X y la posicion
	 * de la quest Y
	 * 
	 */
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

	/****************************** FINISH QUEST ****************************/
	/**
	 * Devuelve un array con la posicion de finaliza de la quest X y la posicion
	 * de la quest Y
	 */
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

	public SesionPlayer load(String user) {
		SesionPlayer load = perdao.PlayerSesion(user);
		return load;
	}

	/********************************************************** Administración ********************************************************/

	/****************************** PJ_Quest ****************************/
	/**
	 * Comprueba que cada jugador tiene creada su asociacion con cada quest, en
	 * caso de no tenerla las crea con los valores iniciales de 0(sin empezar
	 * quest)
	 */
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

	/**
	 * Da la opcion de en caso de que el administrador lo vea conveniente borrar
	 * la tupla que asocia al jugador y una quest
	 */
	public void deletePJQ(int id) {
		pjdao.delPJQ(id);
	}

	/**
	 * Devuelve un ArrayList del objeto PJQuest que se utilizará para listar o
	 * mostrar valores que se necesitan
	 */
	public ArrayList<PJQuest> listPJQ() {
		ArrayList<PJQuest> pjq = pjdao.leerPJQuest(";");
		return pjq;

	}

	/****************************** Quest ****************************/
	/**
	 * Desde la posicion devuelve si existe o no una quest, empiece o finalice.
	 */
	public boolean existQuest() {
		boolean existe = false;
		int x = leerSesion().getPosX();
		int y = leerSesion().getPosY();
		existe = qdao.existQuest(0, x, y);
		if (existe == false) {
			existe = qdao.existQuest(0, x, y);
		}
		return existe;
	}

	/**
	 * Añade una nueva quest
	 */
	public void addQuest(Quest quest) {
		qdao.addQuest(quest);
	}

	/**
	 * Devuelve una quest buscada por su id único
	 */
	public Quest seeQuest(int id) {
		Quest quest = qdao.takeQuest(id);
		return quest;
	}

	/**
	 * En caso de querer modificar una quest por fallo o por cambios se usa este
	 * metodo
	 */
	public void modQuest(Quest quest) {
		qdao.modQuest(quest);
	}

	/**
	 * Tambien en caso de querer borrar la quest, se da esa opcion
	 */
	public void deleteQuest(int id) {
		qdao.delQuest(id);
	}

	/**
	 * Devuelve un ArrayList del objeto Quest que se utilizará para listar o
	 * mostrar valores que se necesitan
	 */
	public ArrayList<Quest> listQuest() {
		ArrayList<Quest> quest = qdao.leerQuest(";");
		return quest;

	}

	/****************************** Enemy ****************************/
	/**
	 * Devuelve un objeto Enemigo buscado por su id único
	 */
	public Enemigo seeEnemy(int id) {
		Enemigo enemy = ndao.takeEnemy(id);
		return enemy;
	}

	/**
	 * Devuelve un ArrayList del objeto Enemigo que se utilizará para listar o
	 * mostrar valores que se necesitan
	 */
	public ArrayList<Enemigo> listEnemy() {
		ArrayList<Enemigo> enemy = ndao.leerEnemigo(";");
		return enemy;
	}

	/**
	 * Tambien en caso de querer borrar la quest, se da esa opcion
	 */
	public void deleteEnemy(int id) {
		ndao.delEnemy(id);
	}

	/** Devuelve los id de los enemigos */
	public int[] idsEnemy() {
		int[] id = ndao.idEnemy();
		return id;
	}

	/****************************** User ****************************/
	/**
	 * Devuelve un objeto Usuario buscado por su id único
	 */
	public Usuario seeUser(int id) {
		Usuario user = udao.takeUser(id);
		return user;
	}

	/**
	 * De igual forma si se viera necesario modificar el usuario se recurriría a
	 * este metodo
	 */
	public void modUser(Usuario user) {
		udao.modUser(user);
	}

	/**
	 * Tambien se puede borrar el usuario en caso de necesitarlo
	 */
	public void deleteUser(int id) {
		udao.delUser(id);
	}

	/**
	 * Devuelve un ArrayList del objeto Usuario quitando el admin que se
	 * utilizará para listar o mostrar valores que se necesitan
	 */
	public ArrayList<Usuario> listUser() {
		ArrayList<Usuario> quest = udao.leerUsuario("where id!=1;");
		return quest;

	}

	/****************************** Movimientos ****************************/
	/**
	 * Tomando la posicion inicial X e Y del personaje este metodo calcula en
	 * que posiciones puede moverse partiendo de la matriz antes devuelta
	 * (mediante el metodo arrayMapa())y constractando si las posiciones
	 * adyacentes al personajes de forma vertical y horizontal devolviendo un
	 * array de booleanos que indican en que posiciones es posible el movimiento
	 * en el siguiente orden: {Arriba,Derecha,Abajo,Izquierda}
	 */
	public boolean[] calculaFlechas(int x, int y) {
		/**
		 * En un principio los ponemos todos a true y mediante ifs comprobamos
		 * si se puede y en caso de no, turnamos esa posicion a false
		 */
		boolean[] result = { true, true, true, true };
		/**
		 * Ladrillos -->2,20,21,19,17,11,18,9 // Piedra
		 * -->25,26,27,35,43,42,41,33 // Objetos -->31,47,40,38,46
		 */
		int pos[][] = arrayMapa();
		int posX;
		int posY;
		/** Este es el array de los valores de las casillas bloqueadas */
		int[] blockTileds = { 28, 44, 36, 45, 37, 31, 2, 47, 40, 38, 46, 25,
				26, 27, 35, 43, 42, 41, 33, 11, 18, 9, 20, 21, 19, 17 };
		/**
		 * Mediante este bucle lleno de if y else, comprueba que posiciones si
		 * pueden ser viables teniendo en cuenta todo, por ejemplo si el
		 * personaje está en la esquina izquierda superior del mapa: posicion
		 * 0:0, tiene que dar por sentado que no se puede mover ni hacia Arriba
		 * ni hacia la izquierda y así sucesivamente.
		 */
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

	/**
	 * Tras calcular las flechas y clicar sobre una flecha, mediante ajax DWR
	 * este metodo recibe la posicion, el id y el nombre de usuario el cual
	 * guarda en la base de datos de forma automatica con cada movimiento del
	 * personaje a forma de autoguardado(Lo utilizo para la beta del juego ya
	 * que despues funcionará con sesion y un boton de guardar partida)
	 */
	public void mueve(int x, int y, int id, String user) {
		player.setPosX(x);
		player.setPosY(y);
		player.setId(id);
		pdao.savePosition(player);
		saveSesion(user);
	}

	/****************************** Guardar y Cargar ****************************/
	/**
	 * Metodo en fase beta que lo que hará será modificar la sesion para
	 * continuar la partida sin necesidad de tocar la base de datos
	 */
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

	/**
	 * Guarda las caracteristicas tras la batalla (Experiencia obtenida, vida
	 * restante, nivel, score etc)
	 */
	public void afterBattle(Enemigo enemy, Personaje pj) {
		cdao.actStatusBattle(enemy, pj);
	}

	/**
	 * Tras Mover, debido a eventos u quest los atributos de sesion pueden
	 * cambiar de forma que se leen de nuevo para mostrarlos por pantalla
	 */
	public SesionPlayer leerSesion() {
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		SesionPlayer na = (SesionPlayer) req.getSession().getAttribute(
				"SesionPlayer");
		return na;
	}

	/**
	 * Coge los datos del personaje de la base de datos para rellenar el objeto
	 * y actualiza la sesion con los nuevos cambios anteriormente producidos
	 */
	public void saveSesion(String user) {
		SesionPlayer sesion = perdao.PlayerSesion(user);
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		req.getSession().setAttribute("SesionPlayer", sesion);
	}

	/**
	 * Como su propio nombre indica, invalida la sesion y devuelve a la pagina
	 * principal
	 */
	public void closeSession() {
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		HttpSession sesion = req.getSession();
		sesion.invalidate();
	}
}
