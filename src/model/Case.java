package model;

import java.awt.Image;

public abstract class Case {

	private Image im;
	private int x, y;
	
	public Case(int x, int y, Image im) {
		this.x = x;
		this.y = y;
		this.im = im;
	}
	
	public Image getImage() {
		return im;
	}
	
	public void setImage(Image im) {
		this.im = im;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
