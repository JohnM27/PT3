package model;

import javax.swing.event.EventListenerList;

public class Model {

	private EventListenerList listenersList;
	private int nbJour;

	public Model() {
		listenersList = new EventListenerList();
		
		nbJour = 0;
	}
	
	public void setNbJour(int nbJour) {
		this.nbJour = nbJour;
		
		fireInitializedNbCard();
	}
	
	public int getNbJour() {
		return nbJour;
	}
	
	public void addJourListener(JourListener listener) {
		listenersList.add(JourListener.class, listener);
	}
	
	
	public void removeInitializedNbCardListener(JourListener listener) {
		listenersList.remove(JourListener.class, listener);
	}
	
	
	public void fireInitializedNbCard() {
		JourListener[] listenerList = 
				(JourListener[])listenersList.getListeners(JourListener.class);
		
		for(JourListener listener : listenerList)
			listener.jourChanged(new JourChangedEvent(this, nbJour));
	}
}