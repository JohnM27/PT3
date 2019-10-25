package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Territory {
	private boolean possessed;
	private Image over;
	
	public Territory() {
		possessed = false;
		try {
			over = ImageIO.read(new File("Graphismes/Territory.png"));
			
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
	
	
}