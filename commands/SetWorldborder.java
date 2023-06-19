package rs.newplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWorldborder implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if (sender instanceof Player) {
            ((Player) sender).getWorld().getWorldBorder().setCenter(((Player) sender).getLocation());
            ((Player) sender).getWorld().getWorldBorder().setSize(50);

        }

        return true;
    }
}
