package model;

import javax.swing.event.EventListenerList;

public class Model {

	private EventListenerList listeners = new EventListenerList();
	
	public void addMenuListener(MenuListener listener) {
		listeners.add(MenuListener.class, listener);
	}
	
	
	public void removeInitializedNbCardListener(MenuListener listener) {
		listeners.remove(MenuListener.class, listener);
	}
	
	
	public void fireInitializedNbCard() {
		MenuListener[] listenerList = 
				(MenuListener[])listeners.getListeners(MenuListener.class);
		
		for(MenuListener listener : listenerList) {
			listener.Menu(new MenuEvent(this));
		}
	}

}
