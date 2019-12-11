package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class House extends Building {
	
	public House() {
		super();
		
		double r = Math.random();
		if(r <= 0.5)
			setImg("House.png");
		else
			setImg("House2.png");
		
		setPopulation(5);
	}
}
