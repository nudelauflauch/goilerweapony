package at.akunatur.goilerweapony;

import at.akunatur.goilerweapony.core.config.GoilerWeaponyConfig;
import at.akunatur.goilerweapony.core.init.EntityInit;
import at.akunatur.goilerweapony.core.init.ItemInit;
import at.akunatur.goilerweapony.util.ModItemProperties;
import net.minecraft.client.multiplayer.chat.report.ReportEnvironment;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.living.LivingGetProjectileEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GoilerWeapony.MODID)
public class GoilerWeapony {

	public static final String MODID = "goilerweapony";

	public GoilerWeapony() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemInit.ITEMS.register(bus);
		EntityInit.ENTITIES.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
		GoilerWeaponyConfig.register();

		bus.addListener(this::clientSetup);
		bus.addListener(this::addCreative);
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		ModItemProperties.addCustomItemProperties();
	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.COMBAT) {
			event.accept(ItemInit.IRON_HAMMER);
			event.accept(ItemInit.GOLD_HAMMER);
			event.accept(ItemInit.DIAMON_HAMMER);
			event.accept(ItemInit.NETHERITE_HAMMER);
			event.accept(ItemInit.GOLDEN_LIFTER_HAMMER);
			event.accept(ItemInit.UKULELE);
			event.accept(ItemInit.DAGGER);
			event.accept(ItemInit.CORAL_BOW);
			event.accept(ItemInit.CORAL_ARROW);
		} else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ItemInit.LIFTER);
		}
	}
}