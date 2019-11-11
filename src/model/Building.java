package model;

import java.awt.Image;

public abstract class Building {
	private Image img;
	private int level;
	private int population, maxPopulation;
	
	public Building() {
		level = 0;
		
	}

	public int getLevel() {
		return level;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	
}

