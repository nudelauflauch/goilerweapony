package at.akunatur.goilerweapony.common.items;

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
        float break_gesch;

        if (tier == Tiers.NETHERITE) {
            break_gesch = 3.1F;
        } else if (tier == Tiers.DIAMOND) {
            break_gesch = 3.0F;
        } else if (tier == Tiers.GOLD) {
            break_gesch = 3.7F;
        } else if (tier == Tiers.IRON) {
            break_gesch = 2.4F;
        } else {
            break_gesch = 1.0F;
        }

        return pState.getMaterial() == Material.STONE ? break_gesch: 1.0F;
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return pBlock.getMaterial() == Material.STONE;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.SWORD_SWEEP.equals(toolAction);
    }
}