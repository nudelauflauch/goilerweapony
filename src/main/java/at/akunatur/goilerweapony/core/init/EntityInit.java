package at.akunatur.goilerweapony.core.init;

import at.akunatur.goilerweapony.GoilerWeapony;
import at.akunatur.goilerweapony.common.projectil.CoralArrowEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister
			.create(ForgeRegistries.ENTITY_TYPES, GoilerWeapony.MODID);


	public static final RegistryObject<EntityType<CoralArrowEntity>> CORAL_ARROW_ENTITY = ENTITIES.register(
		"corral_arrow_entity", () -> EntityType.Builder.<CoralArrowEntity>of(CoralArrowEntity::new, MobCategory.MISC)
					.sized(0.5F, 0.5F)
					.clientTrackingRange(4).updateInterval(20)
					.build(new ResourceLocation(GoilerWeapony.MODID, "corral_arrow_entity").toString()));

}
