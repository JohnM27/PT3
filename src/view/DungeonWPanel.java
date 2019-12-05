package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import controller.Controller;

public class DungeonWPanel extends JPanel {

	private Controller controller;
	private List<AdventurerPanel> Adventurer = new ArrayList<AdventurerPanel>();
	
	public DungeonWPanel(Controller controller) {
		super(new GridLayout(0,1));
		
		// A REMPLACER PAR L'AJOUT D'AVENTURIER
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		Adventurer.add(new AdventurerPanel());
		
		for(int i = 0 ; i < Adventurer.size() ; i++) {
			add(Adventurer.get(i));
		}
	}
}
