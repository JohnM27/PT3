package view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DungeonCPanel extends JPanel {
	
	
	public DungeonCPanel() {
		super(new GridLayout(0,1));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			g.drawImage(ImageIO.read(new File("Graphismes/test.png")), 0, 0, this);
			
		} catch (IOException e) {}
		
		
	}
}
