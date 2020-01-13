package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;
import model.GameListener;
import model.MapEvent;

public class GameView extends View implements GameListener{

	private Controller controller;
	
	private JFrame frame;
	
	private HudWPanel HudWPanel;
	private HudSPanel HudSPanel;
	private HudCPanel HudCPanel;
	private JDialog eventPanel;
	
	/**
	 * Constructs a GameView with the specified controller and by
	 * calling the method <code>buildFrame()</code>.
	 * @param controller
	 */
	public GameView(Controller controller) {
		super(controller);

		this.controller = controller;
		
		buildFrame();
	}

	/**
	 * Builds the game's frame
	 */
	private void buildFrame() {
		frame = new JFrame("Jeu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		HudWPanel = new HudWPanel();
		HudSPanel = new HudSPanel(controller);
		HudCPanel = new HudCPanel(controller);
		
		frame.setResizable(false);
		
	}
	
	/**
	 * Displays the frame.
	 */
	@Override
	public void display() {
		frame.add(HudWPanel, BorderLayout.WEST);
		frame.add(HudSPanel, BorderLayout.SOUTH);
		frame.add(HudCPanel, BorderLayout.CENTER);

		frame.revalidate();
		frame.repaint();
		
		frame.setVisible(true);
		frame.pack();
	}
	
	/**
	 * Exits the frame.
	 */
	@Override
	public void close() {
		frame.getContentPane().removeAll();
	}
	
	public void exit() {
		frame.dispose();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Changes the number of the day in the {@link HudSRPanel}.
	 */
	@Override
	public void jourChanged(MapEvent event) {
		HudWPanel.setRessources(event.getRessources());
		HudWPanel.setMoral(event.getMoral());
		HudWPanel.setPopulation(event.getPopulation());
		HudWPanel.setPopulationMax(event.getPopulationMax());
		HudSPanel.getRight().setNbDay(event.getNbJour());
		
		EventPanel panel = new EventPanel(getController());
		panel.event(event.getNbEvent(), event.getFoodLoose(), event.getGoldLoose());
		eventPanel = new JDialog(frame, "Event", true);
		
		eventPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		eventPanel.setResizable(false);
		eventPanel.add(panel);
		eventPanel.pack();
		eventPanel.setVisible(true);
	}
	
	@Override
	public void ExitEvent(MapEvent event) {
		HudWPanel.setRessources(event.getRessources());
		eventPanel.dispose();
	}
	
	@Override
	public void ExitStopBanditsEvent(MapEvent event) {
		HudWPanel.setRessources(event.getRessources());
		eventPanel.dispose();
		JOptionPane.showMessageDialog(frame, "You loose "+event.getGoldLoose()+" gold for trying to stop bandits",
				"Event", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Gives all the images from the generated map to the {@link HudCPanel}.
	 */
	@Override
	public void MapGenerated(MapEvent event) {
		HudCPanel.mapGenerated(event.getImg(), event.getImgOver());
	}
	
	@Override
	public void Refresh(MapEvent event) {
		jourChanged(event);
		MapGenerated(event);
	}

	/**
	 * Disables the fog from the clicked square in the {@link HudCPanel}.
	 */
	@Override
	public void FogOff(MapEvent event) {
		int[] coord = event.getCoord();
		boolean cityHall = event.getCityHall();
		HudCPanel.fogOff(coord[0], coord[1]);
		HudWPanel.setRessources(event.getRessources());
		switch(event.getTypeCase()) {
			case "model.Plain":
				if(cityHall) {
					ModifyPlainSCPanel(event);
				}
				else {
					ModifyPlainCHSCPanel(event);
				}
				break;
	
			case "model.Forest":
				ModifyForestSCPanel(event);
				break;
	
			case "model.Mountain":
				ModifyMountainSCPanel(event);
				break;
	
			case "model.Water":
				ModifyWaterSCPanel(event);
				break;
		}
	}
	
	public void CityHallOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.buildingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudWPanel.setPopulationMax(event.getPopulationMax());
		HudWPanel.setPopulation(event.getPopulation());
		HudWPanel.setMoral(event.getMoral());
		HudWPanel.setRessources(event.getRessources());
		HudSPanel.getLeft().setChangeViewOn();
		ModifyPlainCHSCPanel(event);
	}
	
	@Override
	public void HouseOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.buildingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudWPanel.setPopulationMax(event.getPopulationMax());
		HudWPanel.setMoral(event.getMoral());
		HudWPanel.setRessources(event.getRessources());
		ModifyPlainSCPanel(event);
	}
	
	@Override
	public void FarmOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.buildingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudWPanel.setPopulation(event.getPopulation());
		HudWPanel.setMoral(event.getMoral());
		HudWPanel.setRessources(event.getRessources());
		ModifyPlainSCPanel(event);
	}
	
	@Override
	public void FishingOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.buildingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudWPanel.setPopulation(event.getPopulation());
		HudWPanel.setRessources(event.getRessources());
		ModifyWaterSCPanel(event);
	}

	@Override
	public void LoggingOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.buildingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudWPanel.setPopulation(event.getPopulation());
		HudWPanel.setMoral(event.getMoral());
		HudWPanel.setRessources(event.getRessources());
		ModifyForestSCPanel(event);
	}

	@Override
	public void MineOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.buildingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudWPanel.setPopulation(event.getPopulation());
		HudWPanel.setMoral(event.getMoral());
		HudWPanel.setRessources(event.getRessources());
		ModifyMountainSCPanel(event);
	}

	@Override
	public void ModifySCPanel(MapEvent event) {
		HudSPanel.getCenter().display(event.getAdjacent(), event.getTypeCase(),event.getFirstBuy(), event.getCityHall(), event.getRessources());
		HudWPanel.display(event.getCurrentImage(), event.getCurrentImageOver());
		HudWPanel.setBuilding(event.getBuilding());
	}

	@Override
	public void ModifyPlainCHSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayPlainCityHall(event.getRessources(), event.getBuilding());
		HudWPanel.display(event.getCurrentImage(), event.getCurrentImageOver());
		HudWPanel.setBuilding(event.getBuilding());
	}
	
	@Override
	public void ModifyPlainSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayPlain(event.getRessources(), event.getBuilding());
		HudWPanel.display(event.getCurrentImage(), event.getCurrentImageOver());
		HudWPanel.setBuilding(event.getBuilding());
	}

	@Override
	public void ModifyForestSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayForest(event.getRessources(), event.getBuilding());
		HudWPanel.display(event.getCurrentImage(), event.getCurrentImageOver());
		HudWPanel.setBuilding(event.getBuilding());
	}

	@Override
	public void ModifyMountainSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayMountain(event.getRessources(), event.getBuilding());
		HudWPanel.display(event.getCurrentImage(), event.getCurrentImageOver());
		HudWPanel.setBuilding(event.getBuilding());
	}

	@Override
	public void ModifyWaterSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayWater(event.getRessources(), event.getBuilding());
		HudWPanel.display(event.getCurrentImage(), event.getCurrentImageOver());
		HudWPanel.setBuilding(event.getBuilding());
	}
	
	public void RefreshRessourcesAdv(MapEvent event) {
		HudWPanel.setPopulation(event.getPopulation());
		HudWPanel.setRessources(event.getRessources());
	}

	@Override
	public void selected(MapEvent event) {
		HudCPanel.selected(event.getCoord());
	}
}
