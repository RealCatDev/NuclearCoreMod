package me.catdev.nuclearcoremod;

import com.mojang.logging.LogUtils;
import me.catdev.nuclearcoremod.blocks.Blocks;
import me.catdev.nuclearcoremod.entity.armor.RadiationSuitRenderer;
import me.catdev.nuclearcoremod.items.Items;
import me.catdev.nuclearcoremod.items.custom.RadiationSuitItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod(NuclearCoreMod.MOD_ID)
public class NuclearCoreMod
{
    public static final String MOD_ID = "nuclearcoremod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NuclearCoreMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Blocks.Register(modEventBus);
        Items.Register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents  {
        @SubscribeEvent
        public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
            GeoArmorRenderer.registerArmorRenderer(RadiationSuitItem.class, new RadiationSuitRenderer());
        }
    }
}
