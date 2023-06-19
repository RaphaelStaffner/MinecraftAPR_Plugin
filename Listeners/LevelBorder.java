package rs.newplugin.Listeners;

import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class LevelBorder implements Listener {

    @EventHandler
    public void LevelBorder(PlayerLevelChangeEvent e){
        Player p = e.getPlayer();
        WorldBorder wb = e.getPlayer().getWorld().getWorldBorder();

        int Level = e.getNewLevel();
        if(Level == 0) {
            Level = 1;
        }
        wb.setCenter(e.getPlayer().getWorld().getSpawnLocation());
        wb.setSize(e.getNewLevel());

    }
    @EventHandler
    public void LevelBorderWorldSwitch(PlayerChangedWorldEvent e){
        Player p = e.getPlayer();
        WorldBorder wb = p.getWorld().getWorldBorder();
        int Level = p.getLevel();
        if(Level == 0) {
            Level = 1;
        }
        wb.setCenter(e.getPlayer().getWorld().getSpawnLocation());
        wb.setSize(p.getLevel());
    }
}
