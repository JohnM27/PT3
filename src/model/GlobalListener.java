package model;

import java.util.EventListener;

public interface GlobalListener extends EventListener {

	public void jourChanged(MapEvent event);

	public void MapGenerated(MapEvent mapGeneratedEvent);
	
	public void FogOff(MapEvent FogOffEvent);
}
