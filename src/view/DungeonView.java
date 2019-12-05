package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import controller.Controller;
import model.DungeonEvent;
import model.DungeonListener;

public class DungeonView extends View implements DungeonListener {
	
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
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI()
	    {   
	        @Override
	        protected JButton createDecreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        @Override    
	        protected JButton createIncreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        private JButton createZeroButton() {
	            JButton jbutton = new JButton();
	            jbutton.setPreferredSize(new Dimension(0, 0));
	            jbutton.setMinimumSize(new Dimension(0, 0));
	            jbutton.setMaximumSize(new Dimension(0, 0));
	            return jbutton;
	        }
	        
	        protected void configureScrollBarColors() {
	            this.thumbColor = new Color(200,200,200);
	            this.thumbHighlightColor = new Color(150,150,150);
	        }
	    });
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

	@Override
	public void AddAdventurer(DungeonEvent event) {
		dungeonWPanel.addAdventurer(event.getLastAdventurer());
	}

	@Override
	public void Refresh(DungeonEvent event) {
		dungeonWPanel.addAllAdventurer(event.getAdventurers());
	}
}
