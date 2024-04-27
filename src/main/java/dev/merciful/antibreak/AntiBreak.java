package dev.merciful.antibreak;

import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class AntiBreak extends JavaPlugin {

    public static List<Material> blocks = new ArrayList<>(); // Blocks that shouldn't be broken

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE+"AntiBreak has started!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE+"By Merci<3");

        blocks.add(Material.END_PORTAL_FRAME);
        blocks.add(Material.END_PORTAL);
        blocks.add(Material.END_GATEWAY);


        // Registering events
        getServer().getPluginManager().registerEvents(new StructureGrowEvent(),this);
        getServer().getPluginManager().registerEvents(new PistonEvent(), this);

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE+"AntiBreak has stopped!");
    }
}