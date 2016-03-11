package de.alpha.uhc.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import de.alpha.uhc.GState;

public class MotdListener implements Listener {
	
	public static String lobby;
	public static String ingame;
	
	public static boolean custommotd;
	
	@EventHandler
	public void onPing(ServerListPingEvent e) {
		
		if(custommotd == false) return;
		
		if(GState.isState(GState.LOBBY)) {
			e.setMotd(lobby);
		} else if(GState.isState(GState.INGAME)) {
			e.setMotd(ingame);
		}
		
	}
}
