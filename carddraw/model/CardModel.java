package model;

import javax.swing.event.EventListenerList;

public class CardModel {
	
	private EventListenerList listeners = new EventListenerList();
	
	private int nbCard;
	//private BufferedImage[] cardInHand;
	
	
	public int getNbCard() {
		return nbCard;
	}
	
	
	public void setNbCard(int nbCard) {
		this.nbCard = nbCard;
		//setCardInHand();
		fireInitializedNbCard();
		System.out.println("2- Model receives nbCard from Controller: " + this.nbCard);
	}
	
	/*
	public void setCardInHand() {
		cardInHand = new BufferedImage[nbCard];
	}*/
	
	
	public void addInitializedNbCardListener(InitializedNbCardListener listener) {
		listeners.add(InitializedNbCardListener.class, listener);
	}
	
	
	public void removeInitializedNbCardListener(InitializedNbCardListener listener) {
		listeners.remove(InitializedNbCardListener.class, listener);
	}
	
	
	public void fireInitializedNbCard() {
		InitializedNbCardListener[] listenerList = 
				(InitializedNbCardListener[])listeners.getListeners(InitializedNbCardListener.class);
		
		for(InitializedNbCardListener listener : listenerList) {
			listener.InitializedNbCard(new InitializedNbCardEvent(this, getNbCard()));
		}
	}
}
