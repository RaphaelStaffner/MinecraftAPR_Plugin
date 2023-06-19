package rs.newplugin.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import rs.newplugin.MyPlugin;

public class DeathListenerInstanceExample implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        new BukkitRunnable(){
            @Override
            public void run(){
                System.out.println("I want waffle fries");
            }
        }.runTaskLater(MyPlugin.getPlugin(), 20L);
    }
}
