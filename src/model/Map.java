package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Map implements Serializable {
	
	private Case[][] map = new Case[10][18];
	private Noise n;
	
	public Map() {
		n = new Noise();
	}
	
	public String getTypeCase(int i, int j) {
		return map[i][j].getClass().getName();
	}
	
	public String getImage(int i, int j) {
		return map[i][j].getImage();
	}
	
	public String[][] getAllImages() {
		String[][] img = new String[10][18];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				img[i][j] = map[i][j].getImage();
			}
		}
		return img;
	}
	
	public String getImageOver(int i, int j) {
		return map[i][j].getImageOver();
	}
	
	public String[][] getAllImagesOver() {
		String[][] imgOver = new String[10][18];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				imgOver[i][j] = map[i][j].getImageOver();
			}
		}
		return imgOver;
	}
	
	public void setImageOver(int i, int j) {
		map[i][j].setImageOver();
	}
	
	public void setPossessed(int i, int j) {
		map[i][j].setPossessed();
	}
	
	public boolean getPossessed(int i, int j) {
		return map[i][j].isPossessed();
	}
	
	public int getPopulation(int i, int j) {
		return map[i][j].getPopulation();
	}
	
	public void buildCityHall(int i, int j) {
		map[i][j].buildCityHall();
	}
  
	public void buildHouse(int i, int j) {
		map[i][j].buildHouse();
	}
	
	public void buildFarm(int i, int j) {
		map[i][j].buildFarm();
	}
	
	public void buildHarbor(int i, int j) {
		map[i][j].buildHarbor();
	}

	public void buildLumberMill(int i, int j) {
		map[i][j].buildLumberMill();
	}

	public void buildMine(int i, int j) {
		map[i][j].buildMine();
	}
	
	public Case getCase(int i, int j) {
		return map[i][j];
	}
	
	public Building getBuilding(int i, int j) {
		return map[i][j].getBuilding();
	}
	
	public boolean isAdjacent(int[] coord) {
		if(coord[0] > 0) {
			if(coord[1] > 0) {
				if(coord[0] < map.length-1) {
					if(coord[1] < map[0].length-1) {
						if(map[coord[0]-1][coord[1]].isPossessed() || map[coord[0]+1][coord[1]].isPossessed() ||
							map[coord[0]][coord[1]-1].isPossessed() || map[coord[0]][coord[1]+1].isPossessed()) {
							return true;
						}
					}
				}
			}
		}
		if(coord[0] == 0) {
			if(coord[1] == 0) {
				if(map[coord[0]+1][coord[1]].isPossessed() || map[coord[0]][coord[1]+1].isPossessed()) {
					return true;
				}
			}
			else if(coord[1] == map[0].length-1){
				if(map[coord[0]+1][coord[1]].isPossessed() || map[coord[0]][coord[1]-1].isPossessed()) {
					return true;
				}
			}
			else {
				if(map[coord[0]+1][coord[1]].isPossessed() || map[coord[0]][coord[1]+1].isPossessed() || map[coord[0]][coord[1]-1].isPossessed()) {
					return true;
				}
			}
		}
		else if(coord[0] == map.length-1) {
			if(coord[1] == 0) {
				if(map[coord[0]-1][coord[1]].isPossessed() || map[coord[0]][coord[1]+1].isPossessed()) {
					return true;
				}
			}
			else if(coord[1] == map[0].length-1){
				if(map[coord[0]-1][coord[1]].isPossessed() || map[coord[0]][coord[1]-1].isPossessed()) {
					return true;
				}
			}
			else {
				if(map[coord[0]-1][coord[1]].isPossessed() || map[coord[0]][coord[1]+1].isPossessed() || map[coord[0]][coord[1]-1].isPossessed()) {
					return true;
				}
			}
		}
		else {
			if(coord[1] == 0) {
				if(map[coord[0]+1][coord[1]].isPossessed() || map[coord[0]-1][coord[1]].isPossessed() || map[coord[0]][coord[1]+1].isPossessed()) {
					return true;
				}
			}
			else if(coord[1] == map[0].length-1) {
				if(map[coord[0]+1][coord[1]].isPossessed() || map[coord[0]-1][coord[1]].isPossessed() || map[coord[0]][coord[1]-1].isPossessed()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void genererMap() {
		int valeur;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) { 
				valeur = (int) (n.creerNoise(i*61, j*61, 250)*40);
				if(valeur <= -10) {
					map[i][j] = new Water(i, j, "Water.png");
				}
				else if(valeur > -10 && valeur <= -1) {
					double r = Math.random();
					if(r <= 0.3) {
						map[i][j] = new Plain(i, j, "Grass_1.png");
					}
					else if(r > 0.3 && r <= 0.6) {
						map[i][j] = new Plain(i, j, "Grass_2.png");
					}
					else if(r > 0.6 && r <= 0.8) {
						map[i][j] = new Plain(i, j, "Grass_3.png");
					}
					else {
						map[i][j] = new Plain(i, j, "Grass_4.png");
					}
				}
				else if(valeur > -1 && valeur <= 6) {
					double r = Math.random();
					if(r <= 0.2) {
						map[i][j] = new Forest(i, j, "Forest_1.png");
					}
					else if(r <= 0.4) {
						map[i][j] = new Forest(i, j, "Forest_2.png");
					}
					else if(r <= 0.6) {
						map[i][j] = new Forest(i, j, "Forest_3.png");
					}
					else if(r <= 0.8) {
						map[i][j] = new Forest(i, j, "Forest_4.png");
					}
					else {
						map[i][j] = new Forest(i, j, "Forest_5.png");
					}
				}
				else {
					double r = Math.random();
					if(r <= 0.5) {
						map[i][j] = new Mountain(i, j, "Mountain_1.png");
					}
					else {
						map[i][j] = new Mountain(i, j, "Mountain_2.png");
					}
				}
			}
		}
		selectionWater();
	}
	
	private void selectionWater() {
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] instanceof Water) {
					if(i == 0 && j == 0) {
						if(!(map[i][j+1] instanceof Water) && !(map[i+1][j] instanceof Water)){
							map[i][j].setImage("WaterCornerBDInt.png");
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterD.png");
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterB.png");
						}
						else if(!(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDExt.png");
						}
						else {
							map[i][j].setImage("Water.png");
						}
					}
					else if(i == 0 && j == map[0].length-1) {
						if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water)){
							map[i][j].setImage("WaterCornerBGInt.png");
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage("WaterG.png");
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterB.png");
						}
						else if(!(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt.png");
						}
						else {
							map[i][j].setImage("Water.png");
						}
					}
					else if(i == map.length-1 && j == 0) {
						if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water)){
							map[i][j].setImage("WaterCornerHDInt.png");
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterD.png");
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterH.png");
						}
						else if(!(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt.png");
						}
						else {
							map[i][j].setImage("Water.png");
						}
					}
					else if(i == map.length-1 && j == map[0].length-1) {
						if(!(map[i-1][j] instanceof Water) && !(map[i][j-1] instanceof Water)){
							map[i][j].setImage("WaterCornerHGInt.png");
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage("WaterG.png");
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterH.png");
						}
						else if(!(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt.png");
						}
						else {
							map[i][j].setImage("Water.png");
						}
					}
					else if(i == 0) {
						if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)){
							map[i][j].setImage("WaterCornerBGInt_CornerBDInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGInt.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterGD.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDExt_G.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt_D.png");
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage("WaterG.png");
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterD.png");
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterB.png");
						}
						else if(!(map[i+1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt_CornerBDExt.png");
						}
						else if(!(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDExt.png");
						}
						else if(!(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt.png");
						}
						else {
							map[i][j].setImage("Water.png");
						}
					}
					else if(i == map.length-1) {
						if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i][j+1] instanceof Water)){
							map[i][j].setImage("WaterCornerHGInt_CornerHDInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGInt.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterGD.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_G.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_D.png");
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage("WaterG.png");
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterD.png");
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterH.png");
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerHDExt.png");
						}
						else if(!(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt.png");
						}
						else if(!(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt.png");
						}
						else {
							map[i][j].setImage("Water.png");
						}
					}
					else if(j == 0) {
						if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)){
							map[i][j].setImage("WaterCornerHDInt_CornerBDInt.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDInt.png");
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDInt.png");
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterHB.png");
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_B.png");
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDExt_H.png");
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerBDExt.png");
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterH.png");
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterD.png");
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterB.png");
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_CornerBDExt.png");
						}
						else if(!(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt.png");
						}
						else if(!(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt.png");
						}
						else {
							map[i][j].setImage("Water.png");
						}
					}
					else if(j == map[0].length-1) {
						if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)){
							map[i][j].setImage("WaterCornerHGInt_CornerBGInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGInt.png");
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGInt.png");
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterHB.png");
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt_H.png");
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_B.png");
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterH.png");
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage("WaterG.png");
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterB.png");
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerBGExt.png");
						}
						else if(!(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt.png");
						}
						else if(!(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt.png");
						}
						else {
							map[i][j].setImage("Water.png");
						}
					}
					else {
						if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerAllInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGInt_CornerBGInt.png");
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDInt_CornerBDInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGInt_CornerBDInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGInt_CornerHDInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDExt_CornerHGInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_CornerBGInt.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt_CornerHDInt.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerBDInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGInt.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDInt.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDInt.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterGD.png");
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterHB.png");
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt_CornerBDExt_H.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_CornerBDExt_G.png");
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerHDExt_B.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerBGExt_D.png");
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDExt_H.png");
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt_H.png");
						}
						
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDExt_G.png");
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_G.png");
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_B.png");
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_B.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_D.png");
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt_D.png");
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage("WaterH.png");
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage("WaterG.png");
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage("WaterB.png");
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage("WaterD.png");
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerAllExt.png");
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerHDExt_CornerBGExt.png");
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerHDExt_CornerBDExt.png");
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i+1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerBGExt_CornerBDExt.png");
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_CornerBGExt_CornerBDExt.png");
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerHDExt.png");
						}
						else if(!(map[i+1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt_CornerBDExt.png");
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_CornerBDExt.png");
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerBGExt.png");
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt_CornerBDExt.png");
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt_CornerBGExt.png");
						}
						else if(!(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHGExt.png");
						}
						else if(!(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerHDExt.png");
						}
						else if(!(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBGExt.png");
						}
						else if(!(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage("WaterCornerBDExt.png");
						}
						else {
							map[i][j].setImage("Water.png");
						}
					}
				}
			}
		}
	}
}
