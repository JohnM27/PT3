package model;

import java.util.EventObject;

public class FogOffEvent extends EventObject {
	
	private int[] coord = new int[2];

	public FogOffEvent(Object source, int x, int y) {
		super(source);
		
		coord[0] = x;
		coord[1] = y;
	}
	
	public int[] getCoord() {
		return coord;
	}

}
