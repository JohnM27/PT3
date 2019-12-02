package model;

import java.awt.Image;
import java.io.Serializable;

public abstract class Building implements Serializable {
	private String img;
	private int level;
	private int population;
	private String type;
	
	public Building() {
		level = 0;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
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

