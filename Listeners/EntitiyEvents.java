package rs.newplugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class EntitiyEvents implements Listener {

    @EventHandler
    public void onCreeperExplosionRespawnIt(EntityExplodeEvent e) {
        e.getEntity().getWorld().spawnEntity(e.getLocation(), EntityType.CREEPER);
    }

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();

        if (e.getRightClicked() instanceof ArmorStand) {


            Inventory invAR = p.getPlayer().getServer().createInventory(null, 9, "Armorstand");

            ItemStack Item0 = new ItemStack(Material.COBBLESTONE);
            ItemStack Item1 = new ItemStack(Material.STICK);
            ItemStack Item2 = new ItemStack(Material.NAME_TAG);


            invAR.setItem(1, Item0);
            invAR.setItem(4, Item1);
            invAR.setItem(7, Item2);

            p.getPlayer().openInventory(invAR);
        }

    }
@EventHandler
public void EntityHit(EntityDeathEvent e){
        Entity deadentity = e.getEntity();
        World w = e.getEntity().getWorld();
        Location l = e.getEntity().getLocation();

    if(deadentity.getType() == EntityType.CREEPER){
        w.dropItem(l,new ItemStack(Material.FIREWORK_ROCKET,2));
    }
    if(deadentity.getType() == EntityType.ENDERMAN){
        w.dropItem(l, new ItemStack(Material.ENDER_EYE));
    }
    
}
}
