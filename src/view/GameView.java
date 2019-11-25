package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import controller.Controller;
import model.GlobalListener;
import model.MapEvent;

public class GameView extends View implements GlobalListener{

	private Controller controller;
	
	private JFrame frame;
	
	private HudWPanel HudWPanel;
	private HudSPanel HudSPanel;
	private HudCPanel HudCPanel;
	
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
		frame.add(HudWPanel, BorderLayout.WEST);
		
		HudSPanel = new HudSPanel(controller);
		frame.add(HudSPanel, BorderLayout.SOUTH);
		
		HudCPanel = new HudCPanel(controller);
		frame.add(HudCPanel, BorderLayout.CENTER);
		
		frame.setResizable(false);
		frame.pack();
	}
	
	/**
	 * Displays the frame.
	 */
	@Override
	public void display() {
		frame.setVisible(true);
	}
	
	/**
	 * Exits the frame.
	 */
	@Override
	public void close() {
		frame.dispose();
	}

	/**
	 * Changes the number of the day in the {@link HudSRPanel}.
	 */
	@Override
	public void jourChanged(MapEvent event) {
		HudWPanel.setRessources(event.getRessources());
		HudSPanel.getRight().setNbJour(event.getNbJour());
	}

	/**
	 * Gives all the images from the generated map to the {@link HudCPanel}.
	 */
	@Override
	public void MapGenerated(MapEvent event) {
		HudCPanel.mapGenerated(event.getImg(), event.getImgOver());
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
		HudWPanel.setRessources(event.getRessources());
		ModifyPlainCHSCPanel(event);
	}
	
	@Override
	public void HouseOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.buildingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudWPanel.setPopulationMax(event.getPopulationMax());
		HudWPanel.setRessources(event.getRessources());
		ModifyPlainSCPanel(event);
	}
	
	@Override
	public void FarmOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.buildingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudWPanel.setPopulation(event.getPopulation());
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
		HudWPanel.setRessources(event.getRessources());
		ModifyForestSCPanel(event);
	}

	@Override
	public void MineOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.buildingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudWPanel.setPopulation(event.getPopulation());
		HudWPanel.setRessources(event.getRessources());
		ModifyMountainSCPanel(event);
	}

	@Override
	public void ModifySCPanel(MapEvent event) {
		HudSPanel.getCenter().display(event.getCurrentImage(), event.getAdjacent(), event.getTypeCase(), event.getCityHall(), event.getRessources());
		HudWPanel.display(event.getCurrentImage());
	}

	@Override
	public void ModifyPlainCHSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayPlainCityHall(event.getCurrentImage(), event.getRessources(), event.isBuilding());
		HudWPanel.display(event.getCurrentImage());
	}
	
	@Override
	public void ModifyPlainSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayPlain(event.getCurrentImage(), event.getRessources(), event.isBuilding());
		HudWPanel.display(event.getCurrentImage());
	}

	@Override
	public void ModifyForestSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayForest(event.getCurrentImage(), event.getRessources(), event.isBuilding());
		HudWPanel.display(event.getCurrentImage());
	}

	@Override
	public void ModifyMountainSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayMountain(event.getCurrentImage(), event.getRessources(), event.isBuilding());
		HudWPanel.display(event.getCurrentImage());
	}

	@Override
	public void ModifyWaterSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayWater(event.getCurrentImage(), event.getRessources(), event.isBuilding());
		HudWPanel.display(event.getCurrentImage());
	}

	@Override
	public void selected(MapEvent event) {
		HudCPanel.selected(event.getCoord());
	}
}
