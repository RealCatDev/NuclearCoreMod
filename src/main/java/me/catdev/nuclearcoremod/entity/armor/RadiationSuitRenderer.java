package me.catdev.nuclearcoremod.entity.armor;

import me.catdev.nuclearcoremod.items.custom.RadiationSuitArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class RadiationSuitRenderer extends GeoArmorRenderer<RadiationSuitArmorItem> {
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
