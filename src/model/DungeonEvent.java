package model;

import java.io.Serializable;
import java.util.EventObject;
import java.util.List;

@SuppressWarnings("serial")
public class DungeonEvent extends EventObject implements Serializable {
	
	private List<Adventurer> adventurers;

	public DungeonEvent(Object source) {
		super(source);
		
		adventurers = ((Model)source).getAdventurers();
		
	}
	
	public Adventurer getLastAdventurer() {
		return adventurers.get(adventurers.size() - 1);
	}

	public List<Adventurer> getAdventurers() {
		return adventurers;
	}
}
