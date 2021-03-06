package de.alphahelix.uhc.listeners;

import de.alphahelix.uhc.GState;
import de.alphahelix.uhc.UHC;
import de.alphahelix.uhc.instances.SimpleListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class ChatListener extends SimpleListener {

    public ChatListener(UHC uhc) {
        super(uhc);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        e.setCancelled(true);

        if (getRegister().getPlayerUtil().isDead(p)) {
            for (String dead : getRegister().getPlayerUtil().getDeads()) {
                Bukkit.getPlayer(dead).sendMessage(getRegister().getMainOptionsFile().getColorString("Spectator Prefix")
                        + getRegister().getStatsUtil().getUHCRank(p).getPrefix() + p.getDisplayName() + "§8: " + e.getMessage());
            }
        }

        if (GState.isState(GState.IN_GAME) || GState.isState(GState.PERIOD_OF_PEACE) || GState.isState(GState.END)) {
            getRegister().getPlayerUtil().getSurvivors().stream().filter(survivor -> !e.getMessage().startsWith(getRegister().getTeamFile().getString("Team.Chat"))).forEach(survivor -> {
                Bukkit.getPlayer(survivor)
                        .sendMessage(getUhc().getPrefix() + getRegister().getStatsUtil().getUHCRank(p).getPrefix() + p.getDisplayName() + "§8: " + e.getMessage());
            });
        } else {
            for (String all : getRegister().getPlayerUtil().getAll()) {
                Bukkit.getPlayer(all).sendMessage(getUhc().getPrefix() + getRegister().getStatsUtil().getUHCRank(p).getPrefix() + p.getDisplayName() + "§8: " + e.getMessage());
            }
        }

        if (e.getMessage().startsWith(getRegister().getTeamFile().getString("Team.Chat"))) {
            for (Player teamler : getRegister().getTeamManagerUtil().getTeamByPlayer(p).getPlayers()) {
                teamler.sendMessage(getUhc().getPrefix() + getRegister().getStatsUtil().getUHCRank(p).getPrefix() + p.getDisplayName() + "§8: " + e.getMessage().substring(1, e.getMessage().length()));
            }
        }
    }

    @EventHandler
    public void onAchivementAward(PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }
}
