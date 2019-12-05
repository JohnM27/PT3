package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import controller.Controller;
import model.Adventurer;

public class DungeonWPanel extends JPanel {

	private Controller controller;
	private List<AdventurerPanel> adventurers;
	
	public DungeonWPanel(Controller controller) {
		super(new GridLayout(0,1));
		
		adventurers = new ArrayList<AdventurerPanel>();
		
		for(int i = 0 ; i < adventurers.size() ; i++) {
			add(adventurers.get(i));
		}
	}
	
	public void addAdventurer(Adventurer adventurer) {
		adventurers.add(new AdventurerPanel(adventurer));
		add(adventurers.get(adventurers.size() - 1));
		repaint();
	}

	public void addAllAdventurer(List<Adventurer> adventurers) {
		for(int i = 0 ; i < adventurers.size() ; i++) {
			this.adventurers.add(new AdventurerPanel(adventurers.get(i)));
			add(this.adventurers.get(i));
		}
	}
}
