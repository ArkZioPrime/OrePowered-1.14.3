package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityMinecartFurnace;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.PoweredMinecart;

@SuppressWarnings("deprecation")
public class CraftMinecartFurnace extends CraftMinecart implements PoweredMinecart {
    public CraftMinecartFurnace(CraftServer server, EntityMinecartFurnace entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftMinecartFurnace";
    }

    @Override
    public EntityType getType() {
        return EntityType.MINECART_FURNACE;
    }
}
