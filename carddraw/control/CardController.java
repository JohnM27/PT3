package control;

import model.CardModel;
import view.CardView;

public class CardController {

	private CardModel model;
	private CardView view;
	
	
	public CardController(CardModel model) {
		this.model = model;
		
		view = new CardFrameView(this);
		
		addListenersToModel();
	}
	
	
	private void addListenersToModel() {
		model.addInitializedNbCardListener(view);
	}
	
	
	public void displayView() {
		view.display();
	}
	
	
	public void closeView() {
		view.close();
	}
	
	
	public void setNbCard(int nbCard) {
		model.setNbCard(nbCard);
		System.out.println("1- Controller receives nbCard from button: " + nbCard);
	}
}
