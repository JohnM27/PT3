package model;

import java.awt.Image;
import java.util.EventObject;

public class MapGeneratedEvent extends EventObject {
	
	private Image[][] img;
	
	public MapGeneratedEvent(Object source, Image[][] img) {
		super(source);

		this.img = img;
	}

	public Image[][] getImg() {
		return img;
	}

}
