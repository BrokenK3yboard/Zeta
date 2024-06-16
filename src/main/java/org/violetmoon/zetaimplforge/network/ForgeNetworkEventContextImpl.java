package org.violetmoon.zetaimplforge.network;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;
import org.violetmoon.zeta.network.IZetaNetworkEventContext;
import org.violetmoon.zeta.network.ZetaHandshakeMessage;

import net.minecraft.server.level.ServerPlayer;

public class ForgeNetworkEventContextImpl implements IZetaNetworkEventContext {
	private final NetworkEvent.Context ctx;
	private final SimpleChannel channel;

	public ForgeNetworkEventContextImpl(NetworkEvent.Context ctx, SimpleChannel channel) {
		this.ctx = ctx;
		this.channel = channel;
	}

	@Override
	public CompletableFuture<Void> enqueueWork(Runnable runnable) {
		return ctx.enqueueWork(runnable);
	}

	@Override
	public @Nullable ServerPlayer getSender() {
		return ctx.getSender();
	}

	@Override
	public void reply(ZetaHandshakeMessage msg) {
		channel.reply(msg, ctx);
	}
}
