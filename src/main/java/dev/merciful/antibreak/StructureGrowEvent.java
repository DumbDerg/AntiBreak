package dev.merciful.antibreak;

import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class StructureGrowEvent implements Listener {


    // Stops a player from using a sapling/mushroom to break the endportal or gateways
    @EventHandler(priority = EventPriority.NORMAL)
    public void growEvent(org.bukkit.event.world.StructureGrowEvent e){
        for (BlockState state : e.getBlocks()){
            if (AntiBreak.blocks.contains(state.getBlock().getType())){
                e.setCancelled(true);
            }

        }

    }
}