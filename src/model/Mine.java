package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mine extends Building {

	public Mine() {
		super();
		
			double r = Math.random();
			if(r <= 0.5)
				setImg("Mine.png");
			else
				setImg("Mine2.png");
		
		setPopulation(5);
	}
}
