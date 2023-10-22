package me.catdev.nuclearcoremod.entity.armor;

import me.catdev.nuclearcoremod.items.custom.RadiationSuitItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class RadiationSuitRenderer extends GeoArmorRenderer<RadiationSuitItem> {
    public RadiationSuitRenderer() {
        super(new RadiationSuitModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
