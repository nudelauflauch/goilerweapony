package at.akunatur.goilerweapony.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TeleportHammerItem extends HammerItem{
    public TeleportHammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("goilerweapony.teleport_item_description"));
        pTooltipComponents.add(Component.translatable("goilerweapony.teleport_hammer_description"));
        pTooltipComponents.add(Component.translatable("goilerweapony.teleport_information").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.UNDERLINE));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        TeleportItem.teleport(pLevel, pPlayer, pUsedHand);
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }
}