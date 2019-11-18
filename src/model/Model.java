package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.EventListenerList;

public class Model {

	private EventListenerList listenersList;
	private int nbJour;
	private Map m = new Map();
	private int[] coord = new int[2];
	private boolean adjacent;
	private String typeCase;
  
	private boolean cityHall;
	
	private List<Case> building;
	private int nbGold , nbStone, nbWood, nbFood;
  
	private int populationMax = 0;
	private int population = 0;
  
	public Model() {
		listenersList = new EventListenerList();
		nbJour = 0;
		building = new ArrayList<Case>();
		nbGold = 0;
		nbStone = 0;
		nbWood = 0;
		nbFood = 0;
	}
	
	/**
	 * Returns 
	 * @return int 
	 */
	public int getNbJour() {
		return nbJour;
	}
	
	public Image[][] getImg() {
		return m.getAllImages();
	}

	public Image[][] getImgOver() {
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
		
		for(Case b : building) {
			if(b.getBuildingType().equals("model.House")) {
				
			}
			else if(b.getBuildingType().equals("model.LumberMill")) {
				nbWood += 5;
			}
			else if(b.getBuildingType().equals("model.Harbor")) {
				nbFood += 5;
			}
			else if(b.getBuildingType().equals("model.Mine")) {
				nbStone += 5;
				nbGold += 1;
			}
		}
		System.out.println("Wood:" + nbWood);
		System.out.println("Food:" + nbFood);
		System.out.println("Stone:" + nbStone);
		System.out.println("Gold:" + nbGold);
		for(GlobalListener listener : listenerList)
			listener.jourChanged(new MapEvent(this));
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
		
		for(GlobalListener listener : listenerList)
			listener.FogOff(new MapEvent(this));
	}

	public void fireCityHallOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.setCityHallImageOver(coord[0], coord[1]);
		cityHall = true;
		
		for(GlobalListener listener : listenerList)
			listener.HouseOn(new MapEvent(this));
	}

	public void fireHouseOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		Building b = m.buildHouse(coord[0], coord[1]);
		populationMax += b.getPopulation();
		
		building.add(m.getCase(coord[0], coord[1]));
		
		for(GlobalListener listener : listenerList)
			listener.HouseOn(new MapEvent(this));
	}
	
	public void fireFishingOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.setFishingImageOver(coord[0], coord[1]);
		
		building.add(m.getCase(coord[0], coord[1]));
		
		for(GlobalListener listener : listenerList)
			listener.FishingOn(new MapEvent(this));
	}

	public void fireLoggingOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		Building b = m.buildLumberMill(coord[0], coord[1]);
		population += b.getPopulation();
		
		building.add(m.getCase(coord[0], coord[1]));
		
		for(GlobalListener listener : listenerList)
			listener.LoggingOn(new MapEvent(this));
	}

	public void fireMineOn() {
		GlobalListener [] listenerList = 
				(GlobalListener[])listenersList.getListeners(GlobalListener.class);
		
		m.setMineImageOver(coord[0], coord[1]);
		
		building.add(m.getCase(coord[0], coord[1]));
		
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