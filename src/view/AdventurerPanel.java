package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AdventurerPanel extends JPanel {
	
	//private Adventurer adventurer;
	
	private JButton selected;
	
	private static Font font = new Font("Sans Serif", Font.PLAIN, 18);
	private static Color color = new Color(240,240,240);
	
	public AdventurerPanel() {
		super(new BorderLayout());
		
		selected = new JButton("Select Adventurer");
		selected.setFont(font);
		selected.setPreferredSize(new Dimension(255,25));
		add(selected, BorderLayout.SOUTH);
				
		setPreferredSize(new Dimension(255,165));
		setBackground(new Color(100,100,100));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//try {
			g.setFont(font);
			g.setColor(color);
			
			
			//Name
			g.drawString("Math�o FAIVRE", 10, 23);
			//Level
			g.drawString("Lvl:" + 10, 174, 23);
			//Xp
			g.drawString("XP:", 10, 46);
			//Xp rectangle
			g.drawRect(48, 28, 200, 18);
			g.fillRect(48, 28, 100, 18);
			//Xp %
			g.setColor(Color.black);
			g.drawString(100 + "%", 134, 44);
			g.setColor(color);
			//Health
			g.drawString("HP:", 10, 69);
			//Health rectangle
			g.drawRect(48, 51, 200, 18);
			g.fillRect(48, 51, 100, 18);
			//Health %
			g.setColor(Color.black);
			g.drawString(100 +"%", 134, 67);
			g.setColor(color);
			//Attack
			g.drawString("ATK: " + 100, 10, 92);
			//Defense
			g.drawString("DEF: " + 100, 116, 92);
			//Magic
			g.drawString("MAG: " + 100, 10, 112);
			//Magic type
			g.drawString("MAG Type: " + "ATK", 116, 112);
			//Status
			g.drawString("Status: Available", 10, 135);
			//g.drawImage(ImageIO.read(new File("Graphismes/Forest_1.png")), 0, 0, this);
			
		//} catch (IOException e) {}
	}
}
