package org.violetmoon.zetaimplforge.mixin.mixins.client;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.core.Holder.Reference;
import net.minecraft.world.level.block.Block;

@Mixin(BlockColors.class)
public interface AccessorBlockColors {
	@Accessor("f_92571_")
	Map<Reference<Block>, BlockColor> zeta$getBlockColors();
}
