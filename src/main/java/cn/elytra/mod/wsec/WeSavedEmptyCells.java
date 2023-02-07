package cn.elytra.mod.wsec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = WeSavedEmptyCellsTags.MODID,
        version = WeSavedEmptyCellsTags.VERSION,
        name = WeSavedEmptyCellsTags.MODNAME,
        acceptedMinecraftVersions = "[1.7.10]")
public class WeSavedEmptyCells {

    public static final Logger LOGGER = LogManager.getLogger("WeSavedEmptyCells");

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent ignore) {
        LOGGER.info("By the Day We Saved the Empty Cells");
    }
}
