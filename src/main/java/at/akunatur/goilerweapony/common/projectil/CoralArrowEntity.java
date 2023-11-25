package at.akunatur.goilerweapony.common.projectil;

import at.akunatur.goilerweapony.core.init.EntityInit;
import at.akunatur.goilerweapony.core.init.ItemInit;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class CoralArrowEntity extends Arrow {

    public CoralArrowEntity(EntityType<CoralArrowEntity> type, Level pLevel) {
        super(type, pLevel);
    }

    public CoralArrowEntity(Level level, double x, double y, double z) {
        this(EntityInit.CORAL_ARROW_ENTITY.get(), level);
        this.setPos(x,y,z);
        setBaseDamage(3);
    }

    public CoralArrowEntity(Level level, LivingEntity shooter) {
        this(level, shooter.getX(),shooter.getY() + (double)shooter.getEyeHeight() - (double)0.1F, shooter.getZ());
        this.setOwner(shooter);
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(ItemInit.CORAL_ARROW.get());
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public float getWaterInertia() {
        return 1;
    }
}
