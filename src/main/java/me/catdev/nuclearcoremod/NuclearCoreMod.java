package me.catdev.nuclearcoremod;

import com.mojang.logging.LogUtils;
import me.catdev.nuclearcoremod.items.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(NuclearCoreMod.MOD_ID)
public class NuclearCoreMod
{
    public static final String MOD_ID = "nuclearcoremod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NuclearCoreMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Items.Register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents  {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)  {

        }
    }
}