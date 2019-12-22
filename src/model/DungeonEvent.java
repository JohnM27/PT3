package model;

import java.io.Serializable;
import java.util.EventObject;
import java.util.List;

@SuppressWarnings("serial")
public class DungeonEvent extends EventObject implements Serializable {
	
	private List<Adventurer> adventurers;
	private List<Adventurer> adventurersInDungeon;
	
	private int advInDungeon;
	private int nbAdventurerInDungeon;
	
	private int nbOr;

	public DungeonEvent(Object source) {
		super(source);
		
		adventurers = ((Model)source).getAdventurers();
		
		advInDungeon = ((Model)source).getNbButtonAdvInDungeon();
		
		nbAdventurerInDungeon = ((Model)source).getNbAdventurerInDungeon();
		
		adventurersInDungeon = ((Model)source).getAdvInDungeon();
		
		nbOr = ((Model)source).getRessources()[0];
		
	}
	
	public Adventurer getLastAdventurer() {
		return adventurers.get(adventurers.size() - 1);
	}

	public List<Adventurer> getAdventurers() {
		return adventurers;
	}

	public Adventurer getAdventurer() {
		return adventurers.get(advInDungeon);
	}

	public int getNbAdventurerInDungeon() {
		return nbAdventurerInDungeon;
	}

	public List<Adventurer> getAdventurerInDungeon() {
		return adventurersInDungeon;
	}

	public int getNbOr() {
		return nbOr;
	}
}
