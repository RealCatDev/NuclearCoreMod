package me.catdev.nuclearcoremod.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RadiationUtils {

    public static List<BlockPos> positions = new ArrayList<>();

    public static int GetRadiationStrength(Position pos) {
        List<BlockPos> sources = positions.stream().filter(p -> p.distToCenterSqr(pos) < 10).collect(Collectors.toList());

        int strength = 0;
        for (BlockPos source : sources) {
            double distance = source.distToCenterSqr(pos);
            strength += Math.round(distance);
        }

        return strength;
    }

    public static boolean IsInRange(LivingEntity ent) {
        return GetRadiationStrength(Vec3.atCenterOf(ent.blockPosition())) > 0;
    }

}
