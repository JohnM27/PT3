package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Case {

	private Image img;
	private int x, y;
	
	private boolean possessed;
	private Building building;
	private Image imageOver;
	
	public Case(int x, int y, Image img) {
		this.x = x;
		this.y = y;
		this.img = img;
		
		building = null;
		
		possessed = false;
		try {
			imageOver = ImageIO.read(new File("Graphismes/Territory.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image getImage() {
		return img;
	}
	
	public void setImage(Image img) {
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

	public Image getImageOver() {
		return imageOver;
	}
	
	public void setImageOver() {
		imageOver = null;
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