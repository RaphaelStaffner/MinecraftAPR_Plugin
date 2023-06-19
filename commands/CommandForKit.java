package rs.newplugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandForKit implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if(sender instanceof Player){
            Player player = (Player) sender;

            ItemStack sword = new ItemStack(Material.WOODEN_SWORD);
            ItemStack axe = new ItemStack(Material.WOODEN_AXE);
            ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
            ItemStack shovel = new ItemStack(Material.WOODEN_SHOVEL);
            ItemStack meat = new ItemStack(Material.COOKED_BEEF, 12);
            ItemStack stone = new ItemStack(Material.COBBLESTONE, 32);

            player.getInventory().addItem(sword, axe, pickaxe, shovel, meat, stone);

        }

        return true;
    }
}
