package controller;

import view.GameView;
import view.MenuView;
import view.View;

import model.Model;

public class Controller {
	private Model model;
	private MenuView menuView;
	private GameView gameView;
	
	public Controller(Model model) {
		this.model = model;
		
		menuView = new MenuView(this);
	}
	
	private void addListenersToModel() {
		model.addJourListener(gameView);
	}
	
	public void displayView() {
		menuView.display();
	}
	
	public void closeView() {
		menuView.close();
		gameView.close();
	}

	public void newGame() {
		menuView.close();
		gameView = new GameView(this, 0);
		addListenersToModel();
		gameView.display();
	}
	
	public void menu() {
		gameView.close();
		menuView = new MenuView(this);
		menuView.display();
	}

	public void about() {
		menuView.about();
		
	}
	
	public void notifyJourChanged(int nbJour) {
		model.setNbJour(nbJour);
	}
}
