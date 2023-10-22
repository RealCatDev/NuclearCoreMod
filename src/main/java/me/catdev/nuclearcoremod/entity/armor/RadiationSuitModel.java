package me.catdev.nuclearcoremod.entity.armor;

import me.catdev.nuclearcoremod.NuclearCoreMod;
import me.catdev.nuclearcoremod.items.custom.RadiationSuitItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RadiationSuitModel extends AnimatedGeoModel<RadiationSuitItem> {
    @Override
    public ResourceLocation getModelResource(RadiationSuitItem object) {
        return new ResourceLocation(NuclearCoreMod.MOD_ID, "geo/radiation_suit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RadiationSuitItem object) {
        return new ResourceLocation(NuclearCoreMod.MOD_ID, "textures/models/armor/radiation_suit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RadiationSuitItem animatable) {
        return new ResourceLocation(NuclearCoreMod.MOD_ID, "animations/radiation_suit.animation.json");
    }
}