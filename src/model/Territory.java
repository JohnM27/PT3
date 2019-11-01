package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Territory {
	private boolean possessed;
	private Image over, house, fishing, logging, mine;
	
	public Territory() {
		possessed = false;
		try {
			over = ImageIO.read(new File("Graphismes/Territory.png"));
			house = ImageIO.read(new File("Graphismes/H.png"));
			fishing = ImageIO.read(new File("Graphismes/F.png"));
			logging = ImageIO.read(new File("Graphismes/L.png"));
			mine = ImageIO.read(new File("Graphismes/M.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isPossessed() {
		return possessed;
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

	public boolean getPossessed() {
		return possessed;
	}

	public void setHouseImageOver() {
		this.over = house;
	}

	public void setFishingImageOver() {
		this.over = fishing;
	}

	public void setLoggingImageOver() {
		this.over = logging;
	}

	public void setMineImageOver() {
		this.over = mine;
	}
	
	
}