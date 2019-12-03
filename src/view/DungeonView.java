package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;

public class DungeonView extends View /*implements DungeonListener*/ {
	
	private JFrame frame;
	
	private DungeonCPanel dungeonCPanel;
	private DungeonSPanel dungeonSPanel;
	private DungeonWPanel dungeonWPanel;
	private JScrollPane scroll;
	
	public DungeonView(Controller controller, JFrame frame) {
		super(controller);
		
		this.frame = frame;
		
		dungeonCPanel = new DungeonCPanel();
		dungeonSPanel = new DungeonSPanel(super.getController());
		dungeonWPanel = new DungeonWPanel(super.getController());
		
		scroll = new JScrollPane(dungeonWPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
	}


	@Override
	public void display() {
		
		frame.add(dungeonCPanel, BorderLayout.CENTER);
		frame.add(dungeonSPanel, BorderLayout.SOUTH);
		frame.add(scroll, BorderLayout.WEST);
		
		frame.revalidate();
		frame.repaint();
	}


	@Override
	public void close() {
		frame.getContentPane().removeAll();
	}
}
