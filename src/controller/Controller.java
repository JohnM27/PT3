package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import view.GameView;
import view.MenuView;

/**
 * The Controller of the MVC pattern,
 * it possess a {@link Model},
 * a {@link MenuView}
 * and a {@link GameView}
 */
public class Controller extends MouseAdapter implements ActionListener{
	private Model model; 
	private MenuView menuView;
	private GameView gameView;
	
	private int[] mouseCoord = new int[2];
	
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
		model.addGlobalListener(gameView);
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
		gameView = new GameView(this);
		addListenersToModel();
		model.fireMapGenerated();
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
	 * Calls the method <code>about()</code> from
	 * the {@link MenuView}
	 */
	public void about() {
		menuView.about();
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
			model.fireJourChanged();
		else if(e.getActionCommand().equals("BUY"))
			model.fireFogOff();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mouseCoord[0] = e.getX()/61;
		mouseCoord[1] = e.getY()/61;
		
		//inversion des coordonnées pour correspondre au tableau
		if(!model.getPossessed(mouseCoord[1], mouseCoord[0])) {
			//on remplacera par l'affichage d'un bouton "acheter" dans le panneau en dessous
			model.fireModifySCPanel(mouseCoord[1], mouseCoord[0]);
		}
		else {
			//la case appartient au joueur donc on regarde le type de la case et en fonction du type de la case on affiche
			
		}
	}
}
