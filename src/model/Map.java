package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Noise;

public class Map {
	private Case[][] map = new Case[10][18];
	private Noise n;
	
	private Image grass_1, grass_2, grass_3, grass_4;
	private Image forest_1, forest_2, forest_3, forest_4, forest_5;
	private Image water, waterB, waterCornerAllExt, waterCornerBDExt, waterCornerBDExt_CornerHGInt, waterCornerBDExt_G, waterCornerBDExt_H,
					waterCornerBDInt, waterCornerBGExt, waterCornerHGExt_B, waterCornerBGExt_CornerBDExt, waterCornerBGExt_CornerHDInt, waterCornerBGExt_D,
					waterCornerBGInt, waterCornerBGExt_H, waterCornerHDExt, waterCornerHDExt_B, waterCornerHDExt_CornerBDExt, waterCornerHDExt_CornerBGExt,
					waterCornerHDExt_CornerBGExt_CornerBDExt, waterCornerHDExt_CornerBGInt, waterCornerHDInt, waterCornerHGExt, waterCornerHGExt_CornerBDExt,
					waterCornerHGExt_CornerBDInt, waterCornerHGExt_CornerBGExt, waterCornerHGExt_CornerBGExt_CornerBDExt, waterCornerHGExt_CornerHDExt,
					waterCornerHGExt_CornerHDExt_CornerBDExt, waterCornerHGExt_CornerHDExt_CornerBGExt, waterCornerHGInt, waterD, waterG, waterGD, waterH,
					waterHB, waterCornerHDExt_G, waterCornerHGExt_D, waterCornerBGInt_CornerBDInt, waterCornerHDInt_CornerBDInt, waterCornerAllInt,
					waterCornerHGInt_CornerBGInt, waterCornerHGInt_CornerHDInt, waterCornerBGExt_CornerBDExt_H, waterCornerHGExt_CornerBGExt_D,
					waterCornerHGExt_CornerHDExt_B, waterCornerHDExt_CornerBDExt_G;
	private Image mountain_1, mountain_2;
	
	public Map() {
		n = new Noise();
		int i = 0;
		try {
			water = ImageIO.read(new File("Graphismes/Water.png"));
			System.out.println(i);
			waterB = ImageIO.read(new File("Graphismes/WaterB.png"));
			waterCornerAllExt = ImageIO.read(new File("Graphismes/WaterCornerAllExt.png"));
			waterCornerBDExt = ImageIO.read(new File("Graphismes/WaterCornerBDExt.png"));
			waterCornerBDExt_CornerHGInt = ImageIO.read(new File("Graphismes/WaterCornerBDExt_CornerHGInt.png"));
			waterCornerBDExt_G = ImageIO.read(new File("Graphismes/WaterCornerBDExt_G.png"));
			waterCornerBDExt_H = ImageIO.read(new File("Graphismes/WaterCornerBDExt_H.png"));
			waterCornerBDInt = ImageIO.read(new File("Graphismes/WaterCornerBDInt.png"));
			System.out.println(i+=1);
			waterCornerBGExt = ImageIO.read(new File("Graphismes/WaterCornerBGExt.png"));
			System.out.println(i+=1);
			waterCornerHGExt_B = ImageIO.read(new File("Graphismes/WaterCornerHGExt_B.png"));
			System.out.println(i+=1);
			waterCornerBGExt_CornerBDExt = ImageIO.read(new File("Graphismes/WaterCornerBGExt_CornerBDExt.png"));
			System.out.println(i+=1);
			waterCornerBGExt_CornerHDInt = ImageIO.read(new File("Graphismes/WaterCornerBGExt_CornerHDInt.png"));
			System.out.println(i+=1);
			waterCornerBGExt_D = ImageIO.read(new File("Graphismes/WaterCornerBGExt_D.png"));
			System.out.println(i+=1);
			waterCornerBGInt = ImageIO.read(new File("Graphismes/WaterCornerBGInt.png"));
			System.out.println(i+=1);
			waterCornerBGExt_H = ImageIO.read(new File("Graphismes/WaterCornerBGExt_H.png"));
			System.out.println(i+=1);
			waterCornerHDExt = ImageIO.read(new File("Graphismes/WaterCornerHDExt.png"));
			System.out.println(i+=1);
			waterCornerHDExt_B = ImageIO.read(new File("Graphismes/waterCornerHDExt_B.png"));
			System.out.println(i+=1);
			waterCornerHDExt_CornerBDExt = ImageIO.read(new File("Graphismes/WaterCornerHDExt_CornerBDExt.png"));
			System.out.println(i+=1);
			waterCornerHDExt_CornerBGExt = ImageIO.read(new File("Graphismes/WaterCornerHDExt_CornerBGExt.png"));
			System.out.println(i+=1);
			waterCornerHDExt_CornerBGExt_CornerBDExt = ImageIO.read(new File("Graphismes/WaterCornerHDExt_CornerBGExt_CornerBDExt.png"));
			System.out.println(i+=1);
			waterCornerHDExt_CornerBGInt = ImageIO.read(new File("Graphismes/WaterCornerHDExt_CornerBGInt.png"));
			System.out.println(i+=1);
			waterCornerHDInt = ImageIO.read(new File("Graphismes/WaterCornerHDInt.png"));
			System.out.println(i+=1);
			waterCornerHGExt = ImageIO.read(new File("Graphismes/WaterCornerHGExt.png"));
			System.out.println(i+=1);
			waterCornerHGExt_CornerBDExt = ImageIO.read(new File("Graphismes/WaterCornerHGExt_CornerBDExt.png"));
			System.out.println(i+=1);
			waterCornerHGExt_CornerBDInt = ImageIO.read(new File("Graphismes/WaterCornerHGExt_CornerBDInt.png"));
			System.out.println(i+=1);
			waterCornerHGExt_CornerBGExt = ImageIO.read(new File("Graphismes/WaterCornerHGExt_CornerBGExt.png"));
			System.out.println(i+=1);
			waterCornerHGExt_CornerBGExt_CornerBDExt = ImageIO.read(new File("Graphismes/WaterCornerHGExt_CornerBGExt_CornerBDExt.png"));
			System.out.println(i+=1);
			waterCornerHGExt_CornerHDExt = ImageIO.read(new File("Graphismes/WaterCornerHGExt_CornerHDExt.png"));
			System.out.println(i+=1);
			waterCornerHGExt_CornerHDExt_CornerBDExt = ImageIO.read(new File("Graphismes/WaterCornerHGExt_CornerHDExt_CornerBDExt.png"));
			System.out.println(i+=1);
			waterCornerHGExt_CornerHDExt_CornerBGExt = ImageIO.read(new File("Graphismes/WaterCornerHGExt_CornerHDExt_CornerBGExt.png"));
			System.out.println(i+=1);
			waterCornerHGInt = ImageIO.read(new File("Graphismes/WaterCornerHGInt.png"));
			System.out.println(i+=1);
			waterD = ImageIO.read(new File("Graphismes/WaterD.png"));
			System.out.println(i+=1);
			waterG = ImageIO.read(new File("Graphismes/WaterG.png"));
			System.out.println(i+=1);
			waterGD = ImageIO.read(new File("Graphismes/WaterGD.png"));
			System.out.println(i+=1);
			waterH = ImageIO.read(new File("Graphismes/WaterH.png"));
			System.out.println(i+=1);
			waterHB = ImageIO.read(new File("Graphismes/WaterHB.png"));
			System.out.println(i+=1);
			waterCornerHDExt_G = ImageIO.read(new File("Graphismes/WaterCornerHDExt_G.png"));
			System.out.println(i+=1);
			waterCornerHGExt_D = ImageIO.read(new File("Graphismes/WaterCornerHGExt_D.png"));
			System.out.println(i+=1);
			waterCornerBGInt_CornerBDInt = ImageIO.read(new File("Graphismes/WaterCornerBGInt_CornerBDInt.png"));
			System.out.println(i+=1);
			waterCornerHDInt_CornerBDInt = ImageIO.read(new File("Graphismes/WaterCornerHDInt_CornerBDInt.png"));
			System.out.println(i+=1);
			waterCornerAllInt = ImageIO.read(new File("Graphismes/WaterCornerAllInt.png"));
			System.out.println(i+=1);
			waterCornerHGInt_CornerBGInt = ImageIO.read(new File("Graphismes/WaterCornerHGInt_CornerBGInt.png"));
			System.out.println(i+=1);
			waterCornerHGInt_CornerHDInt = ImageIO.read(new File("Graphismes/WaterCornerHGInt_CornerHDInt.png"));
			System.out.println(i+=1);
			waterCornerBGExt_CornerBDExt_H = ImageIO.read(new File("Graphismes/WaterCornerBGExt_CornerBDExt_H.png"));
			System.out.println(i+=1);
			waterCornerHGExt_CornerBGExt_D = ImageIO.read(new File("Graphismes/WaterCornerHGExt_CornerBGExt_D.png"));
			System.out.println(i+=1);
			waterCornerHGExt_CornerHDExt_B = ImageIO.read(new File("Graphismes/WaterCornerHGExt_CornerHDExt_B.png"));
			System.out.println(i+=1);
			waterCornerHDExt_CornerBDExt_G = ImageIO.read(new File("Graphismes/WaterCornerHDExt_CornerBDExt_G.png"));
			System.out.println(i+=1);
			
			mountain_1 = ImageIO.read(new File("Graphismes/Mountain_1.png"));
			mountain_2 = ImageIO.read(new File("Graphismes/Mountain_2.png"));
			grass_1 = ImageIO.read(new File("Graphismes/Grass_1.png"));
			grass_2 = ImageIO.read(new File("Graphismes/Grass_2.png"));
			grass_3 = ImageIO.read(new File("Graphismes/Grass_3.png"));
			grass_4 = ImageIO.read(new File("Graphismes/Grass_4.png"));
			forest_1 = ImageIO.read(new File("Graphismes/Forest_1.png"));
			forest_2 = ImageIO.read(new File("Graphismes/Forest_2.png"));
			forest_3 = ImageIO.read(new File("Graphismes/Forest_3.png"));
			forest_4 = ImageIO.read(new File("Graphismes/Forest_4.png"));
			forest_5 = ImageIO.read(new File("Graphismes/Forest_5.png"));
		}
		catch(IOException e) {
			System.out.println(e);
		}
		System.out.println(map.length);
	}
	
	public Image getImage(int i, int j) {
		return map[i][j].getImage();
	}
	
	public void genererMap() {
		int valeur;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) { 
				valeur = (int) (n.creerNoise(i*61, j*61, 250)*40);
				if(valeur <= -10) {
					map[i][j] = new Water(i, j, water);
				}
				else if(valeur > -10 && valeur <= -1) {
					double r = Math.random();
					if(r <= 0.3) {
						map[i][j] = new Plain(i, j, grass_1);
					}
					else if(r > 0.3 && r <= 0.6) {
						map[i][j] = new Plain(i, j, grass_2);
					}
					else if(r > 0.6 && r <= 0.8) {
						map[i][j] = new Plain(i, j, grass_3);
					}
					else {
						map[i][j] = new Plain(i, j, grass_4);
					}
				}
				else if(valeur > -1 && valeur <= 6) {
					double r = Math.random();
					if(r <= 0.2) {
						map[i][j] = new Forest(i, j, forest_1);
					}
					else if(r <= 0.4) {
						map[i][j] = new Forest(i, j, forest_2);
					}
					else if(r <= 0.6) {
						map[i][j] = new Forest(i, j, forest_3);
					}
					else if(r <= 0.8) {
						map[i][j] = new Forest(i, j, forest_4);
					}
					else {
						map[i][j] = new Forest(i, j, forest_5);
					}
				}
				else {
					double r = Math.random();
					if(r <= 0.5) {
						map[i][j] = new Mountain(i, j, mountain_1);
					}
					else {
						map[i][j] = new Mountain(i, j, mountain_2);
					}
				}
			}
		}
		selectionWater();
	}
	
	private void selectionWater() {
		
		for(int i = 0; i < map.length; i++) {
			System.out.println();
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(i+";"+j+"|");
				if(map[i][j] instanceof Water) {
					if(i == 0 && j == 0) {
						System.out.println("Coin HG: "+i+";"+j);
						if(!(map[i][j+1] instanceof Water) && !(map[i+1][j] instanceof Water)){
							map[i][j].setImage(waterCornerBDInt);
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterD);
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterB);
						}
						else if(!(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBDExt);
						}
						else {
							map[i][j].setImage(water);
						}
					}
					else if(i == 0 && j == map[0].length-1) {
						System.out.println("Coin HD: "+i+";"+j);
						if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water)){
							map[i][j].setImage(waterCornerBGInt);
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage(waterG);
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterB);
						}
						else if(!(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt);
						}
						else {
							map[i][j].setImage(water);
						}
					}
					else if(i == map.length-1 && j == 0) {
						System.out.println("Coin BG: "+i+";"+j);
						if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water)){
							map[i][j].setImage(waterCornerHDInt);
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterD);
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterH);
						}
						else if(!(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt);
						}
						else {
							map[i][j].setImage(water);
						}
					}
					else if(i == map.length-1 && j == map[0].length-1) {
						System.out.println("Coin BD: "+i+";"+j);
						if(!(map[i-1][j] instanceof Water) && !(map[i][j-1] instanceof Water)){
							map[i][j].setImage(waterCornerHGInt);
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage(waterG);
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterH);
						}
						else if(!(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt);
						}
						else {
							map[i][j].setImage(water);
						}
					}
					else if(i == 0) {
						System.out.println("C�t� H: "+i+";"+j);
						if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)){
							map[i][j].setImage(waterCornerBGInt_CornerBDInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerBGInt);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerBDInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterGD);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBDExt_G);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt_D);
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage(waterG);
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterD);
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterB);
						}
						else if(!(map[i+1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt_CornerBDExt);
						}
						else if(!(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBDExt);
						}
						else if(!(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt);
						}
						else {
							map[i][j].setImage(water);
						}
					}
					else if(i == map.length-1) {
						System.out.println("C�t� B: "+i+";"+j);
						if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i][j+1] instanceof Water)){
							map[i][j].setImage(waterCornerHGInt_CornerHDInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerHGInt);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerHDInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterGD);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_G);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_D);
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage(waterG);
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterD);
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterH);
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerHDExt);
						}
						else if(!(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt);
						}
						else if(!(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt);
						}
						else {
							map[i][j].setImage(water);
						}
					}
					else if(j == 0) {
						System.out.println("C�t� G: "+i+";"+j);
						if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)){
							map[i][j].setImage(waterCornerHDInt_CornerBDInt);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerHDInt);
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBDInt);
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterHB);
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_B);
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBDExt_H);
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerBDExt);
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterH);
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterD);
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterB);
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_CornerBDExt);
						}
						else if(!(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt);
						}
						else if(!(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt);
						}
						else {
							map[i][j].setImage(water);
						}
					}
					else if(j == map[0].length-1) {
						System.out.println("C�t� D: "+i+";"+j);
						if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)){
							map[i][j].setImage(waterCornerHGInt_CornerBGInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerHGInt);
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGInt);
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterHB);
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt_H);
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_B);
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterH);
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage(waterG);
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterB);
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerBGExt);
						}
						else if(!(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt);
						}
						else if(!(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt);
						}
						else {
							map[i][j].setImage(water);
						}
					}
					else {
						if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerAllInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerHGInt_CornerBGInt);
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDInt_CornerBDInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGInt_CornerBDInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGInt_CornerHDInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBDExt_CornerHGInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_CornerBGInt);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt_CornerHDInt);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerBDInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerHGInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerBGInt);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerHDInt);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterCornerBDInt);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterGD);
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterHB);
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt_CornerBDExt_H);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_CornerBDExt_G);
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerHDExt_B);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerBGExt_D);
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBDExt_H);
						}
						else if(!(map[i-1][j] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt_H);
						}
						
						else if(!(map[i][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBDExt_G);
						}
						else if(!(map[i][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_G);
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_B);
						}
						else if(!(map[i+1][j] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_B);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_D);
						}
						else if(!(map[i][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt_D);
						}
						else if(!(map[i-1][j] instanceof Water)) {
							map[i][j].setImage(waterH);
						}
						else if(!(map[i][j-1] instanceof Water)) {
							map[i][j].setImage(waterG);
						}
						else if(!(map[i+1][j] instanceof Water)) {
							map[i][j].setImage(waterB);
						}
						else if(!(map[i][j+1] instanceof Water)) {
							map[i][j].setImage(waterD);
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerAllExt);
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerHDExt_CornerBGExt);
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerHDExt_CornerBDExt);
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i+1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerBGExt_CornerBDExt);
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_CornerBGExt_CornerBDExt);
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerHDExt);
						}
						else if(!(map[i+1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt_CornerBDExt);
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_CornerBDExt);
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerBGExt);
						}
						else if(!(map[i-1][j-1] instanceof Water) && !(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt_CornerBDExt);
						}
						else if(!(map[i-1][j+1] instanceof Water) && !(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt_CornerBGExt);
						}
						else if(!(map[i-1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerHGExt);
						}
						else if(!(map[i-1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerHDExt);
						}
						else if(!(map[i+1][j-1] instanceof Water)) {
							map[i][j].setImage(waterCornerBGExt);
						}
						else if(!(map[i+1][j+1] instanceof Water)) {
							map[i][j].setImage(waterCornerBDExt);
						}
						else {
							map[i][j].setImage(water);
						}
					}
				}
			}
		}
	}
	
}