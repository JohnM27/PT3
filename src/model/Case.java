package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Case implements Serializable {

	private String img;
	private int x, y;
	
	private boolean possessed;
	private Building building;
	private String imageOver;
	
	public Case(int x, int y, String img) {
		this.x = x;
		this.y = y;
		this.img = img;
		
		building = null;
		
		possessed = false;
		imageOver = "Territory.png";
	}

	public String getImage() {
		return img;
	}
	
	public void setImage(String img) {
		this.img = img;
	}
	
	public void setPossessed() {
		possessed = true;
	}
	
	public boolean isPossessed() {
		return possessed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public String getImageOver() {
		return imageOver;
	}
	
	public void setImageOver() {
		imageOver = "null";
	}
	
	public int getPopulation() {
		return building.getPopulation();
	}
	
	public void buildCityHall() {
		building = new CityHall();
		imageOver = building.getImg();
	}

	public void buildHouse() {
		building = new House();
		imageOver = building.getImg();
	}
	
	public void buildFarm() {
		building = new Farm();
		imageOver = building.getImg();
	}

	public void buildHarbor() {
		building = new Harbor();
		imageOver = building.getImg();
	}
  
	public void buildLumberMill() {
		building = new LumberMill();
		imageOver = building.getImg();
	}

	public void buildMine() {
		building = new Mine();
		imageOver = building.getImg();
	}

	public String getBuildingType() {
		return building.getClass().getName();
	}

	public Building getBuilding() {
		return building;
	}
}