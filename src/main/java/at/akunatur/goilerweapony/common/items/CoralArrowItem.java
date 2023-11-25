package at.akunatur.goilerweapony.common.items;

import at.akunatur.goilerweapony.common.projectil.CoralArrowEntity;
import at.akunatur.goilerweapony.core.init.ItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CoralArrowItem extends ArrowItem {
    public CoralArrowItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new CoralArrowEntity(pLevel, pShooter);
    }

}
