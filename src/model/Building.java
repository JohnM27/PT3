package model;

import java.awt.Image;

public abstract class Building {
	private Image img;
	private int level;
	private int population;
	
	public Building() {
		level = 0;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
}

