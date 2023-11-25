package at.akunatur.goilerweapony.events;

import at.akunatur.goilerweapony.GoilerWeapony;
import at.akunatur.goilerweapony.client.renderer.CoralArrowRenderer;
import at.akunatur.goilerweapony.core.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoilerWeapony.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.CORAL_ARROW_ENTITY.get(), CoralArrowRenderer::new);
    }

}
