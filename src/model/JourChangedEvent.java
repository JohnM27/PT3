package model;

import java.util.EventObject;

public class JourChangedEvent extends EventObject {
	private int nbJour;

	public JourChangedEvent(Object source, int nbJour) {
		super(source);
		
		this.nbJour = nbJour;
	}
	
	public int getJourChanged() {
		return nbJour;
	}
}
