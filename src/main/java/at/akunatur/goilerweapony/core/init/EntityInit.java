package at.akunatur.goilerweapony.core.init;

import at.akunatur.goilerweapony.GoilerWeapony;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {
	
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, GoilerWeapony.MODID);

	
	
}
