package me.catdev.nuclearcoremod.init;

import me.catdev.nuclearcoremod.NuclearCoreMod;
import me.catdev.nuclearcoremod.effects.RadiationEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectsInit {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NuclearCoreMod.MOD_ID);

    public static final RegistryObject<MobEffect> RADIATION_EFFECT = EFFECTS.register("radiationeffect",
            () -> new RadiationEffect(MobEffectCategory.HARMFUL,  0x006400));


    public static void Register(IEventBus eventBus){
        EFFECTS.register(eventBus);
    }

}
