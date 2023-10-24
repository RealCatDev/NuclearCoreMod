package me.catdev.nuclearcoremod.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class RadiationEffect extends MobEffect {
    public RadiationEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        // Define a base damage amount
        int baseDamage = 1; // Adjust this as needed

        // Calculate the damage based on the effect's level (amplifier)
        int damage = baseDamage * (amplifier + 1); // You can adjust the multiplier as needed

        // Apply the damage using your custom damage source
        entity.hurt(new DamageSource("death.radiation"), damage);
    }

}
