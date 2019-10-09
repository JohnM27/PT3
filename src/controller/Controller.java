package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.GameView;
import view.MenuView;

/**
 * The Controller of the MVC pattern,
 * it possess a {@link Model},
 * a {@link MenuView}
 * and a {@link GameView}
 */
public class Controller implements ActionListener{
	private Model model; 
	private MenuView menuView;
	private GameView gameView;
	
	/**
	 * Creates a new Controller with the specified model
	 */
	public Controller(Model model) {
		this.model = model;
		
		menuView = new MenuView(this);
		menuView.display();
	}
	
	/**
	 * Calls the method {@link addJourListener()} from the {@link Model}
	 */
	private void addListenersToModel() {
		model.addJourListener(gameView);
	}
	
	/**
	 * Closes the {@link MenuView} in the {@link Model}
	 */	
	public void closeMenuView() {
		menuView.close();
		menuView = null;
	}
	
	/**
	 * Closes the {@link GameView} in the {@link Model}
	 */
	public void closeGameView() {
		gameView.close();
	}

	/**
	 * Starts a new game by closing the {@link MenuView},
	 * then launching a new instance of {@link GameView}
	 */
	public void newGame() {
		closeMenuView();
		gameView = new GameView(this, 0);
		addListenersToModel();
		gameView.display();
	}
	
	/**
	 * Starts the menu by launching a new instance of
	 * {@link MenuView}
	 */
	public void menu() {
		closeGameView();
		menuView = new MenuView(this);
		menuView.display();
	}
	
	/**
	 * Calls the method {@link about()} from
	 * the {@link MenuView}
	 */
	public void about() {
		menuView.about();
	}
	
	/**
	 * Calls the method {@link setNbJour(int nbJour)} from
	 * the {@link Model}
	 * @param nbJour: Nombre du jour
	 */
	public void notifyJourChanged(int nbJour) {
		model.setNbJour(nbJour);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("New Game"))
			newGame();
		else if(e.getActionCommand().equals("About"))
			about();
		else if(e.getActionCommand().equals("Exit") && menuView != null)
			closeMenuView();
		else if(e.getActionCommand().equals("Exit"))
			closeGameView();
		else if(e.getActionCommand().equals("Menu"))
			menu();
		else if(e.getActionCommand().equals("Jour suivant"))
			notifyJourChanged(gameView.getHudSPanel().getDroite().getNbJour()+1);
	}
}
