package at.akunatur.goilerweapony;

import at.akunatur.goilerweapony.core.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GoilerWeapony.MODID)
public class GoilerWeapony {
	
	public static final String MODID = "goilerweapony";

	public GoilerWeapony() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemInit.ITEMS.register(bus);
		MinecraftForge.EVENT_BUS.register(this);
	}
}