package me.catdev.nuclearcoremod.init;

import me.catdev.nuclearcoremod.NuclearCoreMod;
import me.catdev.nuclearcoremod.items.CreativeTabs;
import me.catdev.nuclearcoremod.items.ModArmorMaterials;
import me.catdev.nuclearcoremod.items.custom.RadiationMeterItem;
import me.catdev.nuclearcoremod.items.custom.RadiationSuitArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NuclearCoreMod.MOD_ID);

    public static final RegistryObject<Item> RADIATION_METER = ITEMS.register("radiationmeter", () -> new RadiationMeterItem(new Item.Properties().tab(CreativeTabs.NUCLEARCORE)));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new Item(new Item.Properties().tab(CreativeTabs.NUCLEARCORE)));
    public static final RegistryObject<Item> RADIATION_MASK = ITEMS.register("radiation_mask", () -> new RadiationSuitArmorItem(ModArmorMaterials.RADIATION_SUIT, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.NUCLEARCORE)));

    public static void Register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
