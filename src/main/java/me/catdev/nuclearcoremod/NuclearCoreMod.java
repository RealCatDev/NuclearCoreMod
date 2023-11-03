package me.catdev.nuclearcoremod;

import com.mojang.logging.LogUtils;
import me.catdev.nuclearcoremod.entity.armor.RadiationSuitRenderer;
import me.catdev.nuclearcoremod.init.BlockEntityInit;
import me.catdev.nuclearcoremod.init.BlockInit;
import me.catdev.nuclearcoremod.init.EffectsInit;
import me.catdev.nuclearcoremod.init.ItemsInit;
import me.catdev.nuclearcoremod.items.custom.RadiationSuitArmorItem;
import me.catdev.nuclearcoremod.world.features.ModConfiguredFeatures;
import me.catdev.nuclearcoremod.world.features.ModPlacedFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
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

        BlockInit.Register(modEventBus);
        BlockEntityInit.Register(modEventBus);

        ItemsInit.Register(modEventBus);
        EffectsInit.Register(modEventBus);

        ModConfiguredFeatures.Register(modEventBus);
        ModPlacedFeatures.Register(modEventBus);



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
            GeoArmorRenderer.registerArmorRenderer(RadiationSuitArmorItem.class, new RadiationSuitRenderer());
        }
    }
}
