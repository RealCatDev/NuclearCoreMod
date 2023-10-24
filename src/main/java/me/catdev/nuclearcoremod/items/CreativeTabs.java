package me.catdev.nuclearcoremod.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabs {

    public static final CreativeModeTab NUCLEARCORE = new CreativeModeTab("Nuclear Core") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.RADIATION_METER.get());
        }
    };

}
