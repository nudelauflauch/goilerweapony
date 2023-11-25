package at.akunatur.goilerweapony.core.init;

import at.akunatur.goilerweapony.GoilerWeapony;
import at.akunatur.goilerweapony.common.items.*;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister
			.create(ForgeRegistries.ITEMS, GoilerWeapony.MODID);

	public static final RegistryObject<Item> IRON_HAMMER = ITEMS
			.register("iron_hammer", () -> new HammerItem(Tiers.IRON, 5, -2.4F,
					new Item.Properties()));

	public static final RegistryObject<Item> GOLD_HAMMER = ITEMS
			.register("gold_hammer", () -> new HammerItem(Tiers.GOLD, 5, -2.4F,
					new Item.Properties()));

	public static final RegistryObject<Item> DIAMON_HAMMER = ITEMS.register(
			"diamond_hammer", () -> new HammerItem(Tiers.DIAMOND, 5, -2.4F,
					new Item.Properties()));

	public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register(
			"netherite_hammer", () -> new HammerItem(Tiers.NETHERITE, 5, -2.4F,
					new Item.Properties()));

	public static final RegistryObject<Item> UKULELE = ITEMS.register(
			"ukulele", () -> new UkuleleItem(new Item.Properties()));

	public static final RegistryObject<Item> GOLDEN_LIFTER_HAMMER = ITEMS
			.register("golden_lifter_hammer", () -> new TeleportHammerItem(
					Tiers.GOLD, 5, -2.4F,
					new Item.Properties()));

	public static final RegistryObject<Item> LIFTER = ITEMS.register("lifter",
			() -> new TeleportItem(
					new Item.Properties()));

	public static final RegistryObject<Item> DAGGER = ITEMS.register("dagger",
			() -> new SwordItem(Tiers.IRON, -1, -0.6F,
					new Item.Properties()));

	public static final RegistryObject<Item> CORAL_BOW = ITEMS.register("coral_bow",
			() -> new CoralBow(new Item.Properties().durability(128)));

	public static final RegistryObject<Item> CORAL_ARROW = ITEMS.register("coral_arrow",
			() -> new CoralArrowItem(new Item.Properties()));

	public static final RegistryObject<Item> BLOW_PIPE = ITEMS.register("blow_pipe",
			() -> new BowItem(new Item.Properties().durability(128)));
}
