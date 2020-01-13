package model;

import java.util.EventListener;

public interface GameListener extends EventListener {

	public void jourChanged(MapEvent event);

	public void MapGenerated(MapEvent event);
	
	public void FogOff(MapEvent event);

	public void ModifySCPanel(MapEvent event);

	public void ModifyPlainSCPanel(MapEvent event);

	public void HouseOn(MapEvent event);
	
	public void FishingOn(MapEvent event);

	public void LoggingOn(MapEvent event);

	public void MineOn(MapEvent event);

	public void ModifyForestSCPanel(MapEvent event);

	public void ModifyMountainSCPanel(MapEvent event);

	public void ModifyWaterSCPanel(MapEvent event);

	public void selected(MapEvent event);

	public void ModifyPlainCHSCPanel(MapEvent event);

	public void CityHallOn(MapEvent event);

	public void FarmOn(MapEvent event);

	public void Refresh(MapEvent event);

	public void RefreshRessourcesAdv(MapEvent event);

	public void ExitEvent(MapEvent event);

	public void ExitStopBanditsEvent(MapEvent event);
}
