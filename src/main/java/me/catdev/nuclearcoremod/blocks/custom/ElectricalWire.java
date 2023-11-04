package me.catdev.nuclearcoremod.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

// TODO: Implement
public class ElectricalWire /*extends PipeBlock*/ {
    /*public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public ElectricalWire(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(FACING) == Direction.NORTH || pState.getValue(FACING) == Direction.SOUTH ? Block.box(7, 7, 0, 9, 9, 16) : pState.getValue(FACING) == Direction.EAST || pState.getValue(FACING) == Direction.WEST ? Block.box(0, 7, 7, 16, 9, 9) : Block.box(7, 0, 7, 9, 16, 9);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        return this.getWireState(state, pContext, state.getValue(FACING));
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
//        if (level.getBlockState(neighbor).getBlock() == ElectricalWire.this)
    }

    public enum Type implements StringRepresentable {
        CORNER_TOP("corner_top"),
        CORNER_BOTTOM("corner_bottom"),
        CORNER_LEFT("corner_left"),
        CORNER_RIGHT("corner_right");

//        TEE_TB("tee_tb"),
//        TEE_TL("tee_tl"),
//        TEE_TR("tee_tr"),
//        TEE_TFRONT("tee_tfront"),
//
//        TEE_BL("tee_bl"),
//        TEE_BR("tee_br"),
//        TEE_BFRONT("tee_bfront"),
//        TEE_("corner_left");

        private final String id;

        Type(String id) {
            this.id = id;
        }

        @Override
        public String getSerializedName()
        {
            return id;
        }

        @Override
        public String toString()
        {
            return id;
        }
    }*/
}
