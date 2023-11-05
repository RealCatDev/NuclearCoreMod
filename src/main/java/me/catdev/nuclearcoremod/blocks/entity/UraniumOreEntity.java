package me.catdev.nuclearcoremod.blocks.entity;

import me.catdev.nuclearcoremod.blocks.custom.UraniumOre;
import me.catdev.nuclearcoremod.init.BlockEntityInit;
import me.catdev.nuclearcoremod.init.EffectsInit;
import me.catdev.nuclearcoremod.init.ItemsInit;
import me.catdev.nuclearcoremod.utils.TickableBlockEntity;
import me.catdev.nuclearcoremod.utils.RadiationUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class UraniumOreEntity extends BlockEntity implements TickableBlockEntity {
    public UraniumOreEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.URANIUM_ORE_BLOCK.get(), pos, state);
    }
    @Override
    public void tick() {
        // Find the radiation source dynamically in the world
        BlockPos radiationSourcePos = null;
        if ((radiationSourcePos = findRadiationSourcePosition()) == null) return;

        // Get all entities within a 10-block radius of the radiation source
        List<Entity> entities = level.getEntities((Entity)null, new AABB(radiationSourcePos.offset(-10, -10, -10), radiationSourcePos.offset(10, 10, 10)), entity -> entity instanceof LivingEntity);

        for (Entity entity : entities) {
            if (!(entity instanceof LivingEntity)) continue;
            LivingEntity livingEntity = ((LivingEntity) entity);
            if (RadiationUtils.IsInRange(livingEntity)) {
//                if (livingEntity instanceof Player) {
//                    Player plr = ((Player)livingEntity);
//                    if (plr.getInventory().getArmor(3).getItem() == ItemsInit.RADIATION_MASK.get()) continue;
//                }
                livingEntity.addEffect(new MobEffectInstance(EffectsInit.RADIATION_EFFECT.get(), 200, RadiationUtils.GetRadiationStrength(Vec3.atCenterOf(entity.blockPosition()))));
            }
        }
    }

    public BlockPos findRadiationSourcePosition() {
        BlockPos currentPos = worldPosition;

        BlockState blockState = level.getBlockState(currentPos);
        if (blockState == null) return null;
        Block block = blockState.getBlock();

        if (block instanceof UraniumOre) {
            if (!RadiationUtils.positions.contains(currentPos)) RadiationUtils.positions.add(currentPos);
            return currentPos;
        }

        return null;
    }
}