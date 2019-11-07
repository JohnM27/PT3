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
		HudWPanel.setBackground(Color.BLUE);
		frame.add(HudWPanel, BorderLayout.WEST);
		
		HudSPanel = new HudSPanel(controller);
		HudSPanel.setBackground(Color.RED);
		frame.add(HudSPanel, BorderLayout.SOUTH);
		
		HudCPanel = new HudCPanel(controller);
		HudCPanel.setBackground(Color.GREEN);
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
		HudCPanel.fogOff(coord[0], coord[1]);
		HudSPanel.getCenter().done();
	}
	
	@Override
	public void HouseOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.houseOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudSPanel.getCenter().done();
	}
	
	@Override
	public void FishingOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.fishingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudSPanel.getCenter().done();
	}

	@Override
	public void LoggingOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.loggingOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudSPanel.getCenter().done();
	}

	@Override
	public void MineOn(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.mineOn(coord[0], coord[1], event.getImgOver()[coord[0]][coord[1]]);
		HudSPanel.getCenter().done();
	}

	@Override
	public void ModifySCPanel(MapEvent event) {
		HudCPanel.selected(event.getCoord());
		
		HudSPanel.getCenter().display(event.getCurrentImage(), event.getAdjacent());
	}

	@Override
	public void ModifyPlainSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayPlain(event.getCurrentImage());
	}

	@Override
	public void ModifyForestSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayForest(event.getCurrentImage());
	}

	@Override
	public void ModifyMountainSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayMountain(event.getCurrentImage());
	}

	@Override
	public void ModifyWaterSCPanel(MapEvent event) {
		HudSPanel.getCenter().displayWater(event.getCurrentImage());
	}
}
