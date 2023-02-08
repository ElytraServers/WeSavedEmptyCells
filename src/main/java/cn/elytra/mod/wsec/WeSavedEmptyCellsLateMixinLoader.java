package cn.elytra.mod.wsec;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import cpw.mods.fml.common.Loader;

@LateMixin
public class WeSavedEmptyCellsLateMixinLoader implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.we_saved_empty_cells.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> mixins = Lists.newArrayList("MixinItemCell");

        if (Loader.isModLoaded("ExtraUtilities")) {
            WeSavedEmptyCells.LOGGER.info("Extra Utilities found, applying MixinBlockDrum");
            mixins.add("MixinBlockDrum");
        }

        return ImmutableList.copyOf(mixins);
    }
}
