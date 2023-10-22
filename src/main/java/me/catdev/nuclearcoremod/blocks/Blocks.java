package me.catdev.nuclearcoremod.blocks;

import me.catdev.nuclearcoremod.NuclearCoreMod;
import me.catdev.nuclearcoremod.items.CreativeTabs;
import me.catdev.nuclearcoremod.items.Items;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Blocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NuclearCoreMod.MOD_ID);

    public static final RegistryObject<Block> URANIUM_ORE = RegisterBlock("uranium_ore", () -> new DropExperienceBlock(
            BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(),
            UniformInt.of(5, 9)), CreativeTabs.TEST_TAB);

    public static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> ret = BLOCKS.register(name, block);
        RegisterBlockItem(name, ret, tab);
        return ret;
    }

    public static <T extends Block> RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void Register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}