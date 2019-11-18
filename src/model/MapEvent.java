package model;

import java.awt.Image;
import java.util.EventObject;

public class MapEvent extends EventObject {

	private int nbJour;
	
	private Image[][] img;
	private Image[][] imgOver;
	
	private int[] coord; 
	
	private boolean adjacent;
  
	private String typeCase;
	private boolean cityHall;
	
	public MapEvent(Object source) {
		super(source);
		
		nbJour = ((Model)source).getNbJour();
		
		img = ((Model)source).getImg();
		imgOver = ((Model)source).getImgOver();
		
		coord = ((Model)source).getCoord();

		adjacent = ((Model)source).getAdjacent();

		typeCase = ((Model)source).getTypeCase();
		cityHall = ((Model)source).getCityHall();
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
	
	public boolean getAdjacent() {
		return adjacent;
  }
  
	public String getTypeCase() {
		return typeCase;
	}

	public boolean getCityHall() {
		return cityHall;
	}
}
