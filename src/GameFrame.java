import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class GameFrame extends JFrame
{
	private Image[] terrain;
	private Panel p;
	
	
	public GameFrame(String title)
	{
		super(title);
		
		terrain = new Image[10];
		p = new Panel();
		p.setPreferredSize(new Dimension(940,651));
		
		try
		{
			for(int i = 0 ; i<10 ; i++)
				terrain[i] = ImageIO.read(new File("img/terrain.png"));
		}
		catch(IOException e)
		{
			System.out.println("Erreur image \n" + e);
		}
		
		add(p);
	}
	
	public class Panel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			for(int i = 0 ; i<2444 ; i += 188)
				g.drawImage(terrain[1], i, 0, this);
			
			for(int i = 94 ; i<2444 ; i += 188)
				g.drawImage(terrain[1], i, 163, this);
		}
	}
}
