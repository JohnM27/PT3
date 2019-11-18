package model;

import java.awt.Image;

public abstract class Case {

	private Image img;
	private int x, y;
	private Territory territory;
	
	public Case(int x, int y, Image img) {
		territory = new Territory();
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	public Image getImage() {
		return img;
	}
	
	public void setImage(Image img) {
		this.img = img;
	}
	
	public void setPossessed() {
		territory.setPossessed(true);
	}
	
	public boolean isPossessed() {
		return territory.isPossessed();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Image getImageOver() {
		return territory.getOver();
	}
	
	public void setImageOver() {
		territory.setOver();
	}

	public Building buildHouse() {
		return territory.buildHouse();
	}

	public void setFishingImageOver() {
		territory.setFishingImageOver();
	}

	public Building buildLumberMill() {
		return territory.buildLumberMill();
	}

	public void setMineImageOver() {
		territory.setMineImageOver();
	}
}