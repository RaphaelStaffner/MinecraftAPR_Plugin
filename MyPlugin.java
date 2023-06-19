package rs.newplugin;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import rs.newplugin.Listeners.*;
import rs.newplugin.commands.*;

public final class MyPlugin extends JavaPlugin implements Listener {

    private static MyPlugin plugin;
    private Inventory golemIventory;

    public static MyPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        plugin = this;
        getLogger().info("onEnable is called");


        this.getCommand("startkit").setExecutor(new CommandForKit());
        this.getCommand("setWorldboarder").setExecutor(new SetWorldborder());
        this.getCommand("resetWorldboarder").setExecutor(new ResetWorldborder());
        this.getCommand("repeat").setExecutor(new RepeatCommand());
        this.getCommand("setSpawn").setExecutor(new SetSpawnCommand(this));

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new XPBottle(), this);
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getServer().getPluginManager().registerEvents(new EntitiyEvents(), this);
        getServer().getPluginManager().registerEvents(new VillagerEvents(), this);

        //getServer().getPluginManager().registerEvents(new LevelBorder(), this);

        // Create the golem inventory
        golemIventory = Bukkit.createInventory(null, 9, "Irongolem Inventory");

        // Fill the golem inventory with items
        ItemStack ironBar = new ItemStack(Material.IRON_INGOT, 5);
        ItemStack hayBale = new ItemStack(Material.HAY_BLOCK, 5);
        golemIventory.addItem(ironBar, hayBale);

        // Schedule the inventory refill task
        BukkitRunnable refillTask = new BukkitRunnable() {
            @Override
            public void run() {
                golemIventory.addItem(ironBar.clone(), hayBale.clone());
            }
        };
        refillTask.runTaskTimer(this, 0, 5 * 60 * 20); // Run every 5 minutes
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType() == EntityType.IRON_GOLEM) {

            Player player = event.getPlayer();
            player.sendMessage("I am the protector of the village, here is a gift for you");
            player.openInventory(golemIventory);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().equals(golemIventory)) {
            event.setCancelled(true); // Prevent players from modifying the golem inventory
        }
    }








}
