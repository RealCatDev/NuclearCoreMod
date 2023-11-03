package me.catdev.nuclearcoremod.items.custom;

import me.catdev.nuclearcoremod.NuclearCoreMod;
import me.catdev.nuclearcoremod.blocks.entity.UraniumOreEntity;
import me.catdev.nuclearcoremod.init.ItemsInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBossEventPacket;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;


public class RadiationMeterItem extends Item {

    private static UraniumOreEntity uraniumOre;

    public RadiationMeterItem(Properties pProperties) {
        super(pProperties);
    }


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase == TickEvent.Phase.START) {
            // Check if the player is holding your RadiationMeterItem in the main hand (right hand)
            ItemStack heldItem = event.player.getMainHandItem();
            Item radiationMeterItem = ItemsInit.RADIATION_METER.get(); // Get the RadiationMeterItem

            if (heldItem.isEmpty() && heldItem.getItem() == radiationMeterItem) {
                // Do something when the RadiationMeterItem is in the player's right hand
                // For example, check the distance to the radiation source

                double distance = calculateDistanceToRadiationSource(event.player);
                Component actionBarMessage = Component.translatable("commands.title.show.actionbar.single.nuclearcoremod.radiationmeter", String.format("%.2f", distance));
                event.player.displayClientMessage(actionBarMessage, true);

            }
        }
    }


    private static double calculateDistanceToRadiationSource(Player player) {
        BlockPos radiationSource = uraniumOre.findRadiationSourcePosition();

        if (radiationSource != null) {
            // Calculate the distance using player's position and radiation source position
            double distance = player.distanceToSqr(radiationSource.getX() + 0.5, radiationSource.getY() + 0.5, radiationSource.getZ() + 0.5);
            return Math.sqrt(distance);
        } else {
            // Handle the case when the radiation source is not found
            return Double.MAX_VALUE; // A very large distance to indicate it's not found
        }
    }




}
