/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [Jan 21, 2014, 9:18:28 PM (GMT)]
 */
package org.violetmoon.zeta.block.be;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class ZetaBlockEntity extends BlockEntity {

	public ZetaBlockEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
		super(tileEntityTypeIn, pos, state);
	}

	@Override
	protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider provider) {
		super.saveAdditional(nbt, provider);
		
		writeSharedNBT(nbt);
	}

	@Override
	public void loadWithComponents(CompoundTag nbt, HolderLookup.Provider provider) {
		super.loadWithComponents(nbt, provider);

		readSharedNBT(nbt);
	}

	public void writeSharedNBT(CompoundTag cmp) {
		// NO-OP
	}

	public void readSharedNBT(CompoundTag cmp) {
		// NO-OP
	}
	
	public void sync() {
		if(getLevel() instanceof ServerLevel slevel) {
			slevel.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
		}
	}
	
	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag cmp = new CompoundTag();
		writeSharedNBT(cmp);
		return cmp;
	}
	
	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
		super.onDataPacket(net, packet);
		
		if(packet != null)
			readSharedNBT(packet.getTag());
	}

}
