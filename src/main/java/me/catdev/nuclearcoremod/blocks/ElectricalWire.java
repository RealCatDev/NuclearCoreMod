package me.catdev.nuclearcoremod.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ElectricalWire extends Block {
    public static final IntegerProperty CURRENT = IntegerProperty.create("current", 0, 8096);

    public ElectricalWire(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CURRENT);
    }
}
