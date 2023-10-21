package me.catdev.nuclearcoremod.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabs {

    public static final CreativeModeTab TEST_TAB = new CreativeModeTab("testtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.TEST_ITEM.get());
        }
    };

}
