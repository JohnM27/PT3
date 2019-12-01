package model;

import java.awt.Image;
import java.util.EventObject;

@SuppressWarnings("serial")
public class MapEvent extends EventObject {

	private int nbJour;
	
	private Image[][] img;
	private Image[][] imgOver;
	
	private int[] coord; 
	
	private boolean adjacent;
  
	private String typeCase;
	private boolean cityHall;
	
	private int populationMax;
	private int population;
	
	private int[] ressources;
	
	private Building build;
	
	private int moral;
	
	public MapEvent(Object source) {
		super(source);
		
		nbJour = ((Model)source).getNbJour();
		
		img = ((Model)source).getImg();
		imgOver = ((Model)source).getImgOver();
		
		coord = ((Model)source).getCoord();

		adjacent = ((Model)source).getAdjacent();

		typeCase = ((Model)source).getTypeCase();
    
		cityHall = ((Model)source).getCityHall();
		
		populationMax = ((Model)source).getPopulationMax();
		population = ((Model)source).getPopulation();
		
		ressources = ((Model)source).getRessources();
		
		build = ((Model)source).getBuilding(coord[0], coord[1]);
		
		moral = ((Model)source).getMoral();
	}
	
	public int getNbJour() {
		return nbJour;
	}

	public Image[][] getImg() {
		return img;
	}

	public Image[][] getImgOver() {
		return imgOver;
	}
	
	public int[] getCoord() {
		return coord;
	}
	
	public Image getCurrentImage() {
		return img[coord[0]][coord[1]];
	}
	
	public Image getCurrentImageOver() {
		return imgOver[coord[0]][coord[1]];
	}
	
	public boolean getAdjacent() {
		return adjacent;
  }
  
	public String getTypeCase() {
		return typeCase;
	}

	public boolean getCityHall() {
		return cityHall;
  }
  
	public int getPopulationMax() {
		return populationMax;
	}
	
	public int getPopulation() {
		return population;
	}

	public int[] getRessources() {
		return ressources;
	}

	public Building getBuilding() {
		return build;
	}

	public int getMoral() {
		return moral;
	}
}
