package at.akunatur.goilerweapony.common.items;

import at.akunatur.goilerweapony.core.config.GoilerWeaponyConfig;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Arrays;

public class HammerItem extends SwordItem {

    public HammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        Tier tier = this.getTier();
        float break_speed = 1.0F;

        if (tier == Tiers.NETHERITE) {
            break_speed = 3.1F;
        } else if (tier == Tiers.DIAMOND) {
            break_speed = 3.0F;
        } else if (tier == Tiers.GOLD) {
            break_speed = 3.7F;
        } else if (tier == Tiers.IRON) {
            break_speed = 2.1F;
        }

        if (pState.is(BlockTags.MINEABLE_WITH_PICKAXE) && !GoilerWeaponyConfig.HAMMER_CAN_DESTROY_STONE.get()) {
            return TierSortingRegistry.isCorrectTierForDrops(tier, pState) ? break_speed : super.getDestroySpeed(pStack, pState);
        }
        return super.getDestroySpeed(pStack, pState);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState pBlock) {
        if (pBlock.is(BlockTags.MINEABLE_WITH_PICKAXE) && !GoilerWeaponyConfig.HAMMER_CAN_DESTROY_STONE.get()) {
            return TierSortingRegistry.isCorrectTierForDrops(this.getTier(), pBlock);
        }
        return false;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.SWORD_SWEEP.equals(toolAction);
    }
}