package model;

import java.io.Serializable;
import java.util.EventObject;
import java.util.List;

@SuppressWarnings("serial")
public class DungeonEvent extends EventObject implements Serializable {
	
	private List<Adventurer> adventurers;
	private List<Adventurer> adventurersInDungeon;
	private Adventurer advRemove;
	
	private int digitOfAdvInDungeon;
	private int digitOfAdvRemove;
	private int nbAdventurerInDungeon;
	
	private int nbGold;
	private int nbFood;
	private int nbFoodInDg;

	public DungeonEvent(Object source) {
		super(source);
		
		adventurers = ((Model)source).getAdventurers();
		
		digitOfAdvInDungeon = ((Model)source).getNbButtonAdv();
		
		nbAdventurerInDungeon = ((Model)source).getNbAdventurerInDungeon();
		
		adventurersInDungeon = ((Model)source).getAdvInDungeon();
		
		nbGold = ((Model)source).getRessources()[0];
		nbFood = ((Model)source).getRessources()[1];
		
		digitOfAdvRemove = ((Model)source).getNbButtonAdvRemove();
		
		advRemove = ((Model)source).getAdvRemove();
		
		nbFoodInDg = ((Model)source).getNbFoodInDg();
		
	}
	
	public Adventurer getLastAdventurer() {
		return adventurers.get(adventurers.size() - 1);
	}

	public List<Adventurer> getAdventurers() {
		return adventurers;
	}

	public Adventurer getAdventurer() {
		return adventurers.get(digitOfAdvInDungeon);
	}

	public int getNbAdventurerInDungeon() {
		return nbAdventurerInDungeon;
	}

	public List<Adventurer> getAdventurerInDungeon() {
		return adventurersInDungeon;
	}

	public int getNbGold() {
		return nbGold;
	}

	public Adventurer getAdvRemove() {
		return advRemove;
	}

	public int getDigitAdvRemove() {
		return digitOfAdvRemove;
	}

	public int getNbFood() {
		return nbFood;
	}
	
	public int getNbFoodInDg() {
		return nbFoodInDg;
	}
}
