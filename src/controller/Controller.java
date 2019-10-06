package controller;

import view.GameView;
import view.MenuView;
import view.View;

import model.Model;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model model) {
		this.model = model;
		
		view = new MenuView(this);
		
		addListenersToModel();
	}
	
	private void addListenersToModel() {
		model.addJourListener(view);
	}
	
	public void displayView() {
		view.display();
	}
	
	public void closeView() {
		view.close();
	}

	public void newGame() {
		view.close();
		view = new GameView(this, 0);
		view.display();
	}
	
	public void menu() {
		view.close();
		view = new MenuView(this);
		view.display();
	}

	public void about() {
		view.about();
		
	}
	
	public void notifyVolumeChanged(int nbJour) {
		model.setNbJour(nbJour);
	}
}
