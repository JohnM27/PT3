package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Adventurer {
	private String name;
	private int lvl;
	private int hp;
	private int attack;
	private int defense;
	private int magic;
	private boolean available;
	/**
	 * true for attack
	 * false for defense
	 */
	private boolean typeOfMagic = false;
	
	public Adventurer() {
		name = setName();
		
		lvl = 1;
		hp = 100;
		attack = setStat();
		defense = setStat();
		magic = setStat();
		available = true;
	}
	
	private String setName() {
		String name = null;
		
		int ligne = (int) (Math.random() * 11627);
		try { 
			File file = new File("Name.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(ligne >= 0 && (name = br.readLine()) != null) {
				ligne--;
			}
		} catch (IOException ex) {} 
		
		return name;
	}
	
	private int setStat() {
		int stat = 50;
		
		int crit = (int) (Math.random()*10);
		int val = (int) (Math.random()*30);
		
		if(val >= 0 && val <= 14) {
			if(crit >= 0 && crit <= 1) {
				stat = (int) (stat - val * 1.5);
			}
			else {
				stat = stat - val;
			}
		}
		else {
			if(crit >= 0 && crit <= 1) {
				stat = stat + (15-val) * 2;
			}
			else {
				stat = stat + (15-val);
			}
		}
		
		return stat;
	}
	
	public String getName() {
		return name;
	}
	public int getLvl() {
		return lvl;
	}
	public int getHp() {
		return hp;
	}
	public int getAttack() {
		return attack;
	}
	public int getDefense() {
		return defense;
	}
	public int getMagic() {
		return magic;
	}
	public boolean isAvailable() {
		return available;
	}
	public boolean isTypeOfMagic() {
		return typeOfMagic;
	}

	@Override
	public String toString() {
		return "Adventurer [name=" + name + ", lvl=" + lvl + ", hp=" + hp + ", attack=" + attack + ", defense="
				+ defense + ", magic=" + magic + ", available=" + available + ", typeOfMagic=" + typeOfMagic + "]";
	}
	
	
}
