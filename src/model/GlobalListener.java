package model;

import java.util.EventListener;

public interface GlobalListener extends EventListener {

	public void jourChanged(MapEvent event);

	public void MapGenerated(MapEvent event);
	
	public void FogOff(MapEvent event);

	public void ModifySCPanel(MapEvent event);
}
