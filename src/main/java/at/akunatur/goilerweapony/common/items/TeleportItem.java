package at.akunatur.goilerweapony.common.items;

import java.util.List;

import at.akunatur.goilerweapony.GoilerWeapony;
import at.akunatur.goilerweapony.core.init.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fml.loading.FMLLoader;
import org.jetbrains.annotations.Nullable;

public class TeleportItem extends Item {

    public TeleportItem(Properties pProperties) {
        super(pProperties.durability(4));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable(GoilerWeapony.MODID + ".teleport_item_description"));
        pTooltipComponents.add(Component.translatable("goilerweapony.teleport_information").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.UNDERLINE));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        TeleportItem.teleport(pLevel, pPlayer, pUsedHand);
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    public static void teleport(Level pLevel, Player pPlayer, InteractionHand pUsedHand){
        if (!pLevel.isClientSide() && !pPlayer.isOnFire() && !pPlayer.isFallFlying() && pPlayer.fallDistance < 0.5f) {

            Position playerPos = pPlayer.position();
            ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

            int damageAmount;
            if (itemStack.getItem() == ItemInit.LIFTER.get()) {
                damageAmount = 1;
            } else {
                damageAmount = 4;
            }

            pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
            pPlayer.getCooldowns().addCooldown(ItemInit.LIFTER.get(),40);
            pPlayer.getCooldowns().addCooldown(ItemInit.GOLDEN_LIFTER_HAMMER.get(),40);

            AABB area = new AABB(playerPos.x() - 3, playerPos.y() , playerPos.z() - 3,
                    playerPos.x() + 3, playerPos.y() - 390, playerPos.z() + 3);

            List<Entity> entitys = pLevel.getEntities(pPlayer, area);
            for (Entity entity : entitys) {
                if (entity != pPlayer && entity instanceof Player) {
                    entity.teleportTo(playerPos.x(), playerPos.y(), playerPos.z());

                    itemStack.hurtAndBreak(damageAmount, pPlayer, (thing) -> {
                        thing.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                    });
                }

                //for testing only
                if (!FMLLoader.isProduction()) {
                    entity.teleportTo(playerPos.x(), playerPos.y(), playerPos.z());
                    itemStack.hurtAndBreak(damageAmount, pPlayer, (thing) -> {
                        thing.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                    });
                }


                if (itemStack.getMaxDamage() - itemStack.getDamageValue() - damageAmount < 0) {
                    break;
                }
            }
        }
    }
}