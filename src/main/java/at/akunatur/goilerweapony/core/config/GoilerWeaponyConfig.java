package at.akunatur.goilerweapony.core.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class GoilerWeaponyConfig {

    public static ForgeConfigSpec.BooleanValue HAMMER_CAN_DESTROY_STONE;

    public static void register() {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        HAMMER_CAN_DESTROY_STONE = COMMON_BUILDER.comment("Defines if hammers can destroy all blocks that are stone or similar\nIf set to true it can break stone").define("hammer_can_destroy_stone", true);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build());
    }

}