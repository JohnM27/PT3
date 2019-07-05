package controller;

import view.GameView;
import view.MenuView;
import view.View;

//import model;

public class Controller {
	//private Model model;
	private View view;
	
	public Controller(/*Model model*/) {
		//this.model = model;
		
		view = new MenuView(this);
		
		//addListenersToModel();
	}
	
	/*private void addListenersToModel() {
		
	}*/
	
	public void displayView() {
		view.display();
	}
	
	public void closeView() {
		view.close();
	}

	public void newGame() {
		view.close();
		view = new GameView(this);
		view.display();
	}

	public void about() {
		view.about();
		
	}
	
	
}
