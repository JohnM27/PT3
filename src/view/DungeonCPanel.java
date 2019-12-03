package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DungeonCPanel extends JPanel {
	
	
	public DungeonCPanel() {
		
	}
	
	public void paintComponent(Graphics g) {
		try {
			g.drawImage(ImageIO.read(new File("Graphismes/test.png")), 0, 0, this);
			
		} catch (IOException e) {}
	}
}
