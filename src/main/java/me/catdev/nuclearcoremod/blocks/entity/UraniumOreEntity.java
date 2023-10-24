package me.catdev.nuclearcoremod.blocks.entity;

import me.catdev.nuclearcoremod.init.BlockEntityInit;
import me.catdev.nuclearcoremod.utils.TickableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class UraniumOreEntity extends BlockEntity implements TickableBlockEntity {
    public UraniumOreEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.URANIUM_ORE_BLOCK.get(), pos, state);
    }
    @Override
    public void tick() {

    }
}
