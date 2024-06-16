package org.violetmoon.zetaimplforge.client.event.play;

import net.minecraft.client.player.Input;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.client.event.MovementInputUpdateEvent;
import org.violetmoon.zeta.client.event.play.ZInputUpdate;

public record ForgeZInputUpdate(MovementInputUpdateEvent e) implements ZInputUpdate {
	@Override
	public Input getInput() {
		return e.getInput();
	}

	@Override
	public Player getEntity() {
		return e.getEntity();
	}
}
