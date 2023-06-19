package rs.newplugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rs.newplugin.MyPlugin;

public class SetSpawnCommand implements CommandExecutor {
    private final MyPlugin plugin;

    public SetSpawnCommand(MyPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            Location location = player.getLocation();

            plugin.getConfig().set("spawn", location);

            plugin.saveConfig();
            player.sendMessage("Spawn Location set!");
        }else{
            System.out.println("Get your Ass on the server.");
        }
        return true;
    }
}
