package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.Controller;
import model.Map;

public class HudCPanel extends JPanel {
	private Controller controller;
	
	private Map m = new Map();
	private Image grass_1, grass_2, grass_3, grass_4;
	private Image forest_1, forest_2, forest_3, forest_4, forest_5;
	private Image water;
	private Image mountain_1, mountain_2;
	
	private Image[][] map = new Image[18][10];
	
	
	public HudCPanel(Controller controller) {
		super();
		
		this.controller = controller;

		this.addMouseListener(new Mouse());
		this.setPreferredSize(new Dimension(1098, 610));
		
		m.genererMap();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < 610; i = i+61) {
			for(int j = 0; j < 1098; j = j+61) {
				g.drawImage(m.getImage(i/61, j/61), j, i, this);
			}
		}
	}
	
	
	class Mouse extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println("Coordonnées:");
			System.out.println(x);
			System.out.println(x/61);
			System.out.println(y);
			System.out.println(y/61);
			}
	}
}
