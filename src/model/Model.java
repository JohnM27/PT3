package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.EventListenerList;

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
	//private int[] ressources = {75, 20, 50, 0};
	private int[] ressources = {9999, 9999, 9999, 9999};
  
	private int populationMax = 0;
	private int population = 0;
	private int moral = 130;
  
	public Model() {
		listenersList = new EventListenerList();
		nbJour = 0;
		listBuilding = new ArrayList<Case>();
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
	
	public Building getBuilding(int i, int j) {
		return m.getBuilding(i, j);
	}
	
	public void addGlobalListener(GlobalListener listener) {
		listenersList.add(GlobalListener.class, listener);
	}
	
	public void removeGlobalListener(GlobalListener listener) {
		listenersList.remove(GlobalListener.class, listener);
	}
	
	public void fireJourChanged() {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
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
		
		moral();
		
		for(GlobalListener listener : listenerList)
			listener.jourChanged(new MapEvent(this));
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
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		for(GlobalListener listener : listenerList)
			listener.Refresh(new MapEvent(this));
	}
	
	public void fireMapGenerated() {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
	
		m.genererMap();
		
		for(GlobalListener listener : listenerList)
			listener.MapGenerated(new MapEvent(this));
	}
	
	//Enleve le brouillard d'une case
	public void fireFogOff() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.setImageOver(coord[0], coord[1]);
		m.setPossessed(coord[0], coord[1]);
		
		firstBuy = false;
		
		ressources[0] -= 6; // achat d'une case pour 6 d'or
		
		for(GlobalListener listener : listenerList)
			listener.FogOff(new MapEvent(this));
	}

	public void fireCityHallOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.buildCityHall(coord[0], coord[1]);
		populationMax += m.getPopulation(coord[0], coord[1]);
		cityHall = true;
		
		ressources[0] -= 50;
		ressources[2] -= 30;
		
		for(GlobalListener listener : listenerList)
			listener.CityHallOn(new MapEvent(this));
	}

	public void fireHouseOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.buildHouse(coord[0], coord[1]);
		
		populationMax += m.getPopulation(coord[0], coord[1]);
		ressources[0] -= 3;
		ressources[2] -= 5;
		
		for(GlobalListener listener : listenerList)
			listener.HouseOn(new MapEvent(this));
	}
	
	public void fireFarmOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.buildFarm(coord[0], coord[1]);
		population += m.getPopulation(coord[0], coord[1]);
		
		listBuilding.add(m.getCase(coord[0], coord[1]));
		
		ressources[0] -= 3;
		ressources[2] -= 5;
		
		for(GlobalListener listener : listenerList)
			listener.FarmOn(new MapEvent(this));
	}
	
	public void fireFishingOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.buildHarbor(coord[0], coord[1]);
		population += m.getPopulation(coord[0], coord[1]);
		
		listBuilding.add(m.getCase(coord[0], coord[1]));
		
		ressources[0] -= 5;
		ressources[2] -= 7;
		
		for(GlobalListener listener : listenerList)
			listener.FishingOn(new MapEvent(this));
	}

	public void fireLoggingOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.buildLumberMill(coord[0], coord[1]);
		population += m.getPopulation(coord[0], coord[1]);
		
		listBuilding.add(m.getCase(coord[0], coord[1]));
		
		ressources[0] -= 5;
		ressources[2] -= 5;
		
		for(GlobalListener listener : listenerList)
			listener.LoggingOn(new MapEvent(this));
	}

	public void fireMineOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.buildMine(coord[0], coord[1]);
		population += m.getPopulation(coord[0], coord[1]);
		
		listBuilding.add(m.getCase(coord[0], coord[1]));
		
		ressources[0] -= 20;
		ressources[2] -= 10;
		
		for(GlobalListener listener : listenerList)
			listener.MineOn(new MapEvent(this));
	}
	
	public void fireModifySCPanel(int i, int j) {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		coord[0] = i;
		coord[1] = j;
		typeCase = getTypeCase(i, j);
		
		adjacent = m.isAdjacent(coord);
		
		for(GlobalListener listener : listenerList)
			listener.ModifySCPanel(new MapEvent(this));	
	}
	

	public void fireModifyPlainCHSCPanel(int i, int j) {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GlobalListener listener : listenerList)
			listener.ModifyPlainCHSCPanel(new MapEvent(this));
	}

	public void fireModifyPlainSCPanel(int i, int j) {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GlobalListener listener : listenerList)
			listener.ModifyPlainSCPanel(new MapEvent(this));
	}

	public void fireModifyForestSCPanel(int i, int j) {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GlobalListener listener : listenerList)
			listener.ModifyForestSCPanel(new MapEvent(this));
	}

	public void fireModifyMountainSCPanel(int i, int j) {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GlobalListener listener : listenerList)
			listener.ModifyMountainSCPanel(new MapEvent(this));
	}

	public void fireModifyWaterSCPanel(int i, int j) {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GlobalListener listener : listenerList)
			listener.ModifyWaterSCPanel(new MapEvent(this));
	}

	public void fireSelected(int i, int j) {
		GlobalListener[] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		coord[0] = i;
		coord[1] = j;
		
		for(GlobalListener listener : listenerList)
			listener.selected(new MapEvent(this));
	}
}