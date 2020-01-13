package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.EventListenerList;

@SuppressWarnings("serial")
public class Model implements Serializable {

	private EventListenerList listenersList;
	private int nbJour;
	private Map m = new Map();
	private int[] coord = new int[2];
	private boolean adjacent;
	private String typeCase;
  
	// enleve le du controller et c'est bon
	private boolean firstBuy = true;
	private boolean cityHall;
	
	private List<Case> listBuilding;
	//Bonnes ressources
	//							gold, food, wood, stone
	private int[] ressources = {75, 20, 50, 0};
	//private int[] ressources = {9999, 9999, 9999, 9999};
  
	private int populationMax = 0;
	private int population = 0;
	private int moral = 130;
	private int nbEvent;
	
	//ADVENTURER AND DONGEON
	private List<Adventurer> adventurers;
	private Dungeon dungeon;
  
	public Model() {
		listenersList = new EventListenerList();
		nbJour = 0;
		listBuilding = new ArrayList<Case>();
		adventurers = new ArrayList<Adventurer>();
		//adventurersInDungeon = new ArrayList<Adventurer>();
	}
	
	/**
	 * Returns 
	 * @return int 
	 */
	public int getNbJour() {
		return nbJour;
	}
	
	public int[] getRessources() {
		return ressources;
	}
	
	public String[][] getImg() {
		return m.getAllImages();
	}

	public String[][] getImgOver() {
		return m.getAllImagesOver();
	}
	
	public int[] getCoord() {
		return coord;
	}
	
	public boolean getAdjacent() {
		return adjacent;
	}
	
	public boolean getPossessed(int i, int j) {
		return m.getPossessed(i, j);
	}
	
	public String getTypeCase(int i, int j){
		return m.getTypeCase(i, j);
	}
	
	public String getTypeCase() {
		return typeCase;
	}

	public int getPopulationMax() {
		return populationMax;
	}

	public int getPopulation() {
		return population;
	}
	
	public boolean getCityHall() {
		return cityHall;
	}
	
	public boolean getFirstBuy() {
		return firstBuy;
	}
	
	public int getMoral() {
		return moral;
	}
	
	public int getNbEvent() {
		return nbEvent;
	}
	
	public List<Adventurer> getAdventurers() {
		return adventurers;
	}
	
	public Building getBuilding(int i, int j) {
		return m.getBuilding(i, j);
	}
	
	public void addGameListener(GameListener listener) {
		listenersList.add(GameListener.class, listener);
	}
	
	public void addDungeonListener(DungeonListener listener) {
		listenersList.add(DungeonListener.class, listener);
	}
	
	public void removeGameListener(GameListener listener) {
		listenersList.remove(GameListener.class, listener);
	}
	
	public void removeDungeonListener(DungeonListener listener) {
		listenersList.remove(DungeonListener.class, listener);		
	}
	
	public void fireJourChanged() {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		nbJour++;
		/*
		 * Faudra changer pour l'amélioration
		 * 
		 * Il suffira de faire un getRessource sur la case et on récupère la ressource facilement
		 */
		for(Case b : listBuilding) {
			if(b.getBuildingType().equals("model.LumberMill")) {
				ressources[2] += 5; //wood
			}
			else if(b.getBuildingType().equals("model.Harbor")) {
				ressources[1] += 5; //food
			}
			else if(b.getBuildingType().equals("model.Farm")) {
				ressources[1] += 5; //food
			}
			else if(b.getBuildingType().equals("model.Mine")) {
				ressources[3] += 5; //stone
			}
		}
		
		EventChoosen();
		
		for(GameListener listener : listenerList)
			listener.jourChanged(new MapEvent(this));
	}
	
	private int foodLoose;
	private int goldLoose;
	
	public int getFoodLoose() {
		return foodLoose;
	}
	
	public int getGoldLoose() {
		return goldLoose;
	}
	
	private void EventChoosen() {
		double r = Math.random();
		if(moral <= 100) {
			if(r < 0.5) {
				nbEvent = 0;
				goldLoose = (int) (Math.random()*20+2);
				if(goldLoose > ressources[0]) {
					goldLoose = ressources[0];
				}
			}
			else {
				nbEvent = 1;
				foodLoose = (int) (Math.random()*10+2);
				if(foodLoose <= ressources[1]) {
					ressources[1] -= foodLoose;
				}
				else {
					foodLoose = ressources[1];
					ressources[1] -= foodLoose;
				}
			}
		}
		else {
			nbEvent = 2;
			ressources[0] += 10;
		}
	}
	
	public void fireExitEvent() {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		for(GameListener listener : listenerList)
			listener.ExitEvent(new MapEvent(this));
	}
	
	public void fireStopBandits() {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		goldLoose = (int) (Math.random()*10+2);
		if(goldLoose > ressources[0]) {
			goldLoose = ressources[0];
			ressources[0] -= goldLoose;
		}
		else {
			ressources[0] -= goldLoose;
		}
		
		for(GameListener listener : listenerList)
			listener.ExitStopBanditsEvent(new MapEvent(this));
	}
	
	public void fireLetBandits() {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		ressources[0] -= goldLoose;
		
		for(GameListener listener : listenerList)
			listener.ExitEvent(new MapEvent(this));
	}

	private void moral() {
		int dif = populationMax - population;
		if(dif >= 0) {
			for(int i = 8; i <= dif; i+=8) {
				if(i == 8) {
					moral -= 25;
				}
				else {
					moral -= 5;
				}
			}
		}
		else {
			for(int i = 1; i <= Math.abs(dif); i+=5) {
				if(i == 1) {
					moral -= 25;
				}
				else {
					moral -= 5;
				}
			}
		}
		if(moral < 0) {
			moral = 0;
		}
		if(moral > 150) {
			moral = 150;
		}
	}
	
	public void fireRefresh() {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		DungeonListener[] dListenerList =
				(DungeonListener[])listenersList.getListeners(DungeonListener.class); 
		
		for(GameListener listener : listenerList)
			listener.Refresh(new MapEvent(this));
		for(DungeonListener listener : dListenerList)
			listener.Refresh(new DungeonEvent(this));
	}
	
	public void fireMapGenerated() {
		GameListener[] gListenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class); 
	
		m.genererMap();
		
		for(GameListener listener : gListenerList)
			listener.MapGenerated(new MapEvent(this));
	}
	
	//Enleve le brouillard d'une case
	public void fireFogOff() {
		GameListener [] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		m.setImageOver(coord[0], coord[1]);
		m.setPossessed(coord[0], coord[1]);
		
		firstBuy = false;
		
		ressources[0] -= 6; // achat d'une case pour 6 d'or
		
		for(GameListener listener : listenerList)
			listener.FogOff(new MapEvent(this));
	}

	public void fireCityHallOn() {
		GameListener [] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		DungeonListener[] dListenerList =
				(DungeonListener[])listenersList.getListeners(DungeonListener.class);
		
		m.buildCityHall(coord[0], coord[1]);
		populationMax += m.getPopulation(coord[0], coord[1]);
		cityHall = true;
		
		ressources[0] -= 50;
		ressources[2] -= 30;
		
		addAdventurer();
		
		moral();
		
		for(GameListener listener : listenerList)
			listener.CityHallOn(new MapEvent(this));
		for(DungeonListener listener : dListenerList)
			listener.AddAdventurer(new DungeonEvent(this));
	}

	public void fireHouseOn() {
		GameListener [] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		m.buildHouse(coord[0], coord[1]);
		
		populationMax += m.getPopulation(coord[0], coord[1]);
		ressources[0] -= 3;
		ressources[2] -= 5;
		
		moral();
		
		for(GameListener listener : listenerList)
			listener.HouseOn(new MapEvent(this));
	}
	
	public void fireFarmOn() {
		GameListener [] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		m.buildFarm(coord[0], coord[1]);
		population += m.getPopulation(coord[0], coord[1]);
		
		listBuilding.add(m.getCase(coord[0], coord[1]));
		
		ressources[0] -= 3;
		ressources[2] -= 5;
		
		moral();
		
		for(GameListener listener : listenerList)
			listener.FarmOn(new MapEvent(this));
	}
	
	public void fireFishingOn() {
		GameListener [] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		m.buildHarbor(coord[0], coord[1]);
		population += m.getPopulation(coord[0], coord[1]);
		
		listBuilding.add(m.getCase(coord[0], coord[1]));
		
		ressources[0] -= 5;
		ressources[2] -= 7;
		
		moral();
		
		for(GameListener listener : listenerList)
			listener.FishingOn(new MapEvent(this));
	}

	public void fireLoggingOn() {
		GameListener [] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		m.buildLumberMill(coord[0], coord[1]);
		population += m.getPopulation(coord[0], coord[1]);
		
		listBuilding.add(m.getCase(coord[0], coord[1]));
		
		ressources[0] -= 5;
		ressources[2] -= 5;
		
		moral();
		
		for(GameListener listener : listenerList)
			listener.LoggingOn(new MapEvent(this));
	}

	public void fireMineOn() {
		GameListener [] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		m.buildMine(coord[0], coord[1]);
		population += m.getPopulation(coord[0], coord[1]);
		
		listBuilding.add(m.getCase(coord[0], coord[1]));
		
		ressources[0] -= 20;
		ressources[2] -= 10;
		
		moral();
		
		for(GameListener listener : listenerList)
			listener.MineOn(new MapEvent(this));
	}
	
	public void fireModifySCPanel(int i, int j) {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		coord[0] = i;
		coord[1] = j;
		typeCase = getTypeCase(i, j);
		
		adjacent = m.isAdjacent(coord);
		
		for(GameListener listener : listenerList)
			listener.ModifySCPanel(new MapEvent(this));	
	}
	

	public void fireModifyPlainCHSCPanel(int i, int j) {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GameListener listener : listenerList)
			listener.ModifyPlainCHSCPanel(new MapEvent(this));
	}

	public void fireModifyPlainSCPanel(int i, int j) {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GameListener listener : listenerList)
			listener.ModifyPlainSCPanel(new MapEvent(this));
	}

	public void fireModifyForestSCPanel(int i, int j) {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GameListener listener : listenerList)
			listener.ModifyForestSCPanel(new MapEvent(this));
	}

	public void fireModifyMountainSCPanel(int i, int j) {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GameListener listener : listenerList)
			listener.ModifyMountainSCPanel(new MapEvent(this));
	}

	public void fireModifyWaterSCPanel(int i, int j) {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GameListener listener : listenerList)
			listener.ModifyWaterSCPanel(new MapEvent(this));
	}

	public void fireSelected(int i, int j) {
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GameListener listener : listenerList)
			listener.selected(new MapEvent(this));
	}
	
	//  DONGEON

	private int digitOfAdv;
	//private List<Adventurer> adventurersInDungeon;
	
	public void addAdventurer() {
		if(adventurers.size() < 10) {
			adventurers.add(new Adventurer());
			population += 5; // On ajoute 5 de population
		}
	}
	
	public List<Adventurer> getAdvInDungeon(){
		return dungeon.getAdventurer();
	}
	
	/**
	 * Give the number of adventurer in the dungeon
	 * @return
	 */
	public int getNbAdventurerInDungeon() {
		return dungeon.getAdventurer().size();
	}
	
	/**
	 * Give the "number" of the adventurer was clicked in the controller
	 * @return
	 */
	public int getNbButtonAdv() {
		return digitOfAdv;
	}
	
	public void fireExpedition() {
		DungeonListener[] gListenerList = 
				(DungeonListener[])listenersList.getListeners(DungeonListener.class); 
	
		for(DungeonListener listener : gListenerList)
			listener.Expedition(new DungeonEvent(this));
	}

	public void fireDungeonGenerated() {
		DungeonListener[] gListenerList = 
				(DungeonListener[])listenersList.getListeners(DungeonListener.class); 
		
		dungeon = new Dungeon();
		
		for(DungeonListener listener : gListenerList)
			listener.DungeonGenerated(new DungeonEvent(this));
	}

	public void addAdventurerToDungeon(int i) {
		DungeonListener[] gListenerList = 
				(DungeonListener[])listenersList.getListeners(DungeonListener.class); 
	
		dungeon.addAdventurer(adventurers.get(i));
		
		//changer available par unavailable
		
		digitOfAdv = i;
		
		for(DungeonListener listener : gListenerList)
			listener.AddAdventurerToDungeon(new DungeonEvent(this));
	}

	public void fireNoExpedition() {
		DungeonListener[] gListenerList = 
				(DungeonListener[])listenersList.getListeners(DungeonListener.class); 
		
		dungeon.removeAdventurer();
		
		digitOfAdv = -1;
		
		for(DungeonListener listener : gListenerList)
			listener.NoExpedition(new DungeonEvent(this));
	}

	public void fireSendAdventurer() {
		DungeonListener[] gListenerList = 
				(DungeonListener[])listenersList.getListeners(DungeonListener.class);
		
		ressources[1] -= dungeon.getNbFood();
		
		for(DungeonListener listener : gListenerList)
			listener.SendAdventurer(new DungeonEvent(this));
	}

	public void fireBuyAdventurer() {
		DungeonListener[] gListenerList = 
				(DungeonListener[])listenersList.getListeners(DungeonListener.class); 
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		ressources[0] -= 30;
		population += 5;
		addAdventurer();
		
		for(DungeonListener listener : gListenerList)
			listener.AddAdventurer(new DungeonEvent(this));
		for(GameListener listener : listenerList)
			listener.RefreshRessourcesAdv(new MapEvent(this));
	}
	
	private int digitOfAdvDelete;
	private Adventurer advDelete;

	public void deleteAdventurerInDungeon(int i) {
		DungeonListener[] gListenerList = 
				(DungeonListener[])listenersList.getListeners(DungeonListener.class);
		advDelete = dungeon.getAdventurer().get(i);
		dungeon.removeAdventurer(i);
		digitOfAdvDelete = i;
		
		for(DungeonListener listener : gListenerList)
			listener.DeleteAdventurer(new DungeonEvent(this));
	}
	
	public Adventurer getAdvRemove() {
		return advDelete;
	}
	
	public int getNbButtonAdvRemove() {
		return digitOfAdvDelete;
	}
	
	private int foodInDungeonForAdv = 1;

	public void fireFoodForExpedition(boolean ml) {
		DungeonListener[] gListenerList = 
				(DungeonListener[])listenersList.getListeners(DungeonListener.class);
		GameListener[] listenerList = 
				(GameListener[])listenersList.getListeners(GameListener.class);
		
		dungeon.setFood(ml);
		
		foodInDungeonForAdv = dungeon.getNbFood();
		
		//on enlève la nourriture au model quand on envoie en expedition
		
		for(DungeonListener listener : gListenerList)
			listener.ChangeFoodExpedition(new DungeonEvent(this));
		for(GameListener listener : listenerList)
			listener.RefreshRessourcesAdv(new MapEvent(this));
	}
	
	public int getNbFoodInDg() {
		return foodInDungeonForAdv;
	}
}