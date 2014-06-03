package gallinator.listabean;

import gallinator.modelo.ModelFackade;
import gallinator.modelo.PJQuest;

import java.util.Collection;

public class ListaPJQuest {
	private String clausulaWhere = new String();

	public String getClausulaWhere() {
		return clausulaWhere;
	}

	public void setClausulaWhere(String clausulaWhere) {
		this.clausulaWhere = clausulaWhere;
	}

	public Collection<PJQuest> getPJQuest() {

		Collection<PJQuest> pjquest= ModelFackade.getPJQuest(clausulaWhere);
		return pjquest;
	}
}
