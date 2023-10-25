package me.catdev.nuclearcoremod.effects;

import com.mojang.logging.LogUtils;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.slf4j.Logger;

public class RadiationEffect extends MobEffect {
    public RadiationEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    // Good job mate!
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        // Define a base damage amount
        int baseDamage = 1; // Adjust this as needed

        // Calculate the damage based on the effect's level (amplifier)
        int damage = baseDamage * (amplifier + 1); // You can adjust the multiplier as needed

        // Apply the damage using your custom damage source
        entity.hurt(new DamageSource("nuclearcoremod.radiation"), damage);
    }

}
