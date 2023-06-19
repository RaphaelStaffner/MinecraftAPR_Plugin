package rs.newplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepeatCommand implements CommandExecutor {

    // /repeat bob is really cool

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;

            // /repeat
            if(args.length == 0){
                p.sendMessage("You didn't provide any arguments!");
                p.sendMessage("Example: /repeat <message here>");
            }
            else{
                String Message = "";
                for (String word: args) {
                    Message += word + " ";
                }

                p.sendMessage("Message: " + Message);
            }
        }

        return true;
    }
}