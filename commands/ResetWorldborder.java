package rs.newplugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetWorldborder implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if(sender instanceof Player){
            ((Player) sender).getWorld().getWorldBorder().setCenter(new Location(((Player) sender).getWorld(),0,0,0));
            ((Player) sender).getWorld().getWorldBorder().setSize(30000000);

        }

        return true;
    }
}
