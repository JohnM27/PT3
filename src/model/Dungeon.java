package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Dungeon implements Serializable {
	
	private final static int NB_ROOM = 5;
	private final static int NB_FLOOR = 5;
	/**
	 * List of adventurer in the donjon
	 */
	private List<Adventurer> adventurer;
	
	/**
	 * Number of room per floor
	 */
	private int[][] floor;
	
	/**
	 * Say if the room is validate
	 */
	private boolean[][] validate;
	
	private int foodForAdv;
	
	public Dungeon() {
		adventurer = new ArrayList<Adventurer>();
		foodForAdv = 1;
		
		floor = new int[NB_FLOOR][];
		floor[0] = new int[(int) (Math.random()*(5-2+1))];
		for(int i = 1; i < floor.length; i++) {
			floor[i] = new int[NB_ROOM];
		}
		for(int i = 0; i < floor.length; i++) {
			for(int j = 0; j < floor[i].length; j++) {
				floor[i][j] = 0;
			}
		}
		
		//generate for the room for say if it's validate
		validate = new boolean[floor.length][];
		validate[0] = new boolean[floor[0].length];
		for(int i = 1; i < validate.length; i++) {
			validate[i] = new boolean[floor[1].length];
		}
		for(int i = 0; i < validate.length; i++) {
			for(int j = 0; j < validate[i].length; j++) {
				validate[i][j] = false;
			}
		}
	}
	
	/*
	 * Generate the fight in the donjon
	 */
	public void generateFight() {
		for(int i = 0; i < floor.length; i++) {
			for(int j = 0; j < floor[i].length; j++) {
				if(floor[i][j] == 1) {
					if(i == 4 && j == 4) {
						System.out.println("Generate Boss");
					}
					else {
						System.out.println("generate Fight");
					}
				}
			}
		}
	}
	
	/**
	 * Say if it's a monster or not
	 */
	public void generateAction() {
		
		if(Math.random() <= 0.5) {
			generateFight();
		}
		else {
			//generateLoot()...
		}
	}
	
	/**
	 * Add Adventurer in the donjon
	 * @param adv
	 */
	public void addAdventurer(Adventurer adv) {
		adventurer.add(adv);
	}
	
	/**
	 * Add all adventurer in the donjon (load)
	 */
	public void addAllAdventurer(List<Adventurer> adv) {
		adventurer = adv;
	}

	public void removeAdventurer() {
		adventurer.removeAll(adventurer);
	}

	public void removeAdventurer(int i) {
		adventurer.remove(i);
	}

	public List<Adventurer> getAdventurer() {
		return adventurer;
	}
	
	public int getNbFood() {
		return foodForAdv;
	}

	public void setFood(boolean ml) {
		if(ml) {
			foodForAdv++;
		}
		else {
			foodForAdv--;
		}
		
		if(foodForAdv == 11) {
			foodForAdv = 1;
		}
		if(foodForAdv == 0) {
			foodForAdv = 10;
		}
	}
}
