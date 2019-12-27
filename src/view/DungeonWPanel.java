package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import controller.Controller;
import model.Adventurer;

@SuppressWarnings("serial")
public class DungeonWPanel extends JPanel {
	
	private List<AdventurerPanel> adventurers;
	//private JButton empty;
	
	private final static int NB_ADV = 10;
	
	private Controller controller;
	
	public DungeonWPanel(Controller controller) {
		super(new GridLayout(0,1));
		
		this.controller = controller;
		
		adventurers = new ArrayList<AdventurerPanel>();
		for(int i = 0; i < NB_ADV; i++) {
			if(i < 4) {
				adventurers.add(new AdventurerPanel(1, controller));
			}
			else {
				adventurers.add(new AdventurerPanel(2, controller));
			}
		}
		
		for(int i = 0 ; i < adventurers.size() ; i++) {
			add(adventurers.get(i));
		}
	}
	
	public void addAdventurer(Adventurer adventurer) {
		boolean first = true;
		for(int i = 0 ; i < adventurers.size() ; i++) {
			remove(adventurers.get(i));
			if(first && adventurers.get(i).getTypeOfAdv() == 1) {
				adventurers.set(i, new AdventurerPanel(adventurer, controller));
				add(adventurers.get(i));
				adventurers.get(i).setButton("Selected "+i);
				first = false;
			}
			else {
				add(adventurers.get(i));
			}
		}
		revalidate();
		repaint();
	}

	public void addAllAdventurer(List<Adventurer> adventurers) {
		for(int i = 0 ; i < this.adventurers.size() ; i++) {
			remove(this.adventurers.get(i));
		}
		for(int i = 0 ; i < adventurers.size() ; i++) {
			this.adventurers.set(i, new AdventurerPanel(adventurers.get(i), controller));
			this.adventurers.get(i).setButton("Selected "+i);
			add(this.adventurers.get(i));
		}
		for(int i = adventurers.size() ; i < this.adventurers.size() ; i++) {
			add(this.adventurers.get(i));
		}
		repaint();
	}

	public void disableButton(List<Adventurer> adventurerInDungeon) {
		if(adventurerInDungeon.size() >= 3) {
			for(int j = 0; j < adventurers.size(); j++) {
				if(adventurers.get(j).getTypeOfAdv() == 0) {
					adventurers.get(j).setButtonFalse();
				}
			}
		}
		else {
			for(int i = 0; i < adventurerInDungeon.size(); i++) {
				for(int j = 0; j < adventurers.size(); j++) {
					if(adventurerInDungeon.get(i).equals(adventurers.get(j).getAdv())) {
						adventurers.get(j).setButtonFalse();
					}
				}
			}
		}
		repaint();
	}
	
	public void enableAllButton() {
		for(int j = 0; j < adventurers.size(); j++) {
			if(adventurers.get(j).getTypeOfAdv() == 0) {
				adventurers.get(j).setButtonTrue();
			}
		}
		repaint();
	}
	
	public void enableButton(Adventurer adventurerRemove) {
		for(int j = 0; j < adventurers.size(); j++) {
			if(adventurerRemove.equals(adventurers.get(j).getAdv())) {
				adventurers.get(j).setButtonTrue();
			}
		}
		repaint();
	}
}
