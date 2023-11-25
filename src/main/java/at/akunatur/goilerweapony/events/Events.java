package at.akunatur.goilerweapony.events;

import at.akunatur.goilerweapony.GoilerWeapony;
import at.akunatur.goilerweapony.core.init.ItemInit;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingGetProjectileEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoilerWeapony.MODID)
public class Events {

    @SubscribeEvent
    public void addProjectil(LivingGetProjectileEvent event) {
        System.out.println(event.getProjectileWeaponItemStack());
        if (event.getEntity() instanceof ServerPlayer) {
            event.setProjectileItemStack(new ItemStack(ItemInit.CORAL_ARROW.get()));
        }
    }

}
