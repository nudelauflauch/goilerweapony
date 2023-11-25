package at.akunatur.goilerweapony.util;

import at.akunatur.goilerweapony.core.init.ItemInit;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {

    public static void addCustomItemProperties() {
        makeBow(ItemInit.CORAL_BOW.get());
    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, pullDur) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });

        ItemProperties.register(item, new ResourceLocation("pull"), (itemStack, clientLevel, livingEntity, pullDur) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
    }

}
