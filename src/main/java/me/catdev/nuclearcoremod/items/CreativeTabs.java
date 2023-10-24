package me.catdev.nuclearcoremod.items;

import me.catdev.nuclearcoremod.init.ItemsInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabs {

    public static final CreativeModeTab NUCLEARCORE = new CreativeModeTab("Nuclear Core") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemsInit.RADIATION_METER.get());
        }
    };

}
