package rs.newplugin.Listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottle implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e){
        e.setShowEffect(false);

    }
}
