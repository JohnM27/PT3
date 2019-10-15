package model;

import java.awt.Image;

public abstract class Case {

	private Image img;
	private int x, y;
	
	public Case(int x, int y, Image img) {
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
