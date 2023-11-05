package me.catdev.nuclearcoremod.items.custom;

import me.catdev.nuclearcoremod.NuclearCoreMod;
import me.catdev.nuclearcoremod.blocks.entity.UraniumOreEntity;
import me.catdev.nuclearcoremod.init.ItemsInit;
import me.catdev.nuclearcoremod.utils.ITextRenderable;
import me.catdev.nuclearcoremod.utils.RadiationUtils;
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

import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;


// Create a capability interface to provide the text content


// Implement the capability in your item's class
public class RadiationMeterItem extends Item implements ITextRenderable {
    private String textToRender = "0.00"; // Initial text

    public RadiationMeterItem(Properties pProperties) {
        super(pProperties);
    }

    // Implement the ITextRenderable methods
    @Override
    public String getText() {
        return textToRender;
    }

    @Override
    public void setText(String text) {
        textToRender = text;
    }


    // Create an event handler to trigger text rendering
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            ItemStack heldItem = event.player.getMainHandItem();
            Item radiationMeterItem = ItemsInit.RADIATION_METER.get();

            if (!heldItem.isEmpty() && heldItem.getItem() == radiationMeterItem) {
                CompoundNBT nbt = heldItem.getOrCreateTag();
                String textToRender = nbt.getString("textToRender");

                // Render the text at a specific position on the screen or in the game world
                renderText(textToRender, event.player);
            }
        }
    }


    // Render text in the game world or on the screen
    private static void renderText(String text, Player player) {
        // Use Minecraft's built-in text rendering methods to display the text
        // You can specify the position and style of the rendered text
        // For example, you can use drawString or drawCenteredString methods
    }
}
