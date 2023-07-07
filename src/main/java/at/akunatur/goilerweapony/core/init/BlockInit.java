package at.akunatur.goilerweapony.core.init;

import com.google.common.base.Supplier;

import at.akunatur.goilerweapony.GoilerWeapony;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister
			.create(ForgeRegistries.BLOCKS, GoilerWeapony.MODID);

	public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister
			.create(ForgeRegistries.ITEMS, GoilerWeapony.MODID);
	
	
	
	// Block
	private static <T extends Block> RegistryObject<T> registerBlock(
			String name, Supplier<T> block, CreativeModeTab tab) {
		RegistryObject<T> to_return = BLOCKS.register(name, block);
		registerBlockItem(name, to_return, tab);
		return to_return;
	}

	// Items

	private static <T extends Block> RegistryObject<Item> registerBlockItem(
			String name, RegistryObject<T> block, CreativeModeTab tab) {
		return BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(),
				new Item.Properties()));
	}

}
