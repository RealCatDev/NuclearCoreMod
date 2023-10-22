package me.catdev.nuclearcoremod.items;

import me.catdev.nuclearcoremod.NuclearCoreMod;
import me.catdev.nuclearcoremod.items.custom.RadiationSuitItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NuclearCoreMod.MOD_ID);

    public static final RegistryObject<Item> RADIATION_METER = ITEMS.register("radiationmeter", () -> new Item(new Item.Properties().tab(CreativeTabs.TEST_TAB)));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new Item(new Item.Properties().tab(CreativeTabs.TEST_TAB)));

    public static final RegistryObject<Item> RADIATION_SUIT_HELMET = ITEMS.register("radiation_suit_helmet", () -> new RadiationSuitItem(ModArmorMaterials.RADIATION_SUIT, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.TEST_TAB)));

    public static void Register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
