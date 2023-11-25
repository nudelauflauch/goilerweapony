package at.akunatur.goilerweapony.common.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class UkuleleItem extends Item {
    public UkuleleItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        for (int i = 0; i < 3; i ++) {
            pLevel.addParticle(ParticleTypes.NOTE,
                    pPlayer.getEyePosition().x + pPlayer.getLookAngle().x + RandomSource.create().nextDouble() / 3 - 0.5,
                    pPlayer.getEyePosition().y + pPlayer.getLookAngle().y + RandomSource.create().nextDouble() / 3 - 0.5,
                    pPlayer.getEyePosition().z + pPlayer.getLookAngle().z - 0.1,
                    0F, 0.2F, 0F
            );
        }

        AABB area = new AABB(pPlayer.getX() - 5, pPlayer.getY() - 5, pPlayer.getZ() - 5, pPlayer.getX() + 5, pPlayer.getY() + 5, pPlayer.getZ() + 5);
        List<Entity> entitys = pLevel.getEntities(pPlayer, area);
        for (Entity entity : entitys) {
            if (entity instanceof PathfinderMob && !(entity instanceof AbstractSkeleton)) {
                Vec3 new_pos = this.runTowards((PathfinderMob) entity, pPlayer);
                ((PathfinderMob) entity).getNavigation().moveTo(new_pos.x, new_pos.y, new_pos.z, 1.5D);

            }
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    private float distToPlayer(Vec3 entity, Vec3 player) {
        double d0 = player.x - entity.x;
        double d1 = player.y - entity.y;
        double squaredDistance = d0 * d0 + d1 * d1;
        return (float) Math.sqrt(squaredDistance);
    }

    private Vec3 runTowards(PathfinderMob entity, Player player) {
        for (int i = 0; i < 100; i++) {
            Vec3 new_pos = DefaultRandomPos.getPos((PathfinderMob) entity, 15, 2);
            if (new_pos != null && this.distToPlayer(new_pos, player.position()) > 12) {
                return new_pos;
            }
        }
        return entity.position();
    }
}
