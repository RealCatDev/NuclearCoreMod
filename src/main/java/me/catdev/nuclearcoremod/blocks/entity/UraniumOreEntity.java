package me.catdev.nuclearcoremod.blocks.entity;

import me.catdev.nuclearcoremod.NuclearCoreMod;
import me.catdev.nuclearcoremod.init.BlockEntityInit;
import me.catdev.nuclearcoremod.init.EffectsInit;
import me.catdev.nuclearcoremod.utils.TickableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class UraniumOreEntity extends BlockEntity implements TickableBlockEntity {
    public UraniumOreEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.URANIUM_ORE_BLOCK.get(), pos, state);
    }
    @Override
    public void tick() {
        // Check player proximity and apply the radiation effect
        Player closestPlayer = level.getNearestPlayer(worldPosition.getX() + 0.5, worldPosition.getY() + 0.5, worldPosition.getZ() + 0.5, -1.0, player -> true);

        if (closestPlayer != null) {
            double distance = closestPlayer.distanceToSqr(worldPosition.getX() + 0.5, worldPosition.getY() + 0.5, worldPosition.getZ() + 0.5);

            // Increase the distance by 10 blocks (10 meters)
            double triggerDistance = 10.0 * 10.0; // 10 blocks * 10 blocks = 100.0 (meters)

            if (distance < triggerDistance) {
                // Calculate the strength of the radiation effect based on the distance
                int effectStrength = (int)(10.0 - Math.sqrt(distance)); // Adjust this formula as needed

                if (effectStrength > 0) {
                    closestPlayer.addEffect(new MobEffectInstance(EffectsInit.RADIATION_EFFECT.get(), 200, effectStrength - 1));
                }
            }
        }
    }
}
