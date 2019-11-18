package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Territory {
	private boolean possessed;
	private Building building;
	private Image over;
	
	public Territory() {
		possessed = false;
		try {
			over = ImageIO.read(new File("Graphismes/Territory.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setPossessed(boolean possessed) {
		this.possessed = possessed;
	}

	public Image getOver() {
		return over;
	}

	public void setOver() {
		this.over = null;
	}

	public boolean isPossessed() {
		return possessed;
	}

	public Building buildHouse() {
		building = new House();
		this.over = building.getImg();
		return building;
	}

	public void setFishingImageOver() {
		building = new Harbor();
		this.over = building.getImg();
	}

	public Building buildLumberMill() {
		building = new LumberMill();
		this.over = building.getImg();
		return building;
	}

	public void setMineImageOver() {
		building = new Mine();
		this.over = building.getImg();
	}
	
	
}