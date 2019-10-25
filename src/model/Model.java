package model;

import javax.swing.event.EventListenerList;

public class Model {

	private EventListenerList listenersList;
	private int nbJour;
	private Map m = new Map();

	public Model() {
		listenersList = new EventListenerList();
		nbJour = 0;
	}
	
	public boolean getPossessed(int i, int j) {
		return m.getPossessed(i, j);
	}
	
	public void addGlobalListener(GlobalListener listener) {
		listenersList.add(GlobalListener.class, listener);
	}
	
	
	public void removeGlobalListener(GlobalListener listener) {
		listenersList.remove(GlobalListener.class, listener);
	}
	
	public void fireJourChanged() {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		nbJour++;
		
		for(GlobalListener listener : listenerList)
			listener.jourChanged(new JourChangedEvent(this, nbJour));
	}
	
	public void fireMapGenerated() {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.genererMap();
		
		for(GlobalListener listener : listenerList)
			listener.MapGenerated(new MapGeneratedEvent(this, m.getAllImages(), m.getAllImagesOver()));
	}
	
	//Enleve le brouillard d'une case
	public void fireFogOff(int i, int j) {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.setImageOver(i, j);
		m.setPossessed(i, j);
		
		for(GlobalListener listener : listenerList)
			listener.FogOff(new FogOffEvent(this, i, j));
	}
}