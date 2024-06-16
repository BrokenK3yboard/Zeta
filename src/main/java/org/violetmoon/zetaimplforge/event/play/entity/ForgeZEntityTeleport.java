package org.violetmoon.zetaimplforge.event.play.entity;

import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import org.violetmoon.zeta.event.play.entity.ZEntityTeleport;

public class ForgeZEntityTeleport implements ZEntityTeleport {
    private final EntityTeleportEvent e;

    public ForgeZEntityTeleport(EntityTeleportEvent e) {
        this.e = e;
    }

    @Override
    public Entity getEntity() {
        return e.getEntity();
    }

    @Override
    public double getTargetX() {
        return e.getTargetX();
    }

    @Override
    public double getTargetY() {
        return e.getTargetY();
    }

    @Override
    public double getTargetZ() {
        return e.getTargetZ();
    }

    @Override
    public void setTargetX(double targetX) {
        e.setTargetX(targetX);
    }

    @Override
    public void setTargetY(double targetY) {
        e.setTargetY(targetY);
    }

    @Override
    public void setTargetZ(double targetZ) {
        e.setTargetZ(targetZ);
    }
}
