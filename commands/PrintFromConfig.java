package rs.newplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import rs.newplugin.MyPlugin;

import javax.security.auth.login.Configuration;

public class PrintFromConfig implements CommandExecutor {


    Plugin plugin = MyPlugin.getPlugin(MyPlugin.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(cmd.getName().equals("printMessageFromConfig")){
            Player player = (Player) sender;
            String food = plugin.getConfig().getString("Food");
            player.sendMessage(ChatColor.DARK_PURPLE + "The food in the config.yml is " + ChatColor.RED + food);

        }

        return true;
    }
}
