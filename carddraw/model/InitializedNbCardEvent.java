package model;

import java.util.EventObject;

@SuppressWarnings("serial")
public class InitializedNbCardEvent extends EventObject {

	private int nbCard;
	
	public InitializedNbCardEvent(Object obj, int nbCard) {
		super(obj);
		
		this.nbCard = nbCard;
	}

	public int getNbCard() {
		return nbCard;
	}
}
