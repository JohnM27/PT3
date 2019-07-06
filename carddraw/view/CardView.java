package view;

import control.CardController;
import model.InitializedNbCardListener;

public abstract class CardView implements InitializedNbCardListener {

	private CardController controller;
	
	
	public CardView(CardController controller) {
		super();
		
		this.controller = controller;
	}

	
	public CardController getController() {
		return controller;
	}
	
	
	public abstract void display();
	public abstract void close();
}
