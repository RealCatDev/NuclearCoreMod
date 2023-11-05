package me.catdev.nuclearcoremod.effects;

import com.mojang.logging.LogUtils;
import me.catdev.nuclearcoremod.init.ItemsInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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
        if (entity instanceof Player) {
            Player plr = ((Player)entity);
            if (plr.getInventory().getArmor(3).getItem() == ItemsInit.RADIATION_MASK.get()) return;
        }
        int baseDamage = 1;
        int damage = baseDamage * (amplifier + 1);
        entity.hurt(new DamageSource("nuclearcoremod.radiation"), damage);
    }

}
