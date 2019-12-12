package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Adventurer;

@SuppressWarnings("serial")
public class AdventurerPanel extends JPanel {
	
	//private Adventurer adventurer;
	
	private int typeOfAdv;
	
	private JButton selected;
	
	private static Font font = new Font("Sans Serif", Font.PLAIN, 18);
	private static Color color = new Color(240,240,240);
	
	private String name;
	private int level;
	private int xp;
	private int hp;
	private int atk, def, mag;
	private String magT;
	private String available;
	
	public int getTypeOfAdv() {
		return typeOfAdv;
	}
	
	public AdventurerPanel(Adventurer adventurer) {
		super(new BorderLayout());
		
		typeOfAdv = 0;
		
		name = adventurer.getName();
		level = adventurer.getLvl();
		xp = adventurer.getXp();
		hp = adventurer.getHp();
		atk = adventurer.getAttack();
		def = adventurer.getDefense();
		mag = adventurer.getMagic();
		
		if(adventurer.getTypeOfMagic() == 0) {
			magT = "None";
		}
		else if (adventurer.getTypeOfMagic() == 1) {
			magT = "Def";
		}
		else {
			magT = "Atk";
		}
		
		if(adventurer.isAvailable()) {
			available = "Available";
		}
		else {
			available = "Unavailable";
		}
		
		selected = new JButton("Select Adventurer");
		selected.setFont(font);
		selected.setPreferredSize(new Dimension(255,25));
		add(selected, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(255,165));
		setBackground(new Color(100,100,100));
	}
	
	public AdventurerPanel(int adv) {
		super(new BorderLayout());
		this.typeOfAdv = adv;
		if(typeOfAdv == 1) {
			selected = new JButton("EMPTY");
		}
		else {
			selected = new JButton("BLOCKED");
		}
		selected.setFont(font);
		selected.setPreferredSize(new Dimension(255,25));
		add(selected, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(255,165));
		setBackground(new Color(100,100,100));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(typeOfAdv == 1) { //empty
			//try {
				g.setFont(font);
				g.setColor(color);
				
				g.drawString("Slot Empty", 82, 127);
				
				//g.drawImage(ImageIO.read(new File("Graphismes/Forest_1.png")), 0, 0, this);
				
			//} catch (IOException e) {}
		}
		else if(typeOfAdv == 2) { //bloked
			//try {
			g.setFont(font);
			g.setColor(color);
			
			g.drawString("Slot Blocked", 82, 127);
			
			//g.drawImage(ImageIO.read(new File("Graphismes/Forest_1.png")), 0, 0, this);
			
		//} catch (IOException e) {}
		}
		else {
			//try {
				g.setFont(font);
				g.setColor(color);
				
				
				//Name
				g.drawString(name, 10, 23);
				//Level
				g.drawString("Lvl:" + level, 174, 23);
				//Xp
				g.drawString("XP:", 10, 46);
				//Xp rectangle
				g.drawRect(48, 28, 200, 18);
				g.fillRect(48, 28, xp*2, 18); // x2 car xp sur 100
				//Xp %
				g.setColor(Color.black);
				g.drawString(xp + "%", 134, 44);
				g.setColor(color);
				//Health
				g.drawString("HP:", 10, 69);
				//Health rectangle
				g.drawRect(48, 51, 200, 18);
				g.fillRect(48, 51, hp*2, 18); // x2 car les hp sont sur 100
				//Health %
				g.setColor(Color.black);
				g.drawString(hp +"%", 134, 67);
				g.setColor(color);
				//Attack
				g.drawString("ATK: " + atk, 10, 92);
				//Defense
				g.drawString("DEF: " + def, 116, 92);
				//Magic
				g.drawString("MAG: " + mag, 10, 112);
				//Magic type
				g.drawString("MAG Type: " + magT, 116, 112);
				//Status
				g.drawString("Status: " + available, 10, 135);
				//g.drawImage(ImageIO.read(new File("Graphismes/Forest_1.png")), 0, 0, this);
				
			//} catch (IOException e) {}
		}
	}
}
