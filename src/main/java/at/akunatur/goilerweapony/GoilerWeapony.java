package at.akunatur.goilerweapony;

import at.akunatur.goilerweapony.core.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GoilerWeapony.MODID)
public class GoilerWeapony {

	public static final String MODID = "goilerweapony";

	public GoilerWeapony() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemInit.ITEMS.register(bus);
		MinecraftForge.EVENT_BUS.register(this);

		bus.addListener(this::addCreative);
	}

	private void addCreative(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == CreativeModeTabs.COMBAT) {
			event.accept(ItemInit.IRON_HAMMER);
			event.accept(ItemInit.GOLD_HAMMER);
			event.accept(ItemInit.DIAMON_HAMMER);
			event.accept(ItemInit.NETHERITE_HAMMER);
			event.accept(ItemInit.GOLDEN_LIFTER_HAMMER);
		} else if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ItemInit.LIFTER);
		}
	}
}