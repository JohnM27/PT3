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
	
	public DungeonWPanel(Controller controller) {
		super(new GridLayout(0,1));
		
		adventurers = new ArrayList<AdventurerPanel>();
		for(int i = 0; i < NB_ADV; i++) {
			if(i < 4) {
				adventurers.add(new AdventurerPanel(1));
			}
			else {
				adventurers.add(new AdventurerPanel(2));
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
				adventurers.set(i, new AdventurerPanel(adventurer));
				add(adventurers.get(i));
				System.out.println(i);
				first = false;
			}
			else {
				add(adventurers.get(i));
			}
		}
		
		repaint();
	}

	public void addAllAdventurer(List<Adventurer> adventurers) {
		for(int i = 0 ; i < this.adventurers.size() ; i++) {
			remove(this.adventurers.get(i));
		}
		for(int i = 0 ; i < adventurers.size() ; i++) {
			this.adventurers.set(i, new AdventurerPanel(adventurers.get(i)));
			add(this.adventurers.get(i));
		}
		for(int i = adventurers.size() ; i < this.adventurers.size() ; i++) {
			add(this.adventurers.get(i));
		}
		repaint();
	}
}
