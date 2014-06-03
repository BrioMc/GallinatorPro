package gallinator.bean;

import java.io.Serializable;

public class PJQuestBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idquest_personaje;
	private int quest;
	private int personaje;
	private String init;
	private String done;

	public int getIdquest_personaje() {
		return idquest_personaje;
	}

	public void setIdquest_personaje(int idquest_personaje) {
		this.idquest_personaje = idquest_personaje;
	}

	public int getQuest() {
		return quest;
	}

	public void setQuest(int quest) {
		this.quest = quest;
	}

	public int getPersonaje() {
		return personaje;
	}

	public void setPersonaje(int personaje) {
		this.personaje = personaje;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}
}
