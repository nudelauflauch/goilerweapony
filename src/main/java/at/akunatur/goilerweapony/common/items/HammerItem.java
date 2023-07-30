package at.akunatur.goilerweapony.common.items;

import at.akunatur.goilerweapony.core.config.GoilerWeaponyConfig;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class HammerItem extends SwordItem {

    public HammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        Tier tier = this.getTier();
        float break_speed;

        if (tier == Tiers.NETHERITE) {
            break_speed = 3.1F;
        } else if (tier == Tiers.DIAMOND) {
            break_speed = 3.0F;
        } else if (tier == Tiers.GOLD) {
            break_speed = 3.7F;
        } else if (tier == Tiers.IRON) {
            break_speed = 2.4F;
        } else {
            break_speed = 1.0F;
        }

        return GoilerWeaponyConfig.HAMMER_CAN_DESTROY_STONE.get() ? pState.getMaterial() == Material.STONE ? break_speed: 1.0F : super.getDestroySpeed(pStack, pState);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return GoilerWeaponyConfig.HAMMER_CAN_DESTROY_STONE.get() ? pBlock.getMaterial() == Material.STONE : false;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.SWORD_SWEEP.equals(toolAction);
    }
}