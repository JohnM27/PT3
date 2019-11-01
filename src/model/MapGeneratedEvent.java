package model;

import java.awt.Image;
import java.util.EventObject;

public class MapGeneratedEvent extends EventObject {
	
	private Image[][] img;
	private Image[][] imgOver;
	
	public MapGeneratedEvent(Object source, Image[][] img, Image[][] imgOver) {
		super(source);

		this.img = img;
		this.imgOver = imgOver;
	}

	public Image[][] getImg() {
		return img;
	}

	public Image[][] getImgOver() {
		return imgOver;
	}
}
