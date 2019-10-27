package model;

import java.awt.Image;

import javax.swing.event.EventListenerList;

public class Model {

	private EventListenerList listenersList;
	private int nbJour;
	private Map m = new Map();
	private int[] coord = new int[2];

	public Model() {
		listenersList = new EventListenerList();
		nbJour = 0;
	}
	
	public int getNbJour() {
		return nbJour;
	}
	
	public Image[][] getImg() {
		return m.getAllImages();
	}

	public Image[][] getImgOver() {
		return m.getAllImagesOver();
	}
	
	public int[] getCoord() {
		return coord;
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
			listener.jourChanged(new MapEvent(this));
	}
	
	public void fireMapGenerated() {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.genererMap();
		
		for(GlobalListener listener : listenerList)
			listener.MapGenerated(new MapEvent(this));
	}
	
	//Enleve le brouillard d'une case
	public void fireFogOff(int i, int j) {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.setImageOver(i, j);
		m.setPossessed(i, j);
		coord[0] = i;
		coord[1] = j;
		
		for(GlobalListener listener : listenerList)
			listener.FogOff(new MapEvent(this));
	}
}