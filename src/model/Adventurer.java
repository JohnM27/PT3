package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Adventurer implements Serializable {

	private String name;
	private int lvl;
	private int xp;
	private int hp;
	private int attack;
	private int defense;
	private int magic;
	private boolean available;
	/**
	 * 2 for attack
	 * 1 for defense
	 * 0 for none
	 */
	private int typeOfMagic;
	
	public Adventurer() {
		name = setName();
		
		lvl = 1;
		xp = 0;
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
			br.close();
		} catch (IOException ex) {}
		
		if(name == null) {
			System.out.println(ligne);
			name = "Fabrice";
		}
		
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
	public int getXp() {
		return xp;
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
	public int getTypeOfMagic() {
		return typeOfMagic;
	}

	@Override
	public String toString() {
		return "Adventurer [name=" + name + ", lvl=" + lvl + ", hp=" + hp + ", attack=" + attack + ", defense="
				+ defense + ", magic=" + magic + ", available=" + available + ", typeOfMagic=" + typeOfMagic + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attack;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + defense;
		result = prime * result + hp;
		result = prime * result + lvl;
		result = prime * result + magic;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + typeOfMagic;
		result = prime * result + xp;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adventurer other = (Adventurer) obj;
		if (attack != other.attack)
			return false;
		if (available != other.available)
			return false;
		if (defense != other.defense)
			return false;
		if (hp != other.hp)
			return false;
		if (lvl != other.lvl)
			return false;
		if (magic != other.magic)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (typeOfMagic != other.typeOfMagic)
			return false;
		if (xp != other.xp)
			return false;
		return true;
	}
	
}
