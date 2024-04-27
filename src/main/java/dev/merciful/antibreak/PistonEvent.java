package dev.merciful.antibreak;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonRetractEvent;

public class PistonEvent implements Listener {

    // Cancels the retract event if it detects an illegal block since the retracting of the piston is what breaks it
    @EventHandler(priority = EventPriority.NORMAL)
    public void pistonEvent(BlockPistonRetractEvent e){
        int x = e.getBlock().getX();
        int y = e.getBlock().getY();
        int z = e.getBlock().getZ();
        World world = e.getBlock().getWorld();
        // The most common method of breaking is using a down facing piston, but this can be done in any direction
                switch (e.getDirection()) {
                    case DOWN:
                        blockChecker(e,world,x,y-1,z);
                        break;
                    case NORTH:
                        blockChecker(e,world,x,y,z-1);
                        break;
                    case EAST:
                        blockChecker(e,world,x+1,y,z);
                        break;
                    case SOUTH:
                        blockChecker(e,world,x,y,z+1);
                        break;
                    case WEST:
                        blockChecker(e,world,x-1,y,z);
                        break;
                    case UP:
                        blockChecker(e,world,x,y+1,z);
                        break;
                }


        }
        private void blockChecker(BlockPistonRetractEvent e, World world, int x, int y, int z){
            if (AntiBreak.blocks.contains(world.getBlockAt(x,y,z).getType())){

                e.setCancelled(true);

    }
}}
