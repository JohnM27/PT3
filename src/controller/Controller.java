package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Model;
import view.DungeonView;
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
	private DungeonView dungeonView;
	
	private boolean cityHall = false;
	
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
		model.addGameListener(gameView);
		model.addDungeonListener(dungeonView);
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
		dungeonView = new DungeonView(this, gameView.getFrame());
		addListenersToModel();
		model.fireMapGenerated();
		gameView.display();
	}
	
	/**
	 * Starts an old game by closing the {@link MenuView},
	 * then launching a new instance of {@link GameView}
	 * If he can't read he file, then execute new game method
	 */
	public void loadGame() {
		gameView = new GameView(this);
		dungeonView = new DungeonView(this, gameView.getFrame());
		
		ObjectInputStream ois = null;
		
		try {
			FileInputStream fichier = new FileInputStream("game.save");
			ois = new ObjectInputStream(fichier);
			
			model = (Model) ois.readObject();
		} catch (FileNotFoundException e) {
			newGame();
		} catch (IOException e) {
			newGame();
		} catch (ClassNotFoundException e) {
			newGame();
		} finally {
			try { 
				if (ois != null) {
					ois.close();
					if(menuView != null) {
						closeMenuView();
					}
					addListenersToModel();
					model.fireRefresh();
					gameView.display();
				}
			} catch (IOException ex) {
				newGame();
			}
		}
		
	}
	
	/**
	 * Starts the menu by launching a new instance of
	 * {@link MenuView}
	 */
	public void save() {
		ObjectOutputStream oos = null;
		
		try {
			final FileOutputStream fichier = new FileOutputStream("game.save");
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(model);
			
			oos.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
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
		else if(e.getActionCommand().equals("Load Game"))
			loadGame();
		else if(e.getActionCommand().equals("About"))
			about();
		else if(e.getActionCommand().equals("Exit") && menuView != null)
			closeMenuView();
		else if(e.getActionCommand().equals("Exit"))
			gameView.exit();
		else if(e.getActionCommand().equals("Game Change")) {
			gameView.close();
			dungeonView.display();
		}			
		else if(e.getActionCommand().equals("Dungeon Change")) {
			dungeonView.close();
			gameView.display();
		}
		else if(e.getActionCommand().equals("Save"))
			save();
		else if(e.getActionCommand().equals("Jour suivant"))
			model.fireJourChanged();
		else if(e.getActionCommand().equals("BUY")) {
			model.fireFogOff();
		}
		else if(e.getActionCommand().equals("BUILD City Hall")) {
			cityHall = true;
			model.fireCityHallOn();
		}
		else if(e.getActionCommand().equals("BUILD House"))
			model.fireHouseOn();
		else if(e.getActionCommand().equals("BUILD Farm"))
			model.fireFarmOn();
		else if(e.getActionCommand().equals("BUILD Fishing"))
			model.fireFishingOn();
		else if(e.getActionCommand().equals("BUILD Logging"))
			model.fireLoggingOn();
		else if(e.getActionCommand().equals("BUILD Mine"))
			model.fireMineOn();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mouseCoord[0] = e.getX()/61;
		mouseCoord[1] = e.getY()/61;
		
		model.fireSelected(mouseCoord[1], mouseCoord[0]);
		//inversion des coordonnées pour correspondre au tableau
		if(!model.getPossessed(mouseCoord[1], mouseCoord[0])) {
			model.fireModifySCPanel(mouseCoord[1], mouseCoord[0]);
		}
		else {
			//la case appartient au joueur donc on regarde le type de la case et en fonction du type de la case on affiche
			if(cityHall) {
				if(model.getTypeCase(mouseCoord[1], mouseCoord[0]).equals("model.Plain")) {
					model.fireModifyPlainSCPanel(mouseCoord[1], mouseCoord[0]);
				}
				else if(model.getTypeCase(mouseCoord[1], mouseCoord[0]).equals("model.Forest")) {
					model.fireModifyForestSCPanel(mouseCoord[1], mouseCoord[0]);
				}
				else if(model.getTypeCase(mouseCoord[1], mouseCoord[0]).equals("model.Mountain")) {
					model.fireModifyMountainSCPanel(mouseCoord[1], mouseCoord[0]);
				}
				else if(model.getTypeCase(mouseCoord[1], mouseCoord[0]).equals("model.Water")) {
					model.fireModifyWaterSCPanel(mouseCoord[1], mouseCoord[0]);
				}
			}
			else {
				model.fireModifyPlainCHSCPanel(mouseCoord[1], mouseCoord[0]);
			}
		}
	}
}
