package rs.newplugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerEvents implements Listener {




    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        if(p.hasPlayedBefore()){
            e.setJoinMessage(ChatColor.GREEN +  "Welcome back to the server " + ChatColor.RED + ChatColor.BOLD + p.getDisplayName() + ChatColor.GREEN +  "! We missed you!" );
        }
        else{
            e.setJoinMessage(ChatColor.BLUE +  "Welcome to the server " + ChatColor.RED + ChatColor.BOLD + p.getDisplayName() + ChatColor.BLUE +  "! Enjoy your time!" );
        }


    }
    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent e){
        Player player = e.getPlayer();
        player.sendMessage("You have sleeped in a bed, so now you are as good as dead");
        player.setHealth(0.5);
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20,2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 10,10));
    }

    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent e){

        Player player = e.getPlayer();
        Entity entity = e.getEntity();

        if(entity.getType() == EntityType.SHEEP){
            e.setCancelled(true);
            player.sendMessage("You can't shear sheeps here");
        }
        else{
            player.sendMessage("This is not a sheep");
        }
    }

}
