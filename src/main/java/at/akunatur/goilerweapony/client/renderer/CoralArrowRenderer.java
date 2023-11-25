package at.akunatur.goilerweapony.client.renderer;

import at.akunatur.goilerweapony.GoilerWeapony;
import at.akunatur.goilerweapony.common.items.CoralArrowItem;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CoralArrowRenderer extends ArrowRenderer {

    public CoralArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return new ResourceLocation(GoilerWeapony.MODID, "textures/entity/coral_arrow_ammunition.png");
    }
}
