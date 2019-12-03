package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

public class DungeonView extends View /*implements DungeonListener*/ {
	
	private JFrame frame;
	
	private DungeonCPanel dungeonCPanel;
	private DungeonSPanel dungeonSPanel;
	private DungeonWPanel dungeonWPanel;
	
	
	public DungeonView(Controller controller, JFrame frame) {
		super(controller);
		
		this.frame = frame;
		
		dungeonCPanel = new DungeonCPanel();
		dungeonSPanel = new DungeonSPanel(super.getController());
		dungeonWPanel = new DungeonWPanel(super.getController());
	}


	@Override
	public void display() {
		frame.add(dungeonCPanel, BorderLayout.CENTER);
		frame.add(dungeonSPanel, BorderLayout.SOUTH);
		frame.add(dungeonWPanel, BorderLayout.WEST);
		
		frame.revalidate();
		frame.repaint();
	}


	@Override
	public void close() {
		frame.getContentPane().removeAll();
	}
}
